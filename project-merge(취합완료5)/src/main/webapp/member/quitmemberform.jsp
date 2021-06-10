<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/a_quitmember.js"></script>

	<!-- header 파일 불러오기 -->
	<%@ include file="/common/header.jsp"%>


</head>
<body>
	<section>
		<div class="divcon">  
		<form method="post" action="<%=request.getContextPath()%>/QuitMemberOperation.yw">
		<input type="hidden" name="id" value="${member.id}">
			<table border=1 class="table table-dark">
				<caption>회원탈퇴</caption>
				<tr>
					<td>ID</td>
					<td colspan=2>${member.id }</td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td colspan=2><input type="password" size=30 id="pass" name="pass"></td>
				</tr>
				
				<tr>
					<td colspan=2 align=center>
						<input type="submit" value="회원탈퇴" class="btn btn-outline-success">
						<input type="reset" value="취소" class="btn btn-outline-danger">
						<input type="button" value="돌아가기" onClick="location.href='<%=request.getContextPath() %>/Back.yw'" class="btn btn-outline-light">
					</td>
				</tr>

			</table>
		</form>
		</div>
	</section>

	<!-- footer 파일 불러오기 -->
	<%@ include file="/common/footer.jsp"%>
