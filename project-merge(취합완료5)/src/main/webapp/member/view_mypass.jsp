<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div class="divcon"> 
		<table border=1 class="table table-dark">
			<caption>내 비밀번호</caption>
				<tr>
					<td>비밀번호</td>
					<td>${member.pass }</td>
				</tr>
	
				<tr>
					<td colspan=2 align=center>
						<input type="button" value="로그인으로 이동" onClick="location.href='<%=request.getContextPath() %>/LoginForm.yw'" class="btn btn-outline-info">			
					</td>
				</tr>

		</table>
		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>