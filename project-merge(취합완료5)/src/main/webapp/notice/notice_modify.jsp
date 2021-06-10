<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<h3>글 수정</h3>
				<div>
					<form action="<%=request.getContextPath() %>/NoticeModify.sh" method="post">
						<input type="hidden" name="id" value="${notice.id }">
						<input type="hidden" name="grade" value="${sessionScope.grade}">
						<input type="hidden" name="num" value="${notice.num}">
						<input type="hidden" name="page" value="${page}">
						<table class="table table-bordered border-dark">
							<tr>
								<th class="text-center">제목</th>
								<td>
									<input type="text" name="subject" id="subject" maxlength="100" value="${notice.subject }" class="w-100">
								</td>
							</tr>
							<tr>
								<th class="text-center">내용</th>
								<td>
									<textarea class="form-control" name="content" id="content" cols="67" rows="15">${notice.content}</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
									<input type="submit" class="btn btn-secondary btn-sm" value="수정">
									<input type="reset" class="btn btn-secondary btn-sm" onClick="history.go(-1)" value="취소">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</article>
		</div>
	</section>
	
<!-- js 불러오기 -->
<script src="<%=request.getContextPath() %>/js/notice.js"></script>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>