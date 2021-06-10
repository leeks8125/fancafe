<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/a_passupdate.js"></script>

 
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>

    <section>
		<div class="divcon">  

<form method="post" action="<%=request.getContextPath() %>/UpdateMypassInsert.yw"> 
<input type="hidden" name="id" value="${member.id}">
<table border=1 class="table table-dark">
	<caption>비밀번호 수정</caption>
	<tr>
		<td>ID</td>
		<td>${member.id }</td>
	</tr>
	
	<tr>
		<td>기존비밀번호</td>
		<td><input type=password id="pass" name="pass" value="${member.pass }" readonly="readonly"></td>
	</tr>

	<tr>
		<td>기존 비밀번호 확인</td>
		<td><input type=password id="passcopy" name="passcopy"></td>
	</tr>	

	<tr>
		<td rowspan="3">새 비밀번호</td>
		<td>
			<input type=password id="newpass" name="newpass">
			<input type=button value="비밀번호검사" id="newpasscheck" class="btn btn-outline-warning">
		</td>
	</tr>	
	
	<tr>
		<!-- <td></td> -->
		<td style="font-size: 5px">비밀번호는 6자이상 10자 이하, 특수문자 !,@,#,$,* 를 포함해야합니다</td>
	</tr>
	
	<tr>
		<!-- <td></td> -->
		<td ><p id="mynewpass" style="color: red"></p></td>
	</tr>	
	
	<tr>
		<td>새 비밀번호 확인</td>
		<td><input type=password id="newpasscopy" name="newpasscopy"></td>
	</tr>	
	
	<tr>
		<td colspan=2 align=center>
			<input type=submit value="비밀번호수정" class="btn btn-outline-success">
			<input type=reset value="취소" class="btn btn-outline-danger">
			<input type="button" value="돌아가기" onClick="location.href='<%=request.getContextPath() %>/Back.yw'" class="btn btn-outline-light">
		</td>
	</tr>		
</table>
</form>


		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>
