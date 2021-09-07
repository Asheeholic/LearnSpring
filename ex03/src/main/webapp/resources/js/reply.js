//reply.js
console.log("Reply Module");

let replyService = (function() {
	function add(callback, error) {
		$.ajax({
			url : "../reply/",
			data : $("#replyForm").serialize(),
			method : "post",
			dataType : "json",
			success : (data) => {
				if(callback) callback(data);
			},
			error : () => {
				if(error) error();
			}
		})
	}
	
	function getList(param, callback, error) {
		
		const bno = param.bno;
		const page = param.page || 1;
		
		$.ajax({
			url : "../reply/ " + bno + "/" + page,
			dataType : "json",
			success : (data) => {
				if(callback) callback(data);
			},
			error : () => {
				if(error) error();
			}
		})
	}
	
	function remove(rno, callback, error) {
		$.ajax({
			type: 'delete',
			url : "../reply/ " + rno,
			dataType : "json",
			success : (data) => {
				if(callback) callback(data);
			},
			error : () => {
				if(error) error();
			}
		})
	}
	
	// 아직 제대로 선언이 안됨.
	/*function update(reply, callback, error) {
		$.ajax({
			type: 'put',
			url : "../reply/ ",
			data: JSON.stringify(reply),
			dataType : "json",
			success : (data) => {
				if(callback) callback(data);
			},
			error : () => {
				if(error) error();
			}
		})
	}*/
	
	return {
		add: add,
		getList: getList,
		remove: remove,
		update: update
	}
})();