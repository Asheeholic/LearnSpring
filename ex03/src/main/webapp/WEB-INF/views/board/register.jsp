<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">게시글 등록하기</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
		 <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    입력 폼
	                </div>
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-lg-6">
	                            <form role="form" action="register" method="post">
	                                <div class="form-group">
	                                    <label>제목</label>
	                                    <input class="form-control" name="title" placeholder="제목을 적어주세요">
	                                </div>
	                                <div class="form-group">
	                                    <label>작성자</label>
	                                    <input class="form-control" name="writer" placeholder="이름을 적어주세요">
	                                </div>
	                                <div class="form-group">
	                                    <label>내용</label>
	                                    <textarea class="form-control" name="content" rows="3"></textarea>
	                                </div>
	                                <button type="submit" class="btn btn-primary">Submit</button>
	                                <button type="button" id="delbtn" class="btn btn-danger">remove</button>
	                                <button type="reset" class="btn btn-warning">Reset</button>
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
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>