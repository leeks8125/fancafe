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
					<tr>
						<th>제목</th>
						<td>
							${gallery.title}
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							${gallery.author}
						</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>
							${gallery.uploaddate}
						</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>
							${gallery.hits}
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							${contents}
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<img src="./galleryupload/${gallery.fname}">
						</td>
					<tr>
						<td colspan="2">
							<c:if test="${sessionScope.id == gallery.author}">
								<input type="button" value="수정"
									onClick="location.href='./GalleryModifyAction.dk?no=${gallery.no}'">
								<input type="button" value="삭제"
									onClick="location.href='./GalleryDeleteAction.dk?no=${gallery.no}'">
							</c:if>
							<c:if test="${sessionScope.grade eq '1' }">
								<input type="button" value="삭제"
									onClick="location.href='./GalleryDeleteAction.dk?no=${gallery.no}'">
							</c:if>
							<input type="button" value="목록"
								onClick="location.href='./GalleryListAction.dk'">
						</td>
					</tr>
				</table>
			</article>
		</div>
	</section>
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>