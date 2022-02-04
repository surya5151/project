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

			<h1 style="color: lime; text-align: center;">Welcome to OTP Verification page</h1>

<h3>An OTP send to your email....</h3>
<body>
	<div align="center">
	
		<form action="verifyOTP.vaccine">
		
			
			<h4 style="color: red; text-align: center;">${OTP_Verified}</h4>
			<h4 style="color: yellow; text-align: center;">${Wrong_OTP_Entered}</h4>
			<h4 style="color: red; text-align: center;">${Invalid_OTP_Entered}</h4>
			
			<h4 style="color: red; text-align: center;">${OTP_Resend}</h4>
			<h4 style="color: red; text-align: center;">${OTP_ReSendAndUpdate}</h4>

			<label>Enter OTP</label> <input type="Number" name="otp" ><br> <br>
			<input type="submit" value="Verify & process" ><br><br>
			
			<a href="resendOTP.vaccine">Resend OTP</a><br><br>
			
			<a href="resendOTPAndUpdate.vaccine">Resend And Update OTP</a>

		</form>
	</div>

</body>

<footer
	style="color: white; margin-top: 20%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>