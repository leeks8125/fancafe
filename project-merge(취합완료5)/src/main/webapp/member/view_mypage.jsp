<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div class="divcon"> 
		<table border=1 class="table table-dark">
			<caption>내정보</caption>
				<tr>
					<td>ID</td>
					<td>${member.id }</td>
				</tr>
	
				<tr>
					<td>성명</td>
					<td>${member.name }</td>
				</tr>
				
				<tr>
					<td>Email</td>
					<td>${member.mailid }@${member.domain }</td>
				</tr>
					
				<tr>
					<td>우편번호</td>
					<td>${member.post }</td>
				</tr>
				
				<tr>
					<td>주소</td>
					<td>${member.address }</td>
				</tr>
				
				<tr>
					<td>생년월일</td>
					<td>${member.birth }</td>
				</tr>
				
				<tr>
					<td>연락처</td>
					<td>${member.phone1 }-${member.phone2 }-${member.phone3 }</td>
				</tr>
				
				<tr>
					<td>성별</td>
					<td>${member.sex }</td>
				</tr>
				
				<tr>
					<td>가입일</td>
					<td>${member.reg_date }</td>
				</tr>
	
				<tr>
					<td colspan=2 align=center>
					<input type="button" value="내정보 수정"
					onClick="location.href='<%=request.getContextPath()%>/UpdateMyinfo.yw' " class="btn btn-outline-info">
						
					<input type="button" value="비밀번호 수정"
					onClick="location.href='<%=request.getContextPath()%>/UpdateMypass.yw' " class="btn btn-outline-info">			
					
					<input type="button" value="회원 탈퇴"
					onClick="location.href='<%=request.getContextPath()%>/QuitMember.yw' " class="btn btn-outline-info">	
					<input type="button" value="돌아가기" onClick="location.href='<%=request.getContextPath() %>/Back.yw'" class="btn btn-outline-light">				
					</td>
				</tr>

		</table>
		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>