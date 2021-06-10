<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">관리자 게시글 삭제</h3>
				</div>
				<div>
					<form action="<%=request.getContextPath() %>/AdminBoardDelete.sw" method="post">
						<input type="hidden" name="grade" value="${sessionScope.grade}">
						<input type="hidden" name="num" value="${param.num}"> 
						<input type="hidden" name="page" value="${param.page}">
						<input type="hidden" name="flag" value="${param.flag}"> 
						<input type="hidden" name="re_seq" value="${param.re_seq}"> 
						<table id="del_tab" class="table table-bordered border-dark w-50">
							<tr>
								<td colspan="2" class="text-center">
									삭제하시려면 '<span class="text-danger">지금삭제</span>' 를 입력하세요
								</td>
							</tr>
							<tr>
								<th class="text-center">입력창</th>
								<td>
									<input type="text" name="check" id="check" maxlength="4">
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
									<input type="submit" class="btn btn-secondary btn-sm" value="삭제">
									<input type="reset" class="btn btn-secondary btn-sm" onClick="history.go(-1)" value="취소">
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