<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">공지사항 작성</h3>
				</div>
				<div>
					<form action="<%=request.getContextPath() %>/NoticeAddAction.sh" method="post">
						<input type="hidden" name="id" value="${sessionScope.id }">
						<table class="table table-bordered border-dark">
							<tr>
								<th class="text-center">제목</th>
								<td>
									<input type="text" name="subject" id="subject" maxlength="100" class="w-100">
								</td>
							</tr>
							<tr>
								<th class="text-center">내용</th>
								<td>
									<textarea class="form-control" name="content" id="content" cols="67" rows="15"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
								
									<input type="submit" class="btn btn-secondary btn-sm" value="등록">
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