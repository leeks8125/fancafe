<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp"%>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/qna/script.js"></script>
<section>
	<div id="contents" class="col-10 container-fluid">
		<article class="row h-50">
			<h3>작성글 삭제</h3>

			<form action="<%=request.getContextPath()%>/QnaDelete.jy"
				method="post">

				<input type="hidden" name="num" value="${param.num }"> 
				<input type="hidden" name="page" value="${param.page }">

				<table class="table table-bordered">

					<tr>
						<td colspan="2" align="center">
							삭제하시려면 작성 시 입력한 '<span style = 'color:red;'>비밀번호</span>' 를 입력하세요
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input name="passwd" id="passwd" type="password"
							size="10" maxlength="10" value="" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type=submit value="삭제"> <input
							type=reset value="취소"  onclick="history.go(-1)"></td>
					</tr>
					
				</table>
			</form>
		</article>
	</div>
</section>

</body>
<%@ include file="/common/footer.jsp"%>
</html>