<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">선택한 게시글 수정하기</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
		 <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    수정 폼
	                </div>
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-lg-6">
	                            <form id="actionForm" role="form" action="modify" method="post">
	                                <div class="form-group">
	                                    <label>제목</label>
	                                    <input class="form-control" name="title" value="${board.title}" placeholder="제목을 적어주세요">
	                                </div>
	                                <div class="form-group">
	                                    <label>작성자</label>
	                                    <input class="form-control" name="writer" value="${board.writer}" placeholder="이름을 적어주세요">
	                                </div>
	                                <div class="form-group">
	                                    <label>내용</label>
	                                    <textarea class="form-control" name="content" rows="3">${board.content}</textarea>
	                                </div>
	                                <input type="hidden" name="bno" value="${board.bno}">
<%-- 	                                <input type="hidden" name="pageNum" value="${cri.pageNum}"> 
									<input type="hidden" name="amount" value="${cri.amount}">
 --%>	                                <button type="submit" class="btn btn-primary">Update</button>
	                                <button type="button" id="delbtn" class="btn btn-danger">Remove</button>
	                                <button type="reset" class="btn btn-warning">Reset</button>
	                                <button type="button" class="btn btn-success" onclick="location.href='list?pageNum=${cri.pageNum}&amount=${cri.amount}'">List</button>
	                            </form>
	                        </div>
	                        <!-- /.col-lg-6 (nested) -->
	                    </div>
	                    <!-- /.row (nested) -->
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	</div>
</div>
<script>
	$(document).ready(function() {
		
		const actionForm = $('#actionForm');
		
		$('#delbtn').on('click', function() {
			if(confirm("정말로 삭제 하시겠습니까?")){
				$('#delbno').val('${board.bno}');
				
				actionForm.submit();
			}
		});
		
	});
	
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>