<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>

<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<form action="<%=request.getContextPath() %>/GalleryModify.dk" method="post">
				<input type="hidden" name="no" value="${gallery.no }"> 
				<input type="hidden" name="page" value="${page }"> 
				
				<table class="table table-bordered">
					<tr align="center" valign="middle">
						<td colspan="5">갤러리 수정</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12" height="16">
							<div align="center">글쓴이</div>
						</td>
						<td>
							<input name="author" id="author" type="text" size="10" maxlength="10" 
								value="${gallery.author }"/>
						</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12" height="16">
							<div align="center">제 목</div>
						</td>
						<td>
							<input name="title" id="title" type="text" size="50" maxlength="100"
							       value="${gallery.title }"/>
						</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12">
							<div align="center">내 용</div>
						</td>
						<td>
							<textarea class="form-control" name="contents" id="contentsc" cols="67" rows="15">${gallery.contents }</textarea>
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
		</article>
	</div>
</section>
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>