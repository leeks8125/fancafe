<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp"%>

<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<h3>회원 정보</h3>
			<div>
				<table class="table table-bordered">
					<tr>
						<th>아이디</th>
						<td>${member.id}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>${member.pass}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${member.name}</td>
					</tr>
					<tr>
						<th>이메일 주소</th>
						<td>${member.mailid}@${member.domain}</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>${member.post}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${member.address}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${member.birth}</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td>${member.phone1}-${member.phone2}-${member.phone3}</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${member.sex}</td>
					</tr>
					<tr>
						<th>가입 날짜</th>
						<td><fmt:formatDate value="${member.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th>등급</th>
						<td>${member.grade}</td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
							<c:choose>
								<c:when test="${member.state == '0'}">
									가입
								</c:when>
								<c:when test="${member.state == '1'}">
									탈퇴
								</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="목록" class="btn btn-secondary btn-sm"
								onClick="location.href='./AdminListAction.sw?page=${page}'">
							<c:choose>
								<c:when test="${member.state == '0'}">
									<input type="button" value="탈퇴" class="btn btn-secondary btn-sm"
										onClick="location.href='./AdminDeleteAction.sw?id=${member.id}&page=${page}'">
								</c:when>
								<c:when test="${member.state == '1'}">
									<input type="button" value="복구" class="btn btn-secondary btn-sm"
										onClick="location.href='./AdminRecoverAction.sw?id=${member.id}&page=${page}'">
								</c:when>
							</c:choose>
						</td>
					</tr>
				</table>
			</div>
		</article>
	</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp"%>