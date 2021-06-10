<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp"%>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>
<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<h3>작성글 삭제(관리자)</h3>

			<form action="<%=request.getContextPath()%>/QnaDelete_1.jy"
				method="post">
				<input type="hidden" name="grade" value="${sessionScope.grade}">
				<input type="hidden" name="num" value="${param.num }"> 
				<input type="hidden" name="page" value="${param.page }">

				<table class="table table-bordered">


					<tr>
						<td colspan="2" align="center">
							삭제하시려면 '<span style = 'color:red;'>관리자 확인 메세지</span>' 를 입력하세요
						</td>
					</tr>
					<tr>
						<th>확인 메세지</th>
							<td>
								<input type="text" name="check" id="check" maxlength="4">
							</td>
					</tr>
						
					<tr>
						<td colspan="2" align="center"><input type=submit value="삭제"> 
						<input type=reset value="취소"  onclick="history.go(-1)"></td>
					</tr>

				</table>
			</form>
		</article>
	</div>
</section>

<%@ include file="/common/footer.jsp"%>
