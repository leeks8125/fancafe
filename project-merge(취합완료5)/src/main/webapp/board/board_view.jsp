<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="css/board.css">
<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/script.js"></script>
<section>
<div id="contents" class="col-10 container-fluid">
			<article class="row h-50">
				<div class="position-relative">
					<h3 class="position-absolute top-50 start-50 translate-middle-x">상세페이지</h3>
				</div>
				<div>
<table class="table table-hover table-striped text-center">
	
	<tr align=center><td class="td" width="15%">제목</td>
		<td class="td" width="85%">${mboard.subject }</td>
	</tr>
	<tr ><td align=center class="td">내용</td>
		<td class="td">
			<pre>${mboard.content }</pre>
		</td>	
	</tr>
	<tr>
	<c:if test="${sessionScope.id != null && sessionScope.id == mboard.id}">
		<td colspan=2 align=center>
				
				<input type="button" value="수정" 
onClick="location.href='./Boardmodifyaction.ks?num=${mboard.num}&page=${page}' ">
				<input type="button" value="삭제" 
onClick="location.href='./Boarddeleteaction.ks?num=${mboard.num}&page=${page}' ">
				<input type="button" value="목록" 
onClick="location.href='./Boardlistaction.ks?page=${page}' ">
				
		</td>
		</c:if>
		
		<c:if test="${sessionScope.id == null || sessionScope.id != mboard.id}">
		<td colspan=2 align=center>
				
				<input type="button" value="목록" 
onClick="location.href='./Boardlistaction.ks?page=${page}' ">
				
		</td>
		</c:if>
	</tr>

</table>
<br>

<c:if test="${sessionScope.id != null }">
<form action="<%=request.getContextPath() %>/Boardreply.ks?num=${mboard.num}&page=${page }" method="post">
<input type="hidden" name="id" value="${mboard.id }">

<table class="board_table" border=1 width=600 align=center>
	<tr>
		<td colspan="71">댓글</td>
	</tr>
	<tr>
		<td><textarea cols="70" rows="3" id="content1" name="content1" placeholder="댓글을 입력하세요"></textarea>
		<td> <input type="submit" style="width:80px; height:70px;" value="입력"></td>
	</tr>
</table>

</form>
</c:if>

<c:if test="${sessionScope.id == null }">
<form action="<%=request.getContextPath() %>/LoginForm.yw?num=${mboard.num}&page=${page}" method="post">
<input type="hidden" name="id" value="${mboard.id }">
<table class="board_table" border=1 width=600 align=center>
<tr>
		<td >댓글</td>
	</tr>
	<tr>
		<td><textarea cols="70" rows="3" id="content1" name="content1" placeholder="댓글을 입력하세요"></textarea>
		<td> <input type="submit" style="width:80px; height:70px;" value="입력"></td>
	</tr>
</table>
</form>
</c:if>

<table class="board_table" border=1 width=600 align=center>
<c:forEach var="b" items="${listre }">
<tr align=center>
	
	
	<td class="td">${b.id }</td>
	<td class="td" width=300px >${b.content }</td>
	<td class="td" width=180px><fmt:formatDate value="${b.reg_date}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
					
					<c:if test="${sessionScope.id != null && sessionScope.id == b.id}">
					<td width=130px><input type="button" value="수정" 
							onClick="location.href='./Boardreplymodifyaction.ks?num=${b.num}&page=${page}&re_seq=${b.re_seq }' ">
						<input type="button" value="삭제" 
								onClick="location.href='./Boardreplydeleteaction.ks?num=${b.num}&page=${page}&re_seq=${b.re_seq }' "></td>
					</c:if>
					<c:if test="${sessionScope.id == null || sessionScope.id != b.id }">
						<td>
						<c:if test="${sessionScope.grade eq '1' }">
							<input type="button" value="삭제"
							onClick="location.href='./AdminBoardDelForm.sw?num=${b.num}&page=${page}&re_seq=${b.re_seq }&flag=r'">
						</c:if>
						</td>
					</c:if>
</tr>
</c:forEach>
</table>

</div>
			</article>
		</div>
</section>
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>