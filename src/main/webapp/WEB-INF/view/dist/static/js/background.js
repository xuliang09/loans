name1 = "";
phoneNumber1 = "";

$(function() {
	$("#searchButton").on("click", function() {
		var option = $("#test option:selected");
		if (option.text() === "姓名") {
			name1 = $("#nameOrPhone").val();
			phoneNumber1 = "";
		} else if (option.text() === "手机号") {
			name1 = "";
			phoneNumber1 = $("#nameOrPhone").val();
		} else {
		}

		$.ajax({
			url : "./search_return",
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			type : "GET",
			data : {
				name : name1,
				phoneNumber : phoneNumber1
			},
			success : function(data) {
				if (data.state === "200") {
					$('#userInfo').html(data.user);
				}
				else {
					alert("请检查您输入的 姓名 或者 手机号 是否正确!");
				}
			},
			error : function() {
				alert("请检查您输入的 姓名 或者 手机号 是否正确!");
			}
		});
	});
});
