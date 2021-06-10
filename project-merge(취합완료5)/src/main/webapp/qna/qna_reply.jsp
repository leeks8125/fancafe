<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/common/header.jsp"%>

<html>
<section>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
		
			<form action="<%=request.getContextPath()%>/QnaReplyAction.jy" method="post">
				<input type="hidden" name="id" value="${sessionScope.id}">
				<input type="hidden" name="num" value="${qna.num}">
				<input type="hidden" name="passwd" value="${qna.passwd}">
				<input type="hidden" name="board_re_ref" value="${qna.board_re_ref}">
				<input type="hidden" name="board_re_lev" value="${qna.board_re_lev}">
				<input type="hidden" name="board_re_seq" value="${qna.board_re_seq}">
				<input type="hidden" name="page" value="${page}">
				<h3>Q&A 답글 작성</h3>
				<table class="table table-bordered">

				<tr>
						<th>제 목</th>
						<td><input name="subject" id="subject" type="text" size="50"
							maxlength="100" value= "" /></td>
					</tr>
					<tr>
						<th>작성 내용</th>
						<td><textarea name="content" id="content" cols="67" rows="15"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type=submit value="완료">
							<input type=reset value="취소" onclick="history.go(-1)">
						</td>
					</tr>
				</table>
			</form>
		</article>
	</div>
</section>

<%@ include file="/common/footer.jsp"%>
