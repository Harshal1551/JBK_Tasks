<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Voter Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Voter Management System</h2>

        <h3 style="text-align: center; margin-bottom: 20px;">
            Login
        </h3>


        <!-- Error Message -->

        <% if (request.getAttribute("error") != null) { %>

            <p class="error">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <!-- Login Form -->

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

            New voter?

            <a href="${pageContext.request.contextPath}/register">
                Register Here
            </a>

        </p>

    </div>

</body>

</html>