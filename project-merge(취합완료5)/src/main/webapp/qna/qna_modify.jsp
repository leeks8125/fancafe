<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../common/header.jsp"%>
<section>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<form action="<%=request.getContextPath()%>/QnaModify.jy"
				method="post">
				<input type="hidden" name="num" value="${qna.num }"> 
				<input type="hidden" name="page" value="${page }">
				<input type="hidden" name="id" value="${sessionScope.id }">

			
					<h3>글 수정</h3>

					<table class="table table-bordered">
					<tr>
						<th>비밀번호</th>
						<td><input name="passwd" id="passwd" type="password"
							size="10" maxlength="10" value="" /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input name="subject" id="subject" type="text" size="50"
							maxlength="100" value="${qna.subject }" /></td>
					</tr>
					<tr>
						<th>글내용</th>
						
						<td><textarea name="content" id="content" cols="67" rows="15">${qna.content }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
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