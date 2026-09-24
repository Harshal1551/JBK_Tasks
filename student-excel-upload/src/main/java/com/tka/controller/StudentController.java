package com.tka.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.tka.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload-excel")
    public ResponseEntity<?> uploadExcel(
            @RequestParam(value = "file", required = false)
            MultipartFile file) {

        /*
         * =====================================
         * FILE MISSING
         * =====================================
         */

        if (file == null) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("File is required");
        }

        /*
         * =====================================
         * FILE EMPTY
         * =====================================
         */

        if (file.isEmpty()) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("File is empty");
        }

        /*
         * =====================================
         * FILE TYPE VALIDATION
         * =====================================
         */

        String fileName =
                file.getOriginalFilename();

        if (fileName == null
                || !fileName.toLowerCase().endsWith(".xlsx")) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Only .xlsx files are allowed");
        }

        /*
         * =====================================
         * PROCESS EXCEL
         * =====================================
         */

        try {

            Map<String, Object> response =
                    studentService.processExcel(file);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        } catch (IllegalArgumentException e) {

            /*
             * Invalid/empty/unreadable Excel structure
             */

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        } catch (IOException e) {

            /*
             * Excel reading problem
             */

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to read Excel file");

        } catch (Exception e) {

            /*
             * Unexpected server/database error
             */

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error");
        }
    }
}