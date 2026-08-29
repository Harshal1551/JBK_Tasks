<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tka.entity.Voter"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>All Voters</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

    <div class="container">

        <h2 style="text-align: center; margin-top: 40px;">
            All Voters
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


        <%
            List<Voter> voters =
                (List<Voter>) request.getAttribute("voters");
        %>


        <% if (voters != null && !voters.isEmpty()) { %>


        <table>

            <thead>

                <tr>

                    <th>Voter ID</th>

                    <th>Name</th>

                    <th>Age</th>

                    <th>Gender</th>

                    <th>Email</th>

                    <th>Mobile</th>

                    <th>Address</th>

                    <th>Username</th>

                    <th>Actions</th>

                </tr>

            </thead>


            <tbody>

            <%
                for (Voter voter : voters) {
            %>

                <tr>

                    <td>
                        <%= voter.getVoterId() %>
                    </td>

                    <td>
                        <%= voter.getName() %>
                    </td>

                    <td>
                        <%= voter.getAge() %>
                    </td>

                    <td>
                        <%= voter.getGender() %>
                    </td>

                    <td>
                        <%= voter.getEmail() %>
                    </td>

                    <td>
                        <%= voter.getMobile() %>
                    </td>

                    <td>
                        <%= voter.getAddress() %>
                    </td>

                    <td>
                        <%= voter.getUsername() %>
                    </td>

                    <td>

                        <!-- Update -->

                        <a href="${pageContext.request.contextPath}/update-voter/<%= voter.getVoterId() %>"
                           class="btn">
                            Update
                        </a>


                        <!-- Delete -->

                        <form action="${pageContext.request.contextPath}/delete-voter"
                              method="post"
                              style="display: inline;">

                            <input type="hidden"
                                   name="voterId"
                                   value="<%= voter.getVoterId() %>">

                            <button type="submit"
                                    class="btn btn-danger"
                                    onclick="return confirm('Are you sure you want to delete this voter?');">
                                Delete
                            </button>

                        </form>

                    </td>

                </tr>

            <%
                }
            %>

            </tbody>

        </table>


        <% } else { %>


            <div class="details"
                 style="text-align: center; margin-top: 30px;">

                <h3>No voters found</h3>

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