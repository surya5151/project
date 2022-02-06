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
<a href="logoutPage.vaccine" style="margin-left:90%">logout</a>
 </header>
 			<h1 style="color:blue;text-align: center;">Home page</h1>
 			
 <body>
 <h2>${Entity_saved_sucess}</h2>
  <h2>${Entity_saved_failure}</h2> 
  <h2 style="color: red;">${Entity_validation_failure}</h2>
 
 
 <div >
 <form action="addMember.vaccine">
 
 <label>Enter Full Name: </label><input type="text" name="name">
 <p style="color: red">${validate_Name}</p>  
 
<label>Gender: </label>
<input type="radio" name="gender" value="Male"><label>Male</label>
<input type="radio" name="gender" value="Female"><label>Female</label>
<input type="radio" name="gender" value="Other"><label>Other</label>
<p style="color: red">${validate_Gender}</p>

<label>Year of Birth: </label><input type="number" name="yob">
 <p style="color: red">${validate_yob}</p>

<label>Photo ID Proof: </label>
<select name="photoId">
<option>Aadhar Card: </option>
<option>PAN Card</option>
<option>Voter ID</option>
<option>Driving License</option>
<option>Passport</option>
</select>
 <p style="color: red">${validate_PhotoID}</p>

<label>Photo ID Number: </label><input type="text" name="photoIdNumber">
 <p style="color: red">${validate_PhotoIdNu}</p>


<label>Vaccine Type:</label>
<select name="vaccineType">
<option>Covidshield</option>
<option>Covaxin</option>
<option>Sputnik</option>
</select>
 <p style="color: red">${validate_VaccineType}</p>

<label>Dose:</label>
<select name="NoOfDose">
<option>Dose-1</option>
<option>Dose-2</option>
</select>
 <p style="color: red">${validate_NoOfDose}</p>

<input type="submit" value="Add Member">
 
 </form>
 
 </div>

</body>

<footer
		style="color: white; margin-top: 60%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>
</html>