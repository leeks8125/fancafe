<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">회원 복구</h3>
				</div>
				<div>
					<form action="<%=request.getContextPath() %>/AdminRecover.sw" method="post">
						<input type="hidden" name="grade" value="${sessionScope.grade}">
						<input type="hidden" name="id" value="${param.id }"> 
						<input type="hidden" name="page" value="${param.page }"> 
						<table id="del_tab" class="table table-bordered border-dark w-50">
							<tr>
								<td colspan="2" class="text-center">
									복구시키시려면 '<span class="text-danger">회원복구</span>' 를 입력하세요
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
									<input type="submit" class="btn btn-secondary btn-sm" value="복구">
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