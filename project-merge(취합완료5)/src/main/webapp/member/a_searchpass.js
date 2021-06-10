$(document).ready(function(){
	
	
	
	// 도메인 선택
	$("#email").change(function(){
		if($("#email").val()==""){
			$("#domain").attr("readonly, false");
			$("#domain").removeAttr("readonly");
			$("#domain").val("").focus();
		}else{
			$("#domain").val($("#email").val());
			$("#domain").attr("readonly","readonly");
		}
		
	});
	
		
	// 유효성 검사
	$("form").submit(function(){
		
		if($("#id").val() == ""){
			alert("ID를 입력하세요");
			$("#id").focus();
			return false;
		}	
		if($("#id").val().length < 6 || $("#id").val().length > 10){
			alert("아이디는 6~10자리 입니다");
			$("#id").val("").focus();
			return false;	
		}	
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		if($("#mailid").val()==""){
			alert("Email 주소를 입력하세요");
			$("#mailid").focus();
			return false;
		}
		if($("#domain").val()==""){
			alert("도메인을 입력하세요");
			$("#domain").focus();
			return false;
		}
	
	
	});
	
	
}); // ready end
	
