<%@ page language="java" contentType="text/html; charset=utf-8"%>
<link rel="stylesheet" type="text/css" href="css/board.css">
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>

<section>
<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				
				<div>
<html>
<head>
	<title>댓글 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
</head>
<body>

<form action="<%=request.getContextPath() %>/Boardreply.ks" method="post">
<input type="hidden" name="board_num" value="${board.board_num }"> 
<input type="hidden" name="board_re_ref" value="${board.board_re_ref }"> 
<input type="hidden" name="board_re_lev" value="${board.board_re_lev }"> 
<input type="hidden" name="board_re_seq" value="${board.board_re_seq }"> 
<input type="hidden" name="page" value="${page }"> 

<table class="board_table" cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">댓글 게시판</td>
	</tr>
	<tr>
		<td class="td" style="font-family:돋음; font-size:12" height="16">
			<div align="center">아이디</div>
		</td>
		<td class="td">
			<input name="id" id="id" type="text" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>

	<tr>
		<td class="td" style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td class="td">
			<textarea name="content" id="content" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="댓글">
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