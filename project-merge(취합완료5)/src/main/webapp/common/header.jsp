<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="./gallery/jquery.masonry.min.js"></script>
    <script src="./gallery/jquery.imagesloaded.min.js"></script>
	<title>OOO팬 카페</title>
	<link rel="stylesheet" type="text/css" href="./css/default.css">
	<link rel="stylesheet" type="text/css" href="css/member.css">
	<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
	<!-- source start -->  
	<header>
		<h1><a href="./MainAction.do" class="text-white">OOO 팬 카페</a></h1>
		<div>
			<div id="login_menu" class="float-end">
				<!-- 세션이 없는 경우 -->
				<c:if test="${sessionScope.id == null  }">
					<input type="button" value="메인페이지" onClick="location.href='./MainAction.do'">
					<input type="button" value="로그인" onClick="location.href='<%=request.getContextPath() %>/LoginForm.yw'">
					<input type="button" value="회원가입" onClick="location.href='<%=request.getContextPath() %>/MemberForm.yw'">
				</c:if>
				<!-- 세션이 있는경우 -->	
				<c:if test="${sessionScope.id != null && sessionScope.grade eq '0'}">
					<input type="button" value="메인페이지" onClick="location.href='./MainAction.do'">
					<h4>${sessionScope.id}님 환영합니다</h4>
					<input type="button" value="마이페이지로" onClick="location.href='<%=request.getContextPath() %>/Mypage.yw'">
					<input type="button" value="로그아웃" onClick="location.href='<%=request.getContextPath() %>/Logout.yw'">
				</c:if>
					
				<!-- 관리자 세션이 있는경우 -->	
				<c:if test="${sessionScope.id != null && sessionScope.grade eq '1'}">
					<input type="button" value="메인페이지" onClick="location.href='./MainAction.do'">
					<h4>${sessionScope.id}님 환영합니다</h4>
					<input type="button" value="회원관리" onClick="location.href='./AdminListAction.sw'">
					<input type="button" value="로그아웃" onClick="location.href='<%=request.getContextPath() %>/Logout.yw'">
				</c:if>
			</div>	
		</div>
	</header>
	<div id="top_img" class="col" onClick="location.href='https://twitter.com/home'">
	</div>
	<nav>
		<ul class="row align-items-center">
			<li class="col-3"><a href="./NoticeListAction.sh" class="text-white">공지사항</a></li>
			<li class="col-3"><a href="Free.ks" class="text-white">자유게시판</a></li>
			<li class="col-3"><a href="./GalleryListAction.dk" class="text-white">사진게시판</a></li>
			<li class="col-3"><a href="./QnaListAction.jy" class="text-white">Q&A</a></li>
		</ul>
	
	</nav>