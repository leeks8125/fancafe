<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp"%>

<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-75">
			<div class="position-relative">
				<h3 class="position-absolute top-50 start-50 translate-middle-x">공지사항</h3>
			</div>			
			<div>
				<p class="py-1">글 갯수 : ${listcount }</p>
			<table class="table table-hover table-striped text-center">
				<thead>
					<tr>
						<th>번호</th>
						<th class="w-50">제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="num" value="${listcount - (page-1) *10 }" />
					<c:forEach var="n" items="${noticelist }">
						<tr>
							<td>
								<!-- 번호 --> ${num} <c:set var="num" value="${num-1 }" />
							</td>
							<td class="text-start"><a href="./NoticeDetailAction.sh?num=${n.num}&page=${page}" class="text-dark">${n.subject}</a></td>
							<td>${n.id}</td>
							<td><fmt:formatDate value="${n.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${n.readcount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				<!-- 글쓰기 버튼 -->
				<div class="row py-1">
					<c:if test="${sessionScope.grade eq '1' }">
						<div class="col-6">
							<button type="button" class="btn btn-secondary"
								onClick="location.href='./NoticeForm.sh'">글쓰기</button>
						</div>
						<div class="col-6 text-end">
							<button type="button" class="btn btn-secondary"
								onClick="location.href='./NoticeForm.sh'">글쓰기</button>
						</div>
					</c:if>
				</div>
			</div>
			<div class="position-relative">
				<!-- 페이징 영역 -->
				<div class="position-absolute bottom-25 start-50 translate-middle-x" >
					<!-- bootstrap -->
					<c:if test="${listcount > 0 }">
						<div aria-label="...">
							<ul class="pagination">
								<!-- 1 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./NoticeListAction.sh?page=1"> << </a>
								</li>
								
								<!-- 이전 블럭으로 이동 -->
								<c:if test="${startPage > 10 }">
									<li class="page-item">
										<a class="page-link" href="./NoticeListAction.sh?page=${startPage-10}"> < </a>
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
											<a class="page-link" href="./NoticeListAction.sh?page=${i}">${i}</a>
										</li>
									</c:if>
								</c:forEach>
								
								<!-- 다음 블럭으로 이동 -->
								<c:if test="${endPage < pageCount }">
									<li class="page-item" aria-current="page">
										<a class="page-link" href="./NoticeListAction.sh?page=${startPage+10 }"> > </a>
									</li>
								</c:if>
							
								<!-- 마지막 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./NoticeListAction.sh?page=${pageCount }"> >> </a>
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