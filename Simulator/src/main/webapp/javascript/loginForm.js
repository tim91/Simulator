$(function(){

	$("#loginForm").submit(function(){
		   var passField = $(this).find("input[name=j_password]");
		   pass = passField.val();
		   
		   if(pass){
			   //md5
			   passField.val(CryptoJS.MD5(pass).toString());
			   return true;
		   }
		   
	});
	return true;

});