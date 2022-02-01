<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<header
	style="color: white; margin-top: 0%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>Well come to Ministry of Health and Family Welfare</h1>
</header>

<body>

	<h1>Welcome to login pages</h1>
<body>

<h1>${Login_verify}</h1>

	<div align="center">
		<form action="login.vaccine">
			<label>Enter UserName : </label> <input type="text" name="userName"><br><br>
			<label>Enter Password:</label> <input type="text" name="password"><br><br>
			
			<input type="submit" value="Sign in">

		</form>

	</div>
	
	
</body>


<footer
		style="color: white; margin-top: 20%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>