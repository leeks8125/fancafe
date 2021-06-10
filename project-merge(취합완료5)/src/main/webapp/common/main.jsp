<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="header.jsp"%>

<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-25">
			<h5>공지사항</h5>
			<div>
				<table class="table table-sm">
					<tr>
						<th class="text-center w-50">제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">날짜</th>
					</tr>
	
					<c:forEach var="n" items="${noticelist }">
						<tr>
							<td><a
								href="./NoticeDetailAction.sh?num=${n.num}&page=1" class="text-dark">${n.subject}</a></td>
							<td class="text-center">${n.id}</td>
							<td class="text-center"><fmt:formatDate value="${n.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</article>
	</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="footer.jsp"%>