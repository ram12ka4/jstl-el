<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<style type="text/css">
html, body {
	margin: 10px;
	pading: px;
}

.test {
border: 1px solid black;
background-color: black;
height: 5px;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="test"></div>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Role</th>
				</tr>
			</thead>
			<tfoot></tfoot>
			<tbody>
				<c:forEach items="${requestScope.empList}" var="emp">
					<tr>
						<td><c:out value="${emp.id}"></c:out></td>
						<td><c:out value="${emp.name}"></c:out></td>
						<td><c:out value="${emp.role}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br>

		<%
			List<List<String>> values = (ArrayList) request.getAttribute("myList");
		%>

		<table>
			<thead>

				<tr>
					<c:forEach items="${requestScope.myList[0]}" var="col">
						<th><c:out value="${col}"></c:out></th>
					</c:forEach>
				</tr>


			</thead>
			<tfoot></tfoot>
			<tbody>
				<c:forEach begin="0"
					end="${((requestScope.myList[1].size()) /   (requestScope.myList[0].size())) - 1}"
					varStatus="i">
					<c:set var="rowStart" value="${i.index * 4}"></c:set>
					<tr>
						<c:forEach begin="0" end="${requestScope.myList[0].size() -1}"
							varStatus="j">
							<c:set var="index" value="${j.index + rowStart}"></c:set>
							<td>${requestScope.myList[1][index]}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- <button type="button" class="btn btn-success openBtn" data-id='123'>Previous Notes</button> -->
	
		<button type="button" class="btn btn-primary btn-lg doctor-record" data-id="123">Previous Record</button>
	</div>


	<%@include file="data-modal.jsp"%>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
		
		<script type="text/javascript" src="js/app.js"></script>
</body>
</html>