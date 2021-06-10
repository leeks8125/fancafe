<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">공지사항</h3>
				</div>
				<div>
					<table class="table table-bordered border-dark">
						<tr>
							<th class="text-center">제목</th>
							<td>
								${notice.subject}
							</td>
						</tr>
						<tr>
							<th class="text-center">작성자</th>
							<td>
								${notice.id}
							</td>
						</tr>
						<tr>
							<th class="text-center">작성일</th>
							<td>
								<fmt:formatDate value="${notice.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<td colspan="2" class="bg-white">
								${content}
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">
								<c:if test="${sessionScope.grade eq '1' }">
									<input type="button" value="수정" class="btn btn-secondary btn-sm"
										onClick="location.href='./NoticeModifyAction.sh?num=${notice.num}&page=${page}'">
									<input type="button" value="삭제" class="btn btn-secondary btn-sm"
										onClick="location.href='./NoticeDeleteAction.sh?num=${notice.num}&page=${page}'">
								</c:if>
								<input type="button" value="목록" class="btn btn-secondary btn-sm"
									onClick="location.href='./NoticeListAction.sh?page=${page}'">
							</td>
						</tr>
					</table>
				</div>
			</article>
		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>