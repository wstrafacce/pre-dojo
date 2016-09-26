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
<title>Dojo Results</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 80%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<div>

		<c:forEach var="ranking" items="${lRankings}">
			<table>
				<tr>
					<th>Match</th>
					<th><c:out value="${ranking.matchId}" /></th>
				</tr>
				<tr>
					<td>Started</td>
					<td><c:out value="${ranking.startedDate}" /></td>
				</tr>
				<tr>
					<td>Ended</td>
					<td><c:out value="${ranking.endedDate}" /></td>
				</tr>
			</table>
			<br />
			<table>
				<tr>
					<th>NickName</th>
					<th>Killers</th>
					<th>Deaths</th>
					<th>Fav. Weapon</th>
					<th>Streak</th>
					<th>Award</th>
				</tr>
				<c:forEach var="rankingLines" items="${ranking.rankingLines}">
					<tr>
						<td><c:out value="${rankingLines.playerNickName}" /></td>
						<td><c:out value="${rankingLines.playerKillers}" /></td>
						<td><c:out value="${rankingLines.playerDeaths}" /></td>
						<td><c:out value="${rankingLines.favoriteWeapon}" /></td>
						<td><c:out value="${rankingLines.streak}" /></td>
						<td><c:out value="${rankingLines.award}" /></td>
					</tr>

				</c:forEach>
			</table>
			<br />
		</c:forEach>

		<a href="return">Back</a>
	</div>
</body>
</html>