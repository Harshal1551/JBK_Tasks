<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Staff Management System</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="container">

        <div class="card">

            <h1>Staff Management System</h1>

            <p style="text-align: center;">
                Welcome to Staff Management System
            </p>


            <div class="menu">

                <!-- Register Staff -->

                <a href="${pageContext.request.contextPath}/register"
                   class="btn">
                    Register Staff
                </a>


                <!-- View Staff -->

                <a href="${pageContext.request.contextPath}/view-staff"
                   class="btn">
                    View Staff
                </a>


                <!-- View All Staff -->

                <a href="${pageContext.request.contextPath}/view-all-staff"
                   class="btn">
                    View All Staff
                </a>


                <!-- Logout -->

                <a href="${pageContext.request.contextPath}/"
                   class="btn btn-danger">
                    Logout
                </a>

            </div>

        </div>

    </div>

</body>

</html>