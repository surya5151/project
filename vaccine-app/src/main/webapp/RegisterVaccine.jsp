<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid vaccion form</title>
</head>
<header
	style="color: white; margin-top: 0%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
<h1>Well come to Ministry of Health and Family Welfare</h1>
</header>
<body
	style="background-image: url('C:/Users/Surya/Desktop/JAVA images/covid-vaccine-getty.jpg'); background-repeat: no-repeat; background-size: 100%;">

	<div align="center">
		<h1>Register for Covid Vaccinations</h1>
		<form action="getOTP.vaccine">
			<label>Email ID: </label> <input type="text"
				placeholder="Enter email id " name="emailID"><br> <br>
			<input type="submit" value="Get OTP">

		</form>
	
	</div>
	
		<h1>${message}</h1>
</body>

<footer
	style="color: white; margin-top:20%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>
</html>