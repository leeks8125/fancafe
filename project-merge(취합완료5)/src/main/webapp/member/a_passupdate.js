$(document).ready(function(){
	

		
	
		// 새로운 비밀번호 체크(대소문자 구분, 길이는 최소 6이상 10자 이하, 특수문자 1글자 무조건 있어야함 !,@,#,$,* 만 허용)
	$("#newpasscheck").click(function(){
		
		
		
		if($("#newpass").val()==""){
			$("#mynewpass").text("새 비밀번호룰 입력하세요");
			$("new#pass").focus();
			return false;
		}else if($("#newpass").val().length < 6 || $("#pass").val().length > 10){
			$("#mynewpass").text("새 비밀번호는 6~10자리입니다");
			$("new#pass").val("").focus();
			return false;
		}else{
			$("#mynewpass").text("사용가능한 새로운 비밀번호입니다");
		}
		
		
		});
	
	
		
	// 유효성 검사
	$("form").submit(function(){
		

		if($("#passcopy").val()==""){
			alert("비밀번호 확인란을 입력하세요");
			$("#passcopy").focus();
			return false;
		}	
		if($("#pass").val() != $("#passcopy").val()){
			alert("비밀번호가 같지 않습니다. 비밀번호 확인란을 다시 입력하세요");
			$("#passcopy").val("").focus();
			return false;			
		}
		
		
		
		/* 비밀번호 수정 유효성검사*/
		
		if($("#newpass").val()==""){
			alert("새 비밀번호를 입력하세요");
			$("#newpass").focus();
			return false;
		}
		if($("#newpass").val().length < 6 || $("#newpass").val().length > 10){
			alert("새 비밀번호는 6~10자리 입니다");
			$("#newpass").val("").focus();
			return false;	
		}	
		if($("#newpasscopy").val()==""){
			alert("새 비밀번호 확인란을 입력하세요");
			$("#newpasscopy").focus();
			return false;
		}	
		if($("#newpass").val() != $("#newpasscopy").val()){
			alert("새 비밀번호가 같지 않습니다. 새 비밀번호 확인란을 다시 입력하세요");
			$("#newpasscopy").val("").focus();
			return false;			
		}	
		
		/* 비밀번호 수정 유효성검사*/
			
			
		
	
	});
	
	
}); // ready end
	
