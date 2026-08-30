<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tka.entity.Staff"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Register Staff</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Register Staff</h2>


        <% if (request.getAttribute("message") != null) { %>

            <p class="success">
                <%= request.getAttribute("message") %>
            </p>

        <% } %>


        <%
            Staff staff = (Staff) request.getAttribute("staff");

            if (staff == null) {
                staff = new Staff();
            }
        %>


        <form action="${pageContext.request.contextPath}/register-staff"
              method="post">


            <!-- Staff ID -->

            <div class="form-group">

                <label>Staff ID</label>

                <input type="text"
                       name="staffid"
                       value="<%= staff.getStaffid() == null ? "" : staff.getStaffid() %>"
                       placeholder="Enter Staff ID"
                       required>

            </div>


            <!-- Name -->

            <div class="form-group">

                <label>Name</label>

                <input type="text"
                       name="name"
                       value="<%= staff.getName() == null ? "" : staff.getName() %>"
                       placeholder="Enter Name"
                       required>

            </div>


            <!-- Age -->

            <div class="form-group">

                <label>Age</label>

                <input type="number"
                       name="age"
                       value="<%= staff.getAge() == 0 ? "" : staff.getAge() %>"
                       placeholder="Enter Age"
                       required>

            </div>


            <!-- Email -->

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       value="<%= staff.getEmail() == null ? "" : staff.getEmail() %>"
                       placeholder="Enter Email"
                       required>

            </div>


            <!-- Department -->

            <div class="form-group">

                <label>Department</label>

                <input type="text"
                       name="department"
                       value="<%= staff.getDepartment() == null ? "" : staff.getDepartment() %>"
                       placeholder="Enter Department"
                       required>

            </div>


            <!-- Salary -->

            <div class="form-group">

                <label>Salary</label>

                <input type="number"
                       name="salary"
                       value="<%= staff.getSalary() == 0 ? "" : staff.getSalary() %>"
                       placeholder="Enter Salary"
                       required>

            </div>


            <!-- Mobile -->

            <div class="form-group">

                <label>Mobile</label>

                <input type="text"
                       name="mobile"
                       value="<%= staff.getMobile() == null ? "" : staff.getMobile() %>"
                       placeholder="Enter Mobile"
                       required>

            </div>


            <!-- Username -->

            <div class="form-group">

                <label>Username</label>

                <input type="text"
                       name="username"
                       value="<%= staff.getUsername() == null ? "" : staff.getUsername() %>"
                       placeholder="Enter Username"
                       required>

            </div>


            <!-- Password -->

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       placeholder="Enter Password"
                       required>

            </div>


            <button type="submit"
                    class="btn btn-success"
                    style="width: 100%;">
                Register Staff
            </button>

        </form>


        <div style="text-align: center; margin-top: 20px;">

            <a href="${pageContext.request.contextPath}/home"
               class="btn">
                Back to Home
            </a>

        </div>

    </div>

</body>

</html>