$(document).ready(function(){
			$("form").submit(function(){
				if($("#name").val()==""){
					alert("이름을 입력 하세요?");
					$("#name").focus();
					return false;
				}
				if($("#id").val()==""){
					alert("아이디를 입력 하세요?");
					$("#id").focus();
					return false;
				}
				if($("#pass").val()==""){
					alert("비밀번호를 입력 하세요?");
					$("#pass").focus();
					return false;
				}
				if($("#subject").val()==""){
					alert("제목을 입력 하세요?");
					$("#subject").focus();
					return false;
				}
				if($("#content").val()==""){
					alert("내용을 입력 하세요?");
					$("#content").focus();
					return false;
				}	
				if($("#content1").val()==""){
					alert("댓글 내용을 입력 하세요?");
					$("#content1").focus();
					return false;
				}			
			});			
});	