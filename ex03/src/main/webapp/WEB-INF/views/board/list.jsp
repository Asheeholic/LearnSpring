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
					<th>글 작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bno }</td>
						<td><a href="get?bno=${board.bno}">${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate}" type="both"/></td>
						<td><fmt:formatDate value="${board.updatedate}" type="both"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>