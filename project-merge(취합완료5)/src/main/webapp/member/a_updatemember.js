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
		if($("#post").val()==""){
			alert("우편번호를 입력하세요");
			$("#post").focus();
			return false;
		}
		if($("#address").val()==""){
			alert("주소를 입력하세요");
			$("#address").focus();
			return false;
		}		
		if($("#birth").val()==""){
			alert("생년월일을 입력하세요");
			return false;
		}
		if(isNaN($("#birth").val())){
			alert("숫자만 입력하세요");
			$("#birth").val("").focus();
			return false;
		}
		if($("#birth").val().length != 6 ){
			alert("생년월일은 6자리로 입력하세요 예)900102")
			$("#birth").val("").focus();
			return false;
		}		
		if($("#phone1").val()==""){
			alert("휴대폰 앞자리를 선택하세요");
			return false;
		}
		if($("#phone2").val()==""){
			alert("휴대폰 둘째자리를 입력하세요");
			return false;
		}
		if(isNaN($("#phone2").val())){
			alert("숫자만 입력하세요");
			$("#phone").val("").focus();
			return false;
		}
		if($("#phone3").val()==""){
			alert("휴대폰 끝자리를 입력하세요");
			return false;
		}
		if(isNaN($("#phone3").val())){
			alert("숫자만 입력하세요");
			$("#phone").val("").focus();
			return false;
		}
		if($("#male").is(":checked")==false && $("#female").is(":checked")==false){
			alert("남,여중 1개를 선택하시오")
			return false;
		}
		
	
	});
	
	
}); // ready end
	
