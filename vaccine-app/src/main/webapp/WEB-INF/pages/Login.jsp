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

	<h1 style="text-align: center; color: lime;">Welcome to login pages</h1>
<body>


	<div align="center">
	
		<form action="login.vaccine">
			<h3 style="text-align: center; color: red;">${AttemptExceeded}</h3>
			
			<h3 style="text-align: center; color: red;">${No_of_AttemptExceeded}</h3>

			<h5 style="text-align: left; color: green;">${Reset_link }</h5>

			<h2 style="text-align: center; color: orange;">${Login_verify}</h2>

			<label>Enter UserName : </label> <input type="text" name="userName"><br><br> 
			<label>Enter Password:</label> <input type="text" name="password"><br> <br> 
				
				<input style="color: green; background-color: yellow;" type="submit" value="Sign in">

			<a href="resetPasswordpage.vaccine"  style="color: red;">Reset password</a>
			
	         <h3 style="text-align: center; color: red;">${passwordUpdate}</h3>
		</form>

	</div>



</body>


<footer
	style="color: white; margin-top: 20%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>