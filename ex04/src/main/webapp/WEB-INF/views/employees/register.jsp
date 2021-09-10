<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h1> 인사 등록 </h1>
		<form id="frm" action="register" method="post">
			이름 : 			<input class="form-control" type="text" id="firstName" name="firstName"><br>
			성 : 			<input class="form-control" type="text" id="lastName" name="lastName"><br>
			아이디 : 		<input class="form-control" type="text" id="email" name="email"><br>
			전화번호 : 		<input class="form-control" type="text" id="phoneNumber" name="phoneNumber"><br>
			직무: 			<select class="form-control" id="jobId" name="jobId">
								<option value="">선택</option>
								<c:forEach items="${opt.jobList}" var="job">
									<option value="${job.jobId}">${job.jobTitle }</option>
								</c:forEach>
							</select><br>
			임금 : 			<input class="form-control" type="number" id="salary" name="salary"><br>
			성과급 지급률 : <input class="form-control" type="number" id="commissionPct" name="commissionPct"><br>
			매니저 id : 	<input class="form-control" type="number" id="managerId" name="managerId" disabled="disabled">
							<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
							  	검색
							</button><br>
			부서 아이디 : 	<select class="form-control" id="departmentId" name="departmentId">
								<option value="">선택</option>
								<c:forEach items="${opt.deptList}" var="dept">
									<option value="${dept.departmentId}">${dept.departmentName}</option>
								</c:forEach>
							</select><br>
			<button type="button" id="registerBtn">입력</button>
			<button type="button" id="returnList" onclick="location.href='list'">부서 리스트로</button>
		</form>
	</div>
	
	<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	  	Launch demo modal
	</button> -->
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<label class="form-label" for="manager-choice">매니저를 선택해 주세요! </label><br>
	        <input class="form-control" list="managerList" id="manager-choice" name="manager-choice" />
			
			<datalist id="managerList">
			    <c:forEach items="${opt.managerList}" var="manager">
					<option value="${manager.employeeId}">${manager.firstName} ${manager.lastName}</option>
				</c:forEach>
			</datalist>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button id="saveManager" type="button" class="btn btn-primary">Save</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 나중에 직접 empSearch라는 jsp를 만들어서 모달을 ajax로 호출 가능하니 그것도 확인 해보자 -->
	
	<script>
		$(function() {
			$("#registerBtn").on('click', (e) => {
				e.preventDefault();
			
				let lastName = $("#lastName").val();
				let email = $("#email").val();
				let jobId = $("#jobId").val();
				let salary = $("#salary").val();
				let commissionPct = $("#commissionPct").val();
				
				if(!lastName || !email || !jobId || !salary ) {
					alert("필수조건이 비었습니다");
					return;
				}
				
				
				if(commissionPct >= 1 || commissionPct.length > 4) {
					alert("성과급 지급률의 입력 조건이 맞지 않습니다.")
					return;
				}
				
				frm.submit();
				
			})
			
			//이메일 체크도 해야함.(이거는 ajax로 해보기)
			
			$("#saveManager").on('click', () => {
				
				let managers = [];
				
				<c:forEach items="${opt.managerList}" var="manager">
					managers.push(${manager.employeeId});
				</c:forEach>
				
				let managerChoiceVal = $("#manager-choice").val();
				
				let cnt = 0;
				for(let i=0; i < managers.length; i++) {
					if(managerChoiceVal == managers[i]){
						cnt += 1;
					}
				}
				if(cnt == 0) {
					alert("없는 매니저의 사번입니다.")
					return;
				}
				
				$("#managerId").val(managerChoiceVal);
			})
			
		})
	</script>
</body>
</html>