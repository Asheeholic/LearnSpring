<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">스프링 게시판</h1>
		<table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글 제목</th>
					<th>글 내용</th>
					<th>글 작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bno }</td>
						<td><a class="move" href="${board.bno}">${board.title } [${board.replyCnt }]</a></td>
						<td>${board.content }</td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate}" type="both"/></td>
						<td><fmt:formatDate value="${board.updatedate}" type="both"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" class="btn btn-success" onclick="location.href='register'">Register</button>
		<form id="actionForm" action="list" method="get">
			<select name="type">
				<option value=""  <c:out value="${pageMaker.cri.type == null ? 'selected' : '' }" /> >--</option>
				<option value="T"  <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : '' }" /> >제목
				<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }" /> >내용
				<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : '' }" /> >작성자</option>
				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : '' }" /> >제목 or 내용</option>
				<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : '' }" /> >제목 or 작성자</option>
				<option value="TWC"<c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected' : '' }" /> >제목 or 내용 or 작성자</option>
			</select>
			<input name="keyword" value="${pageMaker.cri.keyword}">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"> 
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<button class='btn btn-default'>Search</button>
		</form>
		<div id="pageButton">
			<c:if test="${pageMaker.prev}"><a href="${pageMaker.startPage-1}">이전</a></c:if>
			<c:forEach begin="${pageMaker.startPage}" 
						end="${pageMaker.endPage}" 
						var="num"><a href="${num}">${num}</a></c:forEach>
			<c:if test="${pageMaker.next}"><a href="${pageMaker.endPage+1}">다음</a></c:if>
		</div>
	</div>
</div>
<script>
	$(function() {
		
		const actionForm = $("#actionForm");

		$(".move").on('click', function(e) {
			e.preventDefault();
			let bno = $(this).attr("href");
			actionForm.append('<input type="hidden" name="bno" value="' + bno + '">');
			actionForm.attr('action', 'get');
			actionForm.submit();
		});
		
		
		$("#pageButton a").on('click', function(e) {
			e.preventDefault();
			
			let p = $(this).attr("href");
			$("[name='pageNum']").val(p);
			actionForm.submit();
			
		})
	})
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>