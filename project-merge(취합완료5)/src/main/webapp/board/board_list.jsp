<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="css/board.css">
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
<section>
	<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">자유게시판</h3>
				</div>
				<div>

	<table class="table table-hover table-striped text-center">
		<tr>
			<th colspan="5">글 갯수 : ${listcount} 개</th>
		</tr>
		<tr align=center>
			<th>번호</th>
			<th class="w-60">제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

		<c:set var="num" value="${listcount - (page-1) * 10 }" />
		<c:forEach var="b" items="${boardlist }">
			<tr align=center>
				<td class="td">${num}<c:set var="num" value="${num-1}" />
				</td>
				<td class="td"><a class="a"
					href="./Boarddetailaction.ks?num=${b.num}&page=${page}">
						${b.subject} </a></td>
				<td class="td">${b.id }</td>
				<td class="td"><fmt:formatDate value="${b.reg_date}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td class="td">${b.readcount}</td>
			</tr>

		</c:forEach>


	</table>

	<table  width=700 align=center>
		<c:if test="${sessionScope.id != null }">
			<tr>
				<td align=right><input type="button" value="글쓰기"
					onClick="location.href='./write.ks' "></td>
			</tr>
		</c:if>

		<c:if test="${sessionScope.id == null }">
			<tr>
				<td align=right><input type="button" value="글쓰기"
					onClick="location.href='LoginForm.yw' "></td>
			</tr>
		</c:if>

	</table>

	<br>


	<!-- 페이지 처리 -->
	<div class="position-absolute bottom-25 start-50 translate-middle-x"  >
		<c:if test="${listcount > 0 }">
			<div aria-label="...">
				<ul class="pagination">
					<!-- 1 페이지로 이동 -->
					<li class="page-item"><a class="page-link"
						href="./Boardlistaction.ks?page=1"> << </a></li>

					<!-- 이전 블럭으로 이동 -->
					<c:if test="${startPage > 10 }">
						<li class="page-item"><a class="page-link"
							href="./Boardlistaction.ks?page=${startPage-10}"> < </a></li>
					</c:if>

					<!-- 각 블럭에 10개의 페이지 출력 -->
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:if test="${i == page }">
							<!-- 현재 페이지 -->
							<li class="page-item active"><a class="page-link">${i}</a>
							</li>
						</c:if>
						<c:if test="${i != page }">
							<!-- 현재 페이지가 아닌 경우 -->
							<li class="page-item"><a class="page-link"
								href="./Boardlistaction.ks?page=${i}">${i}</a></li>
						</c:if>
					</c:forEach>

					<!-- 다음 블럭으로 이동 -->
					<c:if test="${endPage < pageCount }">
						<li class="page-item" aria-current="page"><a
							class="page-link"
							href="./Boardlistaction.ks?page=${startPage+10 }"> > </a></li>
					</c:if>

					<!-- 마지막 페이지로 이동 -->
					<li class="page-item"><a class="page-link"
						href="./Boardlistaction.ks?page=${pageCount }"> >> </a></li>
				</ul>
			</div>
		</c:if>
		</div>
		</div>
			</article>
		</div>
</section>
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>
