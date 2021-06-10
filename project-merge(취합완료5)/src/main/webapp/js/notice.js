$(document).ready(function(){
			$("form").submit(function(){
				
				if($("#subject").val()==""){
					alert("제목을 입력 하세요.");
					$("#subject").focus();
					return false;
				}
				
				if($("#subject").val().length > 100) {
					alert("제목을 100자 이내로 입력하세요.")
					$("#subject").val("").focus();
					return false;
				}
				
				if($("#content").val()==""){
					alert("내용을 입력 하세요.");
					$("#content").focus();
					return false;
				}
				
				var con_len = $("#content").val().length;
			
				if(con_len > 2000) {
					alert("내용을 2000자 이내로 입력하세요.\n현재 글자 수: " + con_len)
					$("#content").focus();
					return false;
				}	
					
			});			
});	