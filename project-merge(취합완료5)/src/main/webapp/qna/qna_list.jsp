<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="/common/header.jsp"%>



<section>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>
	
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-75">
			<h3>QnA</h3>
			<p>글 갯수 : ${listcount }</p>
			<table class="table table-hover">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 10 }" />
				<c:forEach var="q" items="${qnalist }">
					<tr>
						<td>${num}<c:set var="num" value="${num-1}" />
						</td>
						
				<td>				
				
				 <!-- 댓글 제목 앞에 여백 처리 -->
				<c:if test="${ q.board_re_lev > 0 }">
				<c:forEach var="i" begin="1" end="${q.board_re_lev}">
			   	<img src="img/level.gif">
				</c:forEach>
				</c:if>
				
				<c:if test="${ q.board_re_lev > 0 }">
				<c:forEach var="i" begin="1" end="1">
			   	<img src="img/re.gif">
				</c:forEach>
				</c:if>
				
				<c:if test="${sessionScope.grade == '1' }" >
					<a href="./QnaDetailAction_1.jy?num=${q.num}&page=${page}">${q.subject}</a>
				</c:if>
				
				<c:if test="${sessionScope.grade != '1' }" >
						<a href="./QnaCheckAction.jy?num=${q.num}&page=${page}">
								${q.subject} </a>
				</c:if>		
				

						</td>

						<td>${q.id}</td>
						<td><fmt:formatDate value="${q.reg_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${q.readcount}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="container">


				<!-- 글쓰기 버튼 -->
				<div>
					<c:if test="${sessionScope.grade == '1' }">
						<button type="button" class="btn btn-secondary"
							onClick="location.href='./QnaForm.jy'">관리자 글작성</button>
					</c:if>
 					<c:if test="${sessionScope.grade == '0' }">
						<button type="button" class="btn btn-secondary"
							onClick="location.href='./QnaForm.jy'">글작성</button>
					</c:if>
					
					<c:if test="${(sessionScope.grade !=  '1') && (sessionScope.grade != '0') }">
						<button type="button" class="btn btn-secondary" 
						onClick="alert('로그인이 필요한 페이지입니다.')">글작성</button>
					</c:if> 
				</div>
				
				<!-- 페이징 영역 -->

				<div style="float: none; margin: 0 auto;"  >

					<c:if test="${listcount > 0 }">
						<div aria-label="...">
							<ul class="pagination">
								<!-- 1 페이지로 이동 -->
								<li class="page-item"><a class="page-link"
									href="./QnaListAction.jy?page=1"> << </a></li>

								<!-- 이전 블럭으로 이동 -->
								<c:if test="${startPage > 10 }">
									<li class="page-item">
										<a class="page-link" href="./QnaListAction.jy?page=${startPage - 10}"> < </a>
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
										<a class="page-link" href="./QnaListAction.jy?page=${i}">${i}</a>
										</li>
									</c:if>
								</c:forEach>

								<!-- 다음 블럭으로 이동 -->
								<c:if test="${endPage < pageCount}">
									<li class="page-item" aria-current="page">
										<a class="page-link" href="./QnaListAction.jy?page=${startPage+10 }"> > </a>
									</li>
								</c:if>

								<!-- 마지막 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./QnaListAction.jy?page=${pageCount }"> >> </a>
								</li>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</article>
	</div>
</section>


<%@ include file="/common/footer.jsp"%>