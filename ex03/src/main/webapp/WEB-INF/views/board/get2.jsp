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
	            <!-- 댓글 등록 시작 -->
	            <div class="col-12-lg">      
		            <div class="panel panel-default">
		            	<div class="panel-heading">
		            		<i class="fa fa-comments fa-fw"></i>댓글 등록
		                </div>
		                <div class="panel-body">
							<form id="replyForm">
								<input type="hidden" name="bno" value="${board.bno }">
								<input name="replyer" value="user10">
								<input name="reply">
								<button type="button" id="saveReply">댓글등록</button>
							</form>
		                </div>
		            </div>
		        </div>
		        <!-- 댓글 등록 끝 -->
	            <!-- 댓글 시작 -->
	            <div class="col-12-lg">      
		            <div class="panel panel-default">
		            	<div class="panel-heading">
		            		<i class="fa fa-comments fa-fw"></i>댓글
		            		<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">새 댓글</button>
		                </div>
		                <div class="panel-body">
		                	<ul class="chat">
		                		
		                	</ul>
		                </div>
		            </div>
		        </div>
		        <!-- 댓글 끝 -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">REPLY Modal</h4>
            </div>
            <div class="modal-body">
            	<div class="form-group">
            		<label>Reply</label>
            		<input class="form-control" name="reply" value="New Reply!">
            	</div>
            	<div class="form-group">
            		<label>Replyer</label>
            		<input class="form-control" name="replyer" value="New ReplyERER!!">
            	</div>
            	<div class="form-group">
            		<label>Reply Date</label>
            		<input class="form-control" name="replyDate" value="">
            	</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">register</button>
                <button type="button" class="btn btn-warning">Modify</button>
                <button type="button" class="btn btn-danger">Remove</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script src="${pageContext.request.contextPath}/resources/js/reply.js"></script>
<script>
	
	$(function() {
		
		let bno = "${board.bno}";
		
		// 등록처리
		$("#saveReply").on('click', function(e) {
			e.preventDefault();
			replyService.add( (data) => {
				$(".chat").append( makeLi(data) )
			});
		})
		
		// 목록처리
		
		function listCallback(datas){
			str = "";
			for(i=0; i<datas.length; i++) {
				str += makeLi(datas[i]); 
			};
			$(".chat").html(str)
		};
		
		function makeLi(data) {
			return 		'<li class="left clearfix">'
					+		'<div class="header">'
					+			'<strong class="primary-font">' + data.replyer + '</strong>'
					+			'<small class="pull-right text-muted">' + data.replyDate + '</small>'
					+			'<p>' + data.reply + '</p>'
					+		'</div>'
					+	'</li>';
		}

		replyService.getList({bno: bno}, listCallback);		
		
	})
</script>
<script>
	$(document).ready(function() {
		
		const actionForm = $('#actionForm');
		
		/* $('#delbtn').on('click', function() {
			if(confirm("정말로 삭제 하시겠습니까?")){
				$('#delbno').val('${board.bno}');
				
				actionForm.submit();
			}
		}); */
	});
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>