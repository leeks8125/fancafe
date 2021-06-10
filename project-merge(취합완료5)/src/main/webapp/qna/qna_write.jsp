

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/common/header.jsp"%>
<section>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>

	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<h3>Q&A 작성</h3>
			<form action="<%=request.getContextPath()%>/QnaAddAction.jy" method="post" >
			<input type="hidden" name="id" value="${sessionScope.id }">

				<table class="table table-bordered">
				<!--  
					<tr>
						<th>작성자</th>
						<td></td>
					</tr>
				-->	

					<tr>
						<th>비밀번호</th>
						<td><input name="passwd" id="passwd" type="password"
							size="10" maxlength="10" value="" /></td>
					</tr>
					
					<tr>
						<th>제 목</th>
						<td><input name="subject" id="subject" type="text" class="form-control"
							maxlength="100" value="" placeholder="글 제목"/></td>
					</tr>
					
					<tr>
						<th>작성 내용</th>
						<td><textarea name="content" id="content" cols="67" rows="15" placeholder="글 내용"></textarea>
						</td>
					</tr>
				
				
				</table>
				<td colspan="2">
					<input type=submit class="btn btn-primary pull-right" value="글쓰기"> 
					<input type=reset value="취소" onclick="history.go(-1)"></td>
			</form>
		</article>
	</div>
</section>


<%@ include file="/common/footer.jsp"%>

