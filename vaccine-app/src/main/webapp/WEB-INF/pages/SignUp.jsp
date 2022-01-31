<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<header
	style="color: white; margin-top: 0%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>Well come to Ministry of Health and Family Welfare</h1>
</header>
<body>
	<div align="left">
		<form action="createAccount.vaccine">
			<h1 style="color: red; text-align: center;">Well come to SignUP
				Or Create Account</h1>
			<label>User Name: </label><input placeholder="Enter your Name"
				type="text" name="userName"><br> <br> <label>Phone
				No: </label><input placeholder="Enter your Contact No" type="tel"
				name="phoneNo"><br> <br> <label>Gender: </label> <input
				type="radio" name="gender"><label>Male</label> <input
				type="radio" name="gender"><label>Female</label> <input
				type="radio" name="gender"><label>Others</label><br> <br>
			<label>Enter DOB: </label><input type="date" name="dob"><br>
			<br> <label>Password: </label><input type="password"
				name="password" placeholder="Enter Your Password"><br>
			<br> <label>Confirm-Password: </label><input type="password"
				placeholder="Re-Enter Your Password"><br> <br> <input
				type="Submit" value="Create Your Account">

			<h1>${Message}</h1>

		</form>
	</div>

</body>

<footer
	style="color: white; margin-top: 10%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>