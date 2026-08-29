<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Register Voter</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Register Voter</h2>


        <!-- Success Message -->

        <% if (request.getAttribute("message") != null) { %>

            <p class="success">
                <%= request.getAttribute("message") %>
            </p>

        <% } %>


        <!-- Error Message -->

        <% if (request.getAttribute("error") != null) { %>

            <p class="error">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <form action="${pageContext.request.contextPath}/register-voter"
              method="post">


            <!-- Voter ID -->

            <div class="form-group">

                <label>Voter ID</label>

                <input type="text"
                       name="voterId"
                       placeholder="Enter Voter ID"
                       required>

            </div>


            <!-- Name -->

            <div class="form-group">

                <label>Name</label>

                <input type="text"
                       name="name"
                       placeholder="Enter Name"
                       required>

            </div>


            <!-- Age -->

            <div class="form-group">

                <label>Age</label>

                <input type="number"
                       name="age"
                       placeholder="Enter Age"
                       required>

            </div>


            <!-- Gender -->

            <div class="form-group">

                <label>Gender</label>

                <select name="gender" required>

                    <option value="">Select Gender</option>

                    <option value="Male">Male</option>

                    <option value="Female">Female</option>

                    <option value="Other">Other</option>

                </select>

            </div>


            <!-- Email -->

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       placeholder="Enter Email"
                       required>

            </div>


            <!-- Mobile -->

            <div class="form-group">

                <label>Mobile</label>

                <input type="text"
                       name="mobile"
                       placeholder="Enter Mobile Number"
                       required>

            </div>


            <!-- Address -->

            <div class="form-group">

                <label>Address</label>

                <textarea name="address"
                          placeholder="Enter Address"
                          required></textarea>

            </div>


            <!-- Username -->

            <div class="form-group">

                <label>Username</label>

                <input type="text"
                       name="username"
                       placeholder="Create Username"
                       required>

            </div>


            <!-- Password -->

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       placeholder="Create Password"
                       required>

            </div>


            <button type="submit"
                    class="btn btn-success"
                    style="width: 100%;">
                Register Voter
            </button>

        </form>


        <p style="text-align: center; margin-top: 20px;">

            Already registered?

            <a href="${pageContext.request.contextPath}/">
                Login Here
            </a>

        </p>

    </div>

</body>

</html>