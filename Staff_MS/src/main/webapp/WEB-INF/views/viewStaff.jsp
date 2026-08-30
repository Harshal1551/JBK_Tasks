<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tka.entity.Staff"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>View Staff</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>View Staff Details</h2>


        <!-- Search Form -->

        <form action="${pageContext.request.contextPath}/search-staff"
              method="post">

            <div class="form-group">

                <label>Staff ID</label>

                <input type="text"
                       name="staffid"
                       placeholder="Enter Staff ID"
                       required>

            </div>

            <button type="submit"
                    class="btn"
                    style="width: 100%;">
                Search Staff
            </button>

        </form>


        <!-- Error Message -->

        <% if (request.getAttribute("error") != null) { %>

            <p class="error">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <!-- Staff Details -->

        <%
            Staff staff =
                (Staff) request.getAttribute("staff");

            if (staff != null) {
        %>

            <hr>

            <h3>Staff Details</h3>

            <table>

                <tr>
                    <th>Staff ID</th>
                    <td><%= staff.getStaffid() %></td>
                </tr>

                <tr>
                    <th>Name</th>
                    <td><%= staff.getName() %></td>
                </tr>

                <tr>
                    <th>Age</th>
                    <td><%= staff.getAge() %></td>
                </tr>

                <tr>
                    <th>Email</th>
                    <td><%= staff.getEmail() %></td>
                </tr>

                <tr>
                    <th>Department</th>
                    <td><%= staff.getDepartment() %></td>
                </tr>

                <tr>
                    <th>Salary</th>
                    <td><%= staff.getSalary() %></td>
                </tr>

                <tr>
                    <th>Mobile</th>
                    <td><%= staff.getMobile() %></td>
                </tr>

                <tr>
                    <th>Username</th>
                    <td><%= staff.getUsername() %></td>
                </tr>

            </table>

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