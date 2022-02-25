<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div>
		<a style="margin-left: 60%;">${UserName}</a> <a href="logout.vaccine"
			style="color: white; background-color: gray;">logout</a>
	</div>

</header>

<h1 style="color: blue; text-align: center;">Home page</h1>
<h3 style="color: green;">${Entity_saved_sucess}</h3>
<h3 style="color: red;">${Entity_not_saved_}</h3>
<h3 style="color: red;">${NO_ADDMember_COUNT_EXCEDED}</h3>


<body>

	<div style="text-align: center;">
		<form action="addMemberPage.vaccine">
			<input type="submit" value="AddMember"><br> <br>
		</form>
	</div>

	<div style="text-align: center;">
		<a href="memberList.vaccine">AddMembersList</a> <br>
	</div>

	<div style="text-align:center;">
	
		<table>
			<tr>
				<th scope="row" style="padding: 10px;">ID</th>
				<th scope="row" style="padding: 10px;">NAME</th>
				<th scope="row" style="padding: 10px;">GENDER</th>
				<th scope="row" style="padding: 10px;">YOB</th>
				<th scope="row" style="padding: 10px;">PHOTO_ID</th>
				<th scope="row" style="padding: 10px;">PHOTO_ID_NUMBER</th>
				<th scope="row" style="padding: 10px;">VACCINE_TYPE</th>
				<th scope="row" style="padding: 10px;">NO_OF_DOSE</th>

			</tr>
		</table>


		<div style="text-align:left; align-items: flex-start; ">
		
			<table style="color: red;">
				<c:forEach items="${ALL_MEMBER_LIST}" var="listOfMember">
					<tr>
						<td scope="row" style="padding: 10px;">${listOfMember.id }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.name }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.gender }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.yob }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.photoId }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.photoIdNumber }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.vaccineType }</td>
						<td scope="row" style="padding: 10px;">${listOfMember.noOfDose}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>







</body>

<footer
	style="color: white; margin-top: 60%; text-align: center; font-style: oblique; border-style: groove; border-color: aqua; background-color: blue;">
	<h1>CopyRight @2022 COWIN. All Right Reserved</h1>
</footer>

</html>