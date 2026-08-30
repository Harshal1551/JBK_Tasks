<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tka.entity.Staff"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Update Staff</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Update Staff</h2>


        <% if (request.getAttribute("message") != null) { %>

            <p class="success">
                <%= request.getAttribute("message") %>
            </p>

        <% } %>


        <%
            Staff staff =
                (Staff) request.getAttribute("staff");
        %>


        <% if (staff != null) { %>

            <form action="${pageContext.request.contextPath}/update-staff"
                  method="post">


                <!-- Staff ID -->

                <div class="form-group">

                    <label>Staff ID</label>

                    <input type="text"
                           name="staffid"
                           value="<%= staff.getStaffid() %>"
                           readonly>

                </div>


                <!-- Name -->

                <div class="form-group">

                    <label>Name</label>

                    <input type="text"
                           name="name"
                           value="<%= staff.getName() %>"
                           required>

                </div>


                <!-- Age -->

                <div class="form-group">

                    <label>Age</label>

                    <input type="number"
                           name="age"
                           value="<%= staff.getAge() %>"
                           required>

                </div>


                <!-- Email -->

                <div class="form-group">

                    <label>Email</label>

                    <input type="email"
                           name="email"
                           value="<%= staff.getEmail() %>"
                           required>

                </div>


                <!-- Department -->

                <div class="form-group">

                    <label>Department</label>

                    <input type="text"
                           name="department"
                           value="<%= staff.getDepartment() %>"
                           required>

                </div>


                <!-- Salary -->

                <div class="form-group">

                    <label>Salary</label>

                    <input type="number"
                           name="salary"
                           value="<%= staff.getSalary() %>"
                           required>

                </div>


                <!-- Mobile -->

                <div class="form-group">

                    <label>Mobile</label>

                    <input type="text"
                           name="mobile"
                           value="<%= staff.getMobile() %>"
                           required>

                </div>


                <!-- Username -->

                <div class="form-group">

                    <label>Username</label>

                    <input type="text"
                           name="username"
                           value="<%= staff.getUsername() %>"
                           required>

                </div>


                <!-- Password -->

                <div class="form-group">

                    <label>Password</label>

                    <input type="password"
                           name="password"
                           value="<%= staff.getPassword() %>"
                           required>

                </div>


                <button type="submit"
                        class="btn btn-success"
                        style="width: 100%;">
                    Update Staff
                </button>

            </form>


        <% } else { %>

            <p class="error">
                Staff not found.
            </p>

        <% } %>


        <br>


        <div style="text-align: center;">

            <a href="${pageContext.request.contextPath}/home"
               class="btn">
                Back to Home
            </a>

        </div>

    </div>

</body>

</html>