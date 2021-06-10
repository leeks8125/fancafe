$(document).ready(function(){
			$("form").submit(function(){
			
				if($("#passwd").val()==""){
					alert("비밀번호를 입력 하세요.");
					$("#passwd").focus();
					return false;
				}
				if($("#check").val()==""){
					alert("확인 메세지를 입력 하세요.");
					$("#check").focus();
					return false;
				}
				if($("#subject").val()==""){
					alert("제목을 입력 하세요.");
					$("#subject").focus();
					return false;
				}
				if($("#content").val()==""){
					alert("내용을 입력 하세요.");
					$("#content").focus();
					return false;
				}		
			});			
});	