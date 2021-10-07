<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보수정 폼</title>
	<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
	<link rel="stylesheet" href="<c:url value="css/user.css"/>"/>
</head>
<body>
	<div id="container">
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>회원 정보 수정</h1>
				<form id="update-form" name="userUpdateForm"
					action="<c:url value="/users/update/"/>" method="POST">
					<input type="hidden" name="no" value="${authUser.getNo() }">
					<label for="name">이름</label>
					<input name="name" type="text" 
						placeholder="이름을 입력하세요" value="${authUser.getName() }" /><br />
					<label for="password">비밀번호</label>
					<input name="password" type="password" 
						placeholder="비밀번호를 입력하세요"><br />
					<label for="email">이메일</label>
					<input type="text" name="email" 
						placeholder="이메일을 입력하세요." value="${authUser.getEmail() }">
					<input type="button" value="id 중복 체크"
						onclick="checkEmail(this, '<c:url value="/api/users/emailcheck" />')" /><br />
					<label for="gender">성별</label>
					<input type="radio" name="gender" value="M" 
						checked='${authUser.getGender() == "M"  }' />남성
					<input type="radio" name="gender" value="F" 
						checked='${authUser.getGender() == "F"  }' />여성<br />
					<input type="submit" value="전송" />
				</form>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>