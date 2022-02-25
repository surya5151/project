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
<header style="background-color:silver; font-style: italic; ">
<a href="signUpPage.vaccine" style=" margin-left:10% ">signUP</a> 
<a href="loginPage.vaccine" style="margin-left:70%">logIN</a>
 </header>
<body>
	<div align="left">
		<form action="createAccount.vaccine">
			<h1 style="color:blue; text-align: center;">Welcome to SignUP page and Create Your Account</h1>
			<label>User Name: </label><input placeholder="Enter your Name" type="text" name="userName">
			<p style="color: red;">${UserNameNotValid}</p>
		
				<label>Phone No: </label><input placeholder="Enter your Contact No" type="tel"
				name="phoneNo">
			<p style="color: red;">${NumberNotValid}</p>
				
				<label>Gender: </label> 
				<input type="radio" name="gender" value="Male"><label>Male</label> 
				<input type="radio" name="gender" value="Female"><label>Female</label>
			    <input type="radio" name="gender" value="other"><label>Others</label>
			<p style="color: red;">${GenderNotValid}</p>
				
			<label>Enter DOB: </label><input type="date" name="dob">
			<p style="color: red;">${DOBNotValid}</p>
		 
			<label>Password: </label><input type="password"
				name="password" placeholder="Enter Your Password">
			<p style="color: red;">${PasswordNotValid}</p>
				
			
			<label>Confirm-Password: </label><input type="password"
				name="confirmPassword" placeholder="Re-Enter Your Password">
			<p style="color: red;">${ConfirmPasswordNotValid}</p>
				<p style="color: red;">${PasswordNotMatched}</p>
				
				
				 <input	type="Submit" value="Create Your Account">

		<h1>${Signup_Message_sucess}</h1>
		<h1>${Signup_Message_error}</h1>
		

		</form>
	</div>

</body>

<footer
	style="color: white; margin-top: 5%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>