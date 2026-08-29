<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tka.entity.Voter"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Update Voter</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="card">

        <h2>Update Voter</h2>

        <%
            Voter voter =
                (Voter) request.getAttribute("voter");
        %>


        <!-- Error Message -->

        <% if (request.getAttribute("error") != null) { %>

            <p class="error">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <% if (voter != null) { %>

        <form action="${pageContext.request.contextPath}/update-voter"
              method="post">


            <!-- Voter ID -->

            <div class="form-group">

                <label>Voter ID</label>

                <input type="text"
                       name="voterId"
                       value="<%= voter.getVoterId() %>"
                       readonly>

            </div>


            <!-- Name -->

            <div class="form-group">

                <label>Name</label>

                <input type="text"
                       name="name"
                       value="<%= voter.getName() %>"
                       required>

            </div>


            <!-- Age -->

            <div class="form-group">

                <label>Age</label>

                <input type="number"
                       name="age"
                       value="<%= voter.getAge() %>"
                       required>

            </div>


            <!-- Gender -->

            <div class="form-group">

                <label>Gender</label>

                <select name="gender" required>

                    <option value="Male"
                        <%= "Male".equals(voter.getGender()) ? "selected" : "" %>>
                        Male
                    </option>

                    <option value="Female"
                        <%= "Female".equals(voter.getGender()) ? "selected" : "" %>>
                        Female
                    </option>

                    <option value="Other"
                        <%= "Other".equals(voter.getGender()) ? "selected" : "" %>>
                        Other
                    </option>

                </select>

            </div>


            <!-- Email -->

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       value="<%= voter.getEmail() %>"
                       required>

            </div>


            <!-- Mobile -->

            <div class="form-group">

                <label>Mobile</label>

                <input type="text"
                       name="mobile"
                       value="<%= voter.getMobile() %>"
                       required>

            </div>


            <!-- Address -->

            <div class="form-group">

                <label>Address</label>

                <textarea name="address"
                          required><%= voter.getAddress() %></textarea>

            </div>


            <!-- Username -->

            <div class="form-group">

                <label>Username</label>

                <input type="text"
                       name="username"
                       value="<%= voter.getUsername() %>"
                       required>

            </div>


            <!-- Password -->

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       value="<%= voter.getPassword() %>"
                       required>

            </div>


            <button type="submit"
                    class="btn btn-success"
                    style="width: 100%;">
                Update Voter
            </button>

        </form>


        <% } else { %>

            <p class="error">
                Voter not found.
            </p>

        <% } %>


        <div style="text-align: center; margin-top: 20px;">

            <a href="${pageContext.request.contextPath}/view-all-voters"
               class="btn">
                Back to All Voters
            </a>

        </div>

    </div>

</body>

</html>