<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp"%>

<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-75">
			<h3>회원 목록</h3>
			<div>
				<p>총 회원수 : ${listcount - 2}</p>
				<table class="table table-info table-hover">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>가입일</th>
							<th class="text-center">상태</th>
							<th class="text-center">등급</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="num" value="${listcount - (page-1) *20 }" />
						<c:forEach var="m" items="${memberlist }">
							<tr onclick="location.href='./AdminDetailAction.sw?id=${m.id}&page=${page}'" style="cursor:hand">
								<td class="text-center">${num} <c:set var="num" value="${num-1 }" /></td>
								<td>${m.id}</td>
								<td>${m.name}</td>
								<td><fmt:formatDate value="${m.reg_date}" pattern="yyyy-MM-dd" /></td>
								<td class="text-center">
									<c:choose>
										<c:when test="${m.state == '0'}">
											가입
										</c:when>
										<c:when test="${m.state == '1'}">
											탈퇴
										</c:when>
									</c:choose>
								</td>
								<td class="text-center">${m.grade}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="position-relative">
				<!-- 페이징 영역 -->
				<div class="position-absolute bottom-50 start-50 translate-middle-x">
					<!-- bootstrap -->
					<c:if test="${listcount > 0 }">
						<div aria-label="...">
							<ul class="pagination">
								<!-- 1 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./AdminListAction.sw?page=1"> << </a>
								</li>
								
								<!-- 이전 블럭으로 이동 -->
								<c:if test="${startPage > 10 }">
									<li class="page-item">
										<a class="page-link" href="./AdminListAction.sw?page=${startPage-10}"> < </a>
									</li>
								</c:if>
								
								<!-- 각 블럭에 10개의 페이지 출력 -->
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:if test="${i == page }">
										<!-- 현재 페이지 -->
										<li class="page-item active">
											<a class="page-link">${i}</a>
										</li>
									</c:if>
									<c:if test="${i != page }">
										<!-- 현재 페이지가 아닌 경우 -->
										<li class="page-item">
											<a class="page-link" href="./AdminListAction.sw?page=${i}">${i}</a>
										</li>
									</c:if>
								</c:forEach>
								
								<!-- 다음 블럭으로 이동 -->
								<c:if test="${endPage < pageCount }">
									<li class="page-item" aria-current="page">
										<a class="page-link" href="./AdminListAction.sw?page=${startPage+10 }"> > </a>
									</li>
								</c:if>
							
								<!-- 마지막 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./AdminListAction.sw?page=${pageCount }"> >> </a>
								</li>
							</ul>
						</div>
					</c:if>
					
				</div>
			</div>
		</article>
	</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp"%>