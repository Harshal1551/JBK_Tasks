<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Staff Management System - Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Staff Management System</h2>

        <h3>Login</h3>


        <% if (request.getAttribute("error") != null) { %>

            <p class="error">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <form action="${pageContext.request.contextPath}/login"
              method="post">


            <div class="form-group">

                <label>Username</label>

                <input type="text"
                       name="username"
                       placeholder="Enter username"
                       required>

            </div>


            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       placeholder="Enter password"
                       required>

            </div>


            <button type="submit"
                    class="btn"
                    style="width: 100%;">
                Login
            </button>

        </form>


        <p style="text-align: center; margin-top: 20px;">

            Don't have an account?

            <a href="${pageContext.request.contextPath}/register">
                Register Staff
            </a>

        </p>

    </div>

</body>

</html>