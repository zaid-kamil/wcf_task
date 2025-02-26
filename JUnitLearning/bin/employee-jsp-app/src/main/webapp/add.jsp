<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
:root {
	color-scheme: light dark;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	outline: none;
}

body {
	display: grid;
	align-content: center;
	height: 700px;
}

form {
	outline: solid #999 1px;
	padding: 1rem;
	box-shadow: #555 1px 1px 1px;
	margin-inline: auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border-radius: 10px;
	background-color: #fff;
	align-items: center;
	margin-top: 1rem;
}

form>* {
	margin-bottom: 1rem;
}

input {
	display: block;
	padding: .6rem 1rem;
	border: none;
	outline: none;
	border-radius: 15px;
	cursor:pointer;
}

button {
	display: block;
	padding: .5rem 1rem;
	width: 100%;
	border-radius: 15px;
	outline: none;
	border: none;
	background-color: #333;
	color: #eee;
}
</style>
</head>
<body>
	<h3 align="center">Add Employee</h3>
	<form method="post" action="process">
		<p>
			<input type="text" name="name" placeholder="Employee Name">
		</p>
		<p>
			<input type="email" name="email" placeholder="Employee Email">
		</p>
		<p>
			<input type="text" name="dept" placeholder="Department">
		</p>
		<button>Add Employee</button>
	</form>
</body>
</html>