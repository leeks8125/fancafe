$(document).ready(function(){	
	
	// ID체크(중복검사 및 유효아이디 영문명 길이는 최소 6이상 10자 이하)
	$("#idcheck").click(function(){
		
		var pattern  = /^[a-zA-Z]+$/;      // 영문 소문자, 대문자, 숫자(0~9)
		var id = $("#id").val();
		
		if($("#id").val()==""){
			$("#myid").text("아이디를 입력하세요");
			$("#id").focus();
//			return false;
		}else if($("#id").val().length < 6 || $("#id").val().length > 10){
			$("#myid").text("아이디는 6~10자리 입니다");
			$("#id").val("").focus();
//			return false;	
		}else if(!pattern.test(id)){	
			$("#myid").text("아이디는 영문자만 사용 가능합니다.");
			$("#id").val("").focus();
//			return false;			
		}else{
			var id = $("#id").val();
			
			$.ajax({
				type:"post",
				url:"IdCheck.yw",
				data:{"id":id},
				datatype:"text",
				success:function(data){
					
					if(data==1){
						$("#myid").text("중복ID 입니다");
						$("#id").focus();					
					}else{
						$("#myid").text("사용가능한 ID 입니다");
						$("#pass").focus();
					}
				}
				
			});
		}
		
	});
	
	
	
	// 비밀번호 체크(대소문자 구분, 길이는 최소 6이상 10자 이하, 특수문자 1글자 무조건 있어야함 !,@,#,$,* 만 허용)
	$("#passcheck").click(function(){
		
/*		var pattern  = /^[a-zA-Z0-9]+$/;        
		var pass = $("#pass").val();*/
		
		if($("#pass").val()==""){
			$("#mypass").text("비밀번호룰 입력하세요");
			$("#pass").focus();
//			return false;
		}else if($("#pass").val().length < 6 || $("#pass").val().length > 10){
			$("#mypass").text("비밀번호는 6~10자리입니다");
			$("#pass").val("").focus();
//			return false;
/*		}else if(!pattern.test(pass)){
			$("#mypass").text("비밀번호는 특수문자 1개이상(!@#$*)을 포함해야 합니다");
			$("#pass").val("").focus();*/
//			return false;	
		}else{
			$("#mypass").text("사용가능한 비밀번호입니다");
		}		
		
	});
		
		
		
		
	
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
		
		var pattern  = /^[a-zA-Z]+$/;      // 영문 소문자, 대문자, 숫자(0~9)
		var id = $("#id").val();
		
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
		if(!pattern.test(id)){
			alert("아이디는 영문만 가능합니다");
			$("#id").val("").focus();
			return false;	
		}
		if($("#pass").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pass").focus();
			return false;
		}
		if($("#pass").val().length < 6 || $("#pass").val().length > 10){
			alert("비밀번호는 6~10자리 입니다");
			$("#pass").val("").focus();
			return false;	
		}	
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
	
