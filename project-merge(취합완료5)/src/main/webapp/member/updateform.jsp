<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
//				document.getElementById('join_zip1').value = data.postcode1;
//				document.getElementById('join_zip2').value = data.postcode2;
				document.getElementById('post').value = data.zonecode;
				document.getElementById('address').value = data.address;
				
			}
		}).open();
	}
</script>

<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/a_updatemember.js"></script>

 
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>

    <section>
		<div class="divcon">  

<form method="post" action="<%=request.getContextPath() %>/UpdateInsert.yw"> 
<input type="hidden" name="id" value="${member.id}">
<table border=1 class="table table-dark">
	<caption>내정보 수정</caption>
	<tr>
		<td>ID</td>
		<td>${member.id }</td>
	</tr>
	
	<tr>
		<td>성명</td>
		<td><input type=text id="name" name="name" value="${member.name }"></td>
	</tr>

	<tr>
		<td>E-Mail</td>
		<td><input type=text size=10 id="mailid" name="mailid" value="${member.mailid }">@
		    <input type=text size=10 id="domain" name="domain" value="${member.domain }">
		    <select id="email">
		    	<option value="">직접입력</option>
		    	<option value="naver.com">네이버</option>
		    	<option value="daum.net">다음</option>
		    	<option value="nate.com">네이트</option>
		    	<option value="gmail.com">gmail</option>
		    </select>		    
		 </td>
	</tr>
	
	<tr>
		<td>우편번호</td>
		<td><input type=text size=5 id="post" name="post" value="${member.post }">
			<input type=button value="우편번호검색" 
			       onClick="openDaumPostcode()" class="btn btn-outline-warning"/>
		</td>
	</tr>
	
	<tr>
		<td>주소</td>
		<td><input type=text size=45 id="address" name="address" value="${member.address }"></td>
	</tr>
	
	<tr>
		<td>생년월일</td>
		<td><input type=text size=6 id="birth" name="birth" value="${member.birth }"></td>
	</tr>
	
	<tr>
		<td>핸드폰</td>
		<td><select id="phone1" name="phone1">
				<option value="">번호선택</option>
				<option value="010" <c:if test="${member.phone1=='010' }">${'selected' }</c:if> >010</option>
				<option value="011" <c:if test="${member.phone1=='011' }">${'selected' }</c:if> >011</option>
				<option value="016" <c:if test="${member.phone1=='016' }">${'selected' }</c:if> >016</option>
				<option value="018" <c:if test="${member.phone1=='018' }">${'selected' }</c:if> >018</option>
				<option value="019" <c:if test="${member.phone1=='019' }">${'selected' }</c:if> >019</option>
			</select>-
			<input type=text size=4 id="phone2" name="phone2" maxlength=4 value="${member.phone2 }">-
			<input type=text size=4 id="phone3" name="phone3" maxlength=4 value="${member.phone3 }">
		</td>
	</tr>
	
	<tr>
		<td>성별</td>
		<td>
			<c:if test="${member.sex == '남자' }">
				<input type=radio id="male" name="sex" value="남자" checked="checked">남자
				<input type=radio id="female" name="sex" value="여자">여자
			</c:if>
			<c:if test="${member.sex == '여자' }">
				<input type=radio id="male" name="sex" value="남자">남자
				<input type=radio id="female" name="sex" value="여자" checked="checked">여자
			</c:if>
		</td>
	</tr>


	<tr>
		<td colspan=2 align=center>
			<input type=submit value="회원수정" class="btn btn-outline-success">
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
