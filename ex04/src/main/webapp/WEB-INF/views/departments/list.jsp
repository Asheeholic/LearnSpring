<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Ajax list</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		부서 정보 리스트
	
		<div id="departmentList">
			<ul>
			</ul>
		</div>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		  	부서 입력
		</button><br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">부서 입력</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<form id="regDept">
					<label class="form-label" for="departmentName">부서 이름</label>
		      		<input class="form-control" type="text" id="departmentName" name="departmentName">
					<label class="form-label" for="managerId">매니저</label>
		      		<select class="form-control" type="text" id="managerId" name="managerId">
						<option value="">선택</option>
						<c:forEach items="${managerList}" var="manager">
							<option value="${manager.employeeId}">${manager.lastName}</option>
						</c:forEach>
					</select>
					<label class="form-label" for="locationId">위치</label>
		      		<select class="form-control" type="text" id="locationId" name="locationId">
						<option value="">선택</option>
						<c:forEach items="${locationList}" var="location">
							<option value="${location.locationId}">${location.city}</option>
						</c:forEach>
					</select>
		      	</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button id="insertDept" type="button" class="btn btn-primary" data-bs-dismiss="modal">Save</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
<script>

	$("#insertDept").on("click", function() {
		console.log()
		$.ajax({
			url:"api/",
			method:"post",
			data: $("#regDept").serialize(),
			dataType: "json",
			success: function(data) {
				console.log(data);
				showList();
			}
		})
	})

	function makeLi(datas) {
		let ul = $("#departmentList ul");
		for(let i=0; i<datas.length; i++) {
			let li = $('<li />');
			li.attr('data-id', datas[i].departmentId);
			console.log(datas[i].departmentId);
			let departmentId = datas[i].departmentId;
			let departmentName = datas[i].departmentName;
			let managerId = datas[i].managerId;
			let locationId = datas[i].locationId;
			let delbtn = $('<button />').attr("class", "btn btn-danger").text("삭제버튼")
			li.append(departmentId + " " + departmentName + " " + managerId + " " + locationId, delbtn)
			li.appendTo(ul);
		}
	}
	function showList() {
		$.ajax({
			url:"api/",
			dataType: "json",
			success: function(datas) {
				console.log(datas);
				makeLi(datas);
			}
		})
	}
	
	$(function() {
		showList()
	})
	
</script>
</body>
</html>