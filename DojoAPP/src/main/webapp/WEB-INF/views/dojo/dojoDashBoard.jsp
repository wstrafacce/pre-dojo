<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dojo Results</title>
</head>
<body>

	<div align="center">
		<c:forEach var="ranking" items="${lRankings}">
			<c:out value="${ranking.matchId}" />
			<br />
			<c:out value="${ranking.startedDate}" />
			<br />
			<c:out value="${ranking.endedDate}" />
			<br /> 
			<c:forEach var="rankingLines" items="${ranking.rankingLines}">
				<c:out value="${rankingLines.playerNickName}" />
				&nbsp;
				<c:out value="${rankingLines.playerMurders}" />
				&nbsp;
				<c:out value="${rankingLines.playerDeaths}" />
				&nbsp;
				<c:out value="${rankingLines.favoriteWeapon}" />
				<br />
			</c:forEach>
			<br />
		</c:forEach>
		
		<a href="return">Back</a>
	</div>
</body>
</html>