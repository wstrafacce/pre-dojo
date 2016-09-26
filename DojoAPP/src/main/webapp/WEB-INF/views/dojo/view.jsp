<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Uploading Form</title>
<style>
input {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 20%;
}
</style>
</head>
<body>
	<form method="POST" action="processessLog"
		enctype="multipart/form-data">
		<h3>
			<b>Input log file:</b>
		</h3>
		<input type="file" name="file"> 
		<br />
		<br />
		<input type="submit"
			value="Processes Ranking"> <br /> <br />
		<c:out value="${errorMessage}" />
	</form>
</body>
</html>