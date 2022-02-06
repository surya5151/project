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


 

<h1 style="text-align: center; color:blue;">Reset password page</h1>
<body>

<div align="center">

<form action="resetPassword.vaccine">

<h3 style="color: green;">${Reset_password_sucess}</h3>

<h3 style="color: red;">${Reset_password_failure}</h3>

<h3 style=" color: orange;">${Reset_password_Not_matched}</h3>


<label>Enter Password: </label><input type="text" name="password"><br><br>

<label>Confirm Password: </label><input type="text" name="confirmPassword"><br><br>

<input type="submit" value="Reset"><br>



</form>


</div>

</body>

<footer
	style="color: white; margin-top: 20%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>
</html>