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