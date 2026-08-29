<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Home - Voter Management System</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="container">

        <div class="home">

            <h1>Voter Management System</h1>

            <p style="margin-bottom: 30px;">
                Welcome to Voter Management System
            </p>


            <div class="menu">

                <!-- Register Voter -->

                <a href="${pageContext.request.contextPath}/register"
                   class="btn btn-success">
                    Register Voter
                </a>


                <!-- View Voter -->

                <a href="${pageContext.request.contextPath}/view-voter"
                   class="btn">
                    View Voter
                </a>


                <!-- View All Voters -->

                <a href="${pageContext.request.contextPath}/view-all-voters"
                   class="btn">
                    View All Voters
                </a>


                <!-- Update Voter -->

                <a href="${pageContext.request.contextPath}/update-voter"
                   class="btn">
                    Update Voter
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