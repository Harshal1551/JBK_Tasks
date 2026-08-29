<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>View Voter</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="container">

        <h2 style="text-align: center; margin-top: 40px;">
            Search Voter
        </h2>


        <!-- Success Message -->

        <% if (request.getAttribute("message") != null) { %>

            <p class="success" style="margin-top: 20px;">
                <%= request.getAttribute("message") %>
            </p>

        <% } %>


        <!-- Error Message -->

        <% if (request.getAttribute("error") != null) { %>

            <p class="error" style="margin-top: 20px;">
                <%= request.getAttribute("error") %>
            </p>

        <% } %>


        <!-- Search Form -->

        <div class="card"
             style="margin: 30px auto;">

            <form action="${pageContext.request.contextPath}/search-voter"
                  method="post">

                <div class="form-group">

                    <label>Voter ID</label>

                    <input type="text"
                           name="voterId"
                           placeholder="Enter Voter ID"
                           required>

                </div>

                <button type="submit"
                        class="btn"
                        style="width: 100%;">
                    Search Voter
                </button>

            </form>

        </div>


        <!-- Voter Details -->

        <% if (request.getAttribute("voter") != null) {

            com.tka.entity.Voter voter =
                (com.tka.entity.Voter) request.getAttribute("voter");

        %>

        <div class="details">

            <h2 style="text-align: center; margin-bottom: 20px;">
                Voter Details
            </h2>


            <p>
                <span>Voter ID:</span>
                <%= voter.getVoterId() %>
            </p>

            <p>
                <span>Name:</span>
                <%= voter.getName() %>
            </p>

            <p>
                <span>Age:</span>
                <%= voter.getAge() %>
            </p>

            <p>
                <span>Gender:</span>
                <%= voter.getGender() %>
            </p>

            <p>
                <span>Email:</span>
                <%= voter.getEmail() %>
            </p>

            <p>
                <span>Mobile:</span>
                <%= voter.getMobile() %>
            </p>

            <p>
                <span>Address:</span>
                <%= voter.getAddress() %>
            </p>

            <p>
                <span>Username:</span>
                <%= voter.getUsername() %>
            </p>


            <!-- Delete Form -->

            <form action="${pageContext.request.contextPath}/delete-voter"
                  method="post"
                  style="margin-top: 25px;">

                <input type="hidden"
                       name="voterId"
                       value="<%= voter.getVoterId() %>">

                <button type="submit"
                        class="btn btn-danger"
                        onclick="return confirm('Are you sure you want to delete this voter?');">
                    Delete Voter
                </button>

            </form>

        </div>

        <% } %>


        <!-- Back to Home -->

        <div style="text-align: center; margin-top: 30px;">

            <a href="${pageContext.request.contextPath}/home"
               class="btn">
                Back to Home
            </a>

        </div>

    </div>

</body>

</html>