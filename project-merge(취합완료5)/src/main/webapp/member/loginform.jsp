<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/a_login.js"></script>


	<!-- header 파일 불러오기 -->
	<%@ include file="/common/header.jsp"%>


</head>
<body>
	<section>
		<div class="divcon">  
		<form method="post" action="<%=request.getContextPath()%>/Login.yw">
			<table border=1 class="table table-dark">
				<caption>로그인</caption>
				<tr>
					<td>ID</td>
					<td colspan=2><input type=text size=30 id="id" name="id"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td colspan=2><input type="password" size=30 id="pass" name="pass">
								  <input type="submit" value="로그인" class="btn btn-outline-success">
				   </td> 
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" value="아이디찾기" onClick="location.href='<%=request.getContextPath()%>/SearchId.yw'" class="btn btn-outline-info">
						<input type="button" value="비밀번호찾기" onClick="location.href='<%=request.getContextPath()%>/SearchPass.yw'" class="btn btn-outline-info">
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
