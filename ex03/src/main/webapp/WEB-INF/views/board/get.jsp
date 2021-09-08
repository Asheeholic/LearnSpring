<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

${board }
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
		                </div>
		                <div class="panel-body">
		                	<ul class="chat">
		                		
		                	</ul>
		                </div>
		                <div class="panel-footer">
		                </div>
		            </div>
		        </div>
		        <!-- 댓글 끝 -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	</div>
</div>
<script>
	
	$(function() {
		let bno = "${board.bno}";
		let replyUL = $('.chat');	
		function makeLi(data) {
			return '<li class="left clearfix">'
			+		'<div class="header">'
			+			'<strong class="primary-font">' + data.replyer + '</strong>'
			+			'<small class="pull-right text-muted">' + data.replyDate + '</small>'
			+			'<p>' + data.reply + '</p>'
			+		'</div>'
			+	'</li>';
		}		
		
		// 삭제처리
		
		// 수정처리
		
		// 등록처리
		$("#saveReply").on('click', function(e) {
			e.preventDefault();
			$.ajax({
				url: "../reply/",
				method: "post",
				data: $("#replyForm").serialize(),
				dataType: "json",
				success: function(data){
					console.log(data);
        			showList(1);
				},
				error: function(){}
			})
		})
		
		
		// 목록처리
		let pageNum = 1;
		let replyPageFooter = $(".panel-footer");
		
		function showReplyPage(replyCnt) {
			let endNum = Math.ceil(pageNum / 10.0) * 10;
			let startNum = endNum - 9;
			
			let prev = startNum != 1;
			let next = false;
			
			if((endNum * 10) >= replyCnt) {
				endNum = Math.ceil(replyCnt/10.0);
			}
			
			if((endNum * 10) < replyCnt) {
				next = true;
			}
			
			let str = "<ul class='pagination pull-right'>";
			
			if(prev) {
				str += "<li class='page-itme'><a class='page-link' href='" + (stratNum -1 ) + "'>Previous</a></li>";
			}
			
			for(let i = startNum; i <= endNum; i++) {
				let active = pageNum == i ? "active" : "";
				
				str += "<li class='page-itme'" + active + "><a class='page-link' href='" + i + "'>" + i + "</a></li>";
			}
			
			if(prev) {
				str += "<li class='page-itme'><a class='page-link' href='" + (endNum +1 ) + "'>Next</a></li>";
			}
			
			str += "</ul></div>";
			
			console.log(str);
			
			replyPageFooter.html(str);
		}
		
		function showList(pageNum) {
			$(".chat").empty();
			$.ajax({
				
				url: "../reply/${board.bno}/" + pageNum,
				dataType: "json",
				success: function(datas){
					console.log(datas)
					let str = "";
					for(i=0; i<datas.length; i++) {
						str += makeLi(datas[i]);
					}
					$(".chat").html(str);
					showReplyPage(${board.replyCnt});
				},
				error: (e) => console.log(e)
			})
		}
		
		showList(1);
		
		replyPageFooter.on('click',"li a", function(e) {
			e.preventDefault();
			console.log("page click");
			
			let targetPageNum = $(this).attr("href");
			
			console.log("targetPageNum : " + targetPageNum);
			
			pageNum = targetPageNum;
			
			showList(pageNum);
		})
		
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