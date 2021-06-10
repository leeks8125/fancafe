<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<h3>글 작성</h3>
				<form action="<%=request.getContextPath() %>/GalleryAddAction.dk" method="post" enctype="multipart/form-data">
					<input type="hidden" name="author" value="${sessionScope.id }">
					<table class="table table-bordered">
						<tr>
							<th>제목</th>
							<td>
								<input type="text" name="title" id="title" maxlength="100">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<textarea class="form-control" name="contents" id="contentsc" cols="67" rows="15"></textarea>
							</td>
						</tr>
						<tr>
							<td style="font-family:돋음; font-size:12">
								<div align="center">파일 첨부</div>
							</td>
							<td>
								<input name="fname" type="file"/>
							</td>
						</tr>
						<tr bgcolor="cccccc">
							<td colspan="2" style="height:1px;">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="등록">
								<input type="reset" value="취소">
							</td>
						</tr>
					</table>
				</form>
			</article>
		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>