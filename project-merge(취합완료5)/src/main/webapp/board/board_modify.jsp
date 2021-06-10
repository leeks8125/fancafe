<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <link rel="stylesheet" type="text/css" href="css/board.css">
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
<section>
<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				
				<div>
<html>
<head>
	<title>게시판 수정</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
</head>
<body>

<form action="<%=request.getContextPath() %>/Boardmodify.ks" method="post">
<input type="hidden" name="num" value="${mboard.num }"> 
<input type="hidden" name="page" value="${page }"> 

<table class="table table-hover table-striped text-center" cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">게시판 수정</td>
	</tr>
	<tr>
		<td class="td" style="font-family:돋음; font-size:12" height="16">
			<div align="center">아이디</div>
		</td>
		<td class="td" align=left>
			<input name="id" id="id" type="text" size="10" maxlength="10" 
				value="${mboard.id }"  readonly/>
		</td>
	</tr>
	<tr>
		<td class="td" style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td class="td" align=left>
			<input name="subject" id="subject" type="text" size="50" maxlength="100"
			       value="${mboard.subject }"/>
		</td>
	</tr>
	<tr>
		<td class="td" style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td class="td" align=left>
			<textarea name="content" id="content" cols="67" rows="15">${mboard.content }</textarea>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="수정">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>
</div>
			</article>
		</div>
</section>
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>