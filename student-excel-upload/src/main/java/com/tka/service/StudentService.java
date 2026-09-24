package com.tka.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tka.entity.Student;
import com.tka.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Map<String, Object> processExcel(MultipartFile file)
            throws IOException {

        int totalRows = 0;
        int insertedCount = 0;

        List<Map<String, Object>> errors = new ArrayList<>();

        // Used to check duplicates inside Excel file
        Set<String> uploadedEmails = new HashSet<>();
        Set<String> uploadedMobiles = new HashSet<>();

        InputStream inputStream = file.getInputStream();

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter formatter = new DataFormatter();

        /*
         * Check whether Excel contains data rows
         */
        if (sheet.getLastRowNum() < 1) {

            workbook.close();

            throw new IllegalArgumentException(
                    "Excel file does not contain any data rows");
        }

        /*
         * Check Excel header
         */
        Row headerRow = sheet.getRow(0);

        if (headerRow == null) {

            workbook.close();

            throw new IllegalArgumentException(
                    "Excel header row is missing");
        }

        String[] expectedHeaders = {
                "student_name",
                "email",
                "mobile",
                "course",
                "city",
                "fees"
        };

        for (int i = 0; i < expectedHeaders.length; i++) {

            String actualHeader =
                    formatter.formatCellValue(headerRow.getCell(i)).trim();

            if (!expectedHeaders[i].equalsIgnoreCase(actualHeader)) {

                workbook.close();

                throw new IllegalArgumentException(
                        "Invalid Excel header. Expected column: "
                                + expectedHeaders[i]);
            }
        }

        /*
         * Process every Excel row
         */
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            // Excel row number shown to user
            int excelRowNumber = i + 1;

            totalRows++;

            List<String> rowErrors = new ArrayList<>();

            /*
             * Read cells
             */
            String studentName =
                    getCellValue(row, 0, formatter);

            String email =
                    getCellValue(row, 1, formatter);

            String mobile =
                    getCellValue(row, 2, formatter);

            String course =
                    getCellValue(row, 3, formatter);

            String city =
                    getCellValue(row, 4, formatter);

            String fees =
                    getCellValue(row, 5, formatter);

            /*
             * =====================================
             * 1. STUDENT NAME VALIDATION
             * =====================================
             */

            if (studentName.isEmpty()) {

                rowErrors.add("Student name is mandatory");

            } else if (studentName.length() < 3) {

                rowErrors.add(
                        "Student name must contain at least 3 characters");
            }

            /*
             * =====================================
             * 2. EMAIL VALIDATION
             * =====================================
             */

            boolean validEmail = false;

            if (email.isEmpty()) {

                rowErrors.add("Email is mandatory");

            } else if (!isValidEmail(email)) {

                rowErrors.add("Invalid email format");

            } else {

                validEmail = true;
            }

            /*
             * Check duplicate email
             * Only when email format is valid
             */
            if (validEmail) {

                if (uploadedEmails.contains(email.toLowerCase())) {

                    rowErrors.add(
                            "Duplicate email in uploaded Excel file");

                } else if (studentRepository.existsByEmail(email)) {

                    rowErrors.add(
                            "Email already exists in database");

                } else {

                    uploadedEmails.add(email.toLowerCase());
                }
            }

            /*
             * =====================================
             * 3. MOBILE VALIDATION
             * =====================================
             */

            boolean validMobile = false;

            if (mobile.isEmpty()) {

                rowErrors.add(
                        "Mobile number is mandatory");

            } else if (!mobile.matches("\\d+")) {

                rowErrors.add(
                        "Mobile number must contain digits only");

            } else if (mobile.length() != 10) {

                rowErrors.add(
                        "Mobile number must contain exactly 10 digits");

            } else {

                validMobile = true;
            }

            /*
             * Check duplicate mobile
             */
            if (validMobile) {

                if (uploadedMobiles.contains(mobile)) {

                    rowErrors.add(
                            "Duplicate mobile number in uploaded Excel file");

                } else if (studentRepository.existsByMobile(mobile)) {

                    rowErrors.add(
                            "Mobile number already exists in database");

                } else {

                    uploadedMobiles.add(mobile);
                }
            }

            /*
             * =====================================
             * 4. COURSE VALIDATION
             * =====================================
             */

            if (!(course.equals("Java")
                    || course.equals("Python")
                    || course.equals("Testing")
                    || course.equals("Data Analytics"))) {

                rowErrors.add(
                        "Course must be Java, Python, Testing, or Data Analytics");
            }

            /*
             * =====================================
             * 5. CITY VALIDATION
             * =====================================
             */

            if (city.isEmpty()) {

                rowErrors.add("City is mandatory");
            }

            /*
             * =====================================
             * 6. FEES VALIDATION
             * =====================================
             */

            BigDecimal feeValue = null;

            if (fees.isEmpty()) {

                rowErrors.add("Fees is mandatory");

            } else {

                try {

                    feeValue = new BigDecimal(fees);

                    if (feeValue.compareTo(BigDecimal.ZERO) <= 0) {

                        rowErrors.add(
                                "Fees must be greater than 0");
                    }

                } catch (NumberFormatException e) {

                    rowErrors.add(
                            "Fees must be numeric");
                }
            }

            /*
             * =====================================
             * INSERT VALID ROW
             * =====================================
             */

            if (rowErrors.isEmpty()) {

                try {

                    Student student = new Student();

                    student.setStudentName(studentName);
                    student.setEmail(email);
                    student.setMobile(mobile);
                    student.setCourse(course);
                    student.setCity(city);
                    student.setFees(feeValue);
                    student.setCreatedAt(LocalDateTime.now());

                    studentRepository.save(student);

                    insertedCount++;

                } catch (DataIntegrityViolationException e) {

                    /*
                     * Handles unexpected duplicate constraint
                     * situations without crashing the complete file.
                     */

                    rowErrors.add(
                            "Email or mobile already exists in database");

                    addError(
                            errors,
                            excelRowNumber,
                            email,
                            mobile,
                            rowErrors);
                }

            } else {

                /*
                 * Invalid row → DO NOT INSERT
                 */

                addError(
                        errors,
                        excelRowNumber,
                        email,
                        mobile,
                        rowErrors);
            }
        }

        workbook.close();

        /*
         * =====================================
         * FINAL RESPONSE
         * =====================================
         */

        Map<String, Object> response = new LinkedHashMap<>();

        response.put(
                "message",
                "Excel processing completed");

        response.put(
                "total_rows",
                totalRows);

        response.put(
                "inserted_count",
                insertedCount);

        response.put(
                "failed_count",
                errors.size());

        response.put(
                "errors",
                errors);

        return response;
    }

    /*
     * =========================================
     * GET CELL VALUE
     * =========================================
     */

    private String getCellValue(
            Row row,
            int cellIndex,
            DataFormatter formatter) {

        if (row == null) {
            return "";
        }

        if (row.getCell(cellIndex) == null) {
            return "";
        }

        return formatter
                .formatCellValue(row.getCell(cellIndex))
                .trim();
    }

    /*
     * =========================================
     * EMAIL VALIDATION
     * =========================================
     */

    private boolean isValidEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(emailRegex, email);
    }

    /*
     * =========================================
     * ADD ERROR
     * =========================================
     */

    private void addError(
            List<Map<String, Object>> errors,
            int rowNumber,
            String email,
            String mobile,
            List<String> rowErrors) {

        Map<String, Object> errorObject =
                new LinkedHashMap<>();

        errorObject.put(
                "row",
                rowNumber);

        if (!email.isEmpty()) {

            errorObject.put(
                    "email",
                    email);
        }

        if (!mobile.isEmpty()) {

            errorObject.put(
                    "mobile",
                    mobile);
        }

        errorObject.put(
                "errors",
                rowErrors);

        errors.add(errorObject);
    }
}