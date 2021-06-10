<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/a_searchid.js"></script>

 
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>

    <section>
		<div class="divcon">    

<form method="post" action="<%=request.getContextPath() %>/SearchIdOperation.yw"> 
<table border=1 class="table table-dark">
	<caption>아이디 찾기</caption>
		
	<tr>
		<td>성명</td>
		<td><input type=text id="name" name="name"></td>
	</tr>

	<tr>
		<td>E-Mail</td>
		<td><input type=text size=10 id="mailid" name="mailid">@
		    <input type=text size=10 id="domain" name="domain">
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
		<td colspan=2 align=center>
			<input type=submit value="아이디 찾기" class="btn btn-outline-success">
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
