<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css2?family=Mate+SC&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Hope's To Do List</title>
<link type="text/css" rel="stylesheet" href="styles.css">

</head>
<body>
	<h1>Hope's To Do List</h1>
	<div id="add">
		<form action="ToDoServlet" method="GET">
			<input type="text" name="task">
			<button type="submit" name="addTask" value="Add">
				<i class="fas fa-plus-square"></i>
			</button>

		</form>
	</div>
	<form class="form2" action="ToDoServlet" method="POST">
		<div class="show-refresh">
			<input type="submit" name="showAll" value="Show/Refresh">
		</div>

		<div class="delete">
			<button type="submit" id="deleteTask" name="deleteTask">
				<i class="fas fa-trash"></i>
			</button>
			<select name="id">
				<c:forEach items="${todos}" var="tsk">
					<option value="${tsk.id}">${tsk.id}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="to-do-tasks">
		<c:forEach var="tasks" items="${todos}">
			No. : ${tasks.id} <br>
			Task : ${tasks.task} 
			<br>------------------------------- <br>
		</c:forEach>
		</div>
	</form>
</body>
</html>