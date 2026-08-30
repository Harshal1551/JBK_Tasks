<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tka.entity.Staff"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>View All Staff</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

	<div class="container">

		<div class="card" style="width: 100%;">

			<h2>All Staff Records</h2>


			<%
			List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
			%>


			<%
			if (staffList != null && !staffList.isEmpty()) {
			%>

			<table>

				<tr>

					<th>Staff ID</th>

					<th>Name</th>

					<th>Age</th>

					<th>Email</th>

					<th>Department</th>

					<th>Salary</th>

					<th>Mobile</th>

					<th>Username</th>
					<th>Action</th>

				</tr>


				<%
				for (Staff staff : staffList) {
				%>

				<tr>

					<td><%=staff.getStaffid()%></td>

					<td><%=staff.getName()%></td>

					<td><%=staff.getAge()%></td>

					<td><%=staff.getEmail()%></td>

					<td><%=staff.getDepartment()%></td>

					<td><%=staff.getSalary()%></td>

					<td><%=staff.getMobile()%></td>

					<td><%=staff.getUsername()%></td>

					<td><a
						href="${pageContext.request.contextPath}/update-staff/<%= staff.getStaffid() %>"
						class="btn"> Update </a>


						<form action="${pageContext.request.contextPath}/delete-staff"
							method="post" style="display: inline;">

							<input type="hidden" name="staffid"
								value="<%=staff.getStaffid()%>">

							<button type="submit" class="btn btn-danger"
								onclick="return confirm('Are you sure you want to delete this staff?');">
								Delete</button>

						</form>
					</td>

				</tr>

				<%
				}
				%>

			</table>


			<%
			} else {
			%>

			<p class="error">No staff records found.</p>

			<%
			}
			%>


			<br>


			<div style="text-align: center;">

				<a href="${pageContext.request.contextPath}/home" class="btn">
					Back to Home </a>

			</div>

		</div>

	</div>

</body>

</html>