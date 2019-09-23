<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${signInId eq userId }">
<form action="/update/${userId }" method="post">
<label>아이디</label>
<input type="text" name="userId" value="${userId }" />

<label>코멘트</label>
<input type="text" name="commnet" value="${comment}"/>

<button type="submit">수정</button>
<button><a href="/delete/${userId }">삭제</a></bttton>
</c:if>

<c:if test="${signInId != userId }">

<label>아이디</label>
<input type="text" name="userId" value="${userId }" readonly="readonly"/>

<label>코멘트</label>
<input type="text" name="commnet" value="${comment}" readonly="readonly"/>



</c:if>

</form>
</body>
</html>