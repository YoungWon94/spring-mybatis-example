<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="true"%> --%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Spring Mybatis Test</h1>
	
	<% System.out.println("세션 : "+session.getAttribute("signInId"));
	System.out.println(session.getId());
	%>
	
	<hr/>
	* create
	
	<form action="create" method="post">
		<input type="text" name="userid" placeholder="id"/>
		<input type="text" name="userpw" placeholder="pw"/>
		<button type="submit">추가</button>
	</form>
	
	
	
	<hr/>
	* listAll

		
	<table border=1>
		<th>아이디</th>
		<th>비번</th>
		<th>코멘트</th>
		<th>상세</th>
		<c:forEach var="it" items="${test}" varStatus="status">
		<tr>
			<td>${it.userid}</td>
			<td>${it.userpw}</td>
			<td>${it.comment}</td>
			<td><a href="read/${it.userid }">보기</a></td>
		</tr>
		</c:forEach>
	</table>		

	
	<hr/>
	* signIn, 세션<br>
		
	<form action="signIn" method="post">
		<input type="text" name="userid" placeholder="id"/>
		<input type="text" name="userpw" placeholder="pw"/>
		<button type="submit">로그인</button>
	</form>
	<p>${message } : ${signInId }
	<c:if test="${not empty signInId}">
		<a href="signOut">로그아웃</a>
	</c:if>
	</p>
	
	
</body>
</html>
