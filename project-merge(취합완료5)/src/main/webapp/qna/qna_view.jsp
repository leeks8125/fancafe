<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    
    <section>
		<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<h3></h3>
			<table class="table table-bordered">
			
				<%-- <caption>상세 페이지</caption> --%>
				<tr>
					<th>제목</th>
					<td>${qna.subject }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						${qna.id}
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:formatDate value="${qna.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>${content}</td>
				</tr>

				<tr>
					<td colspan=2 align=center>
						<c:if test="${qna.board_re_lev > 0 }">
							<input type="button" value="답글"
							onClick="location.href='./QnaReply.jy?num=${qna.num}&page=${page}' ">
						</c:if>
						<c:if test="${qna.id eq sessionScope.id }">
							<input type="button" value="글수정"
							onClick="location.href='./QnaModifyAction.jy?num=${qna.num}&page=${page}' ">
	
							<input type="button" value="글삭제"
							onClick="location.href='./QnaDeleteAction.jy?num=${qna.num}&page=${page}' ">
						</c:if>

						<input type="button" value="글목록"
						onClick="location.href='./QnaListAction.jy?page=${page}' "></td>
				</tr>

			</table>
		</article>
	</div>
</section>

			<%@ include file="/common/footer.jsp" %>