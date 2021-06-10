<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/board.css">
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
	
<section>
<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				
				<div>
<form action="<%=request.getContextPath() %>/Boardreplydelete.ks" method="post">
<input type="hidden" name="num" value="${param.num }"> 
<input type="hidden" name="page" value="${param.page }"> 
<input type="hidden" name="re_seq" value="${param.re_seq }"> 
<table class="table table-hover table-striped text-center" cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">댓글 삭제</td>
		
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td align=left>
			<input name="pass" id="pass" type="password" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="삭제">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>
</div>
			</article>
		</div>
</section>
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>