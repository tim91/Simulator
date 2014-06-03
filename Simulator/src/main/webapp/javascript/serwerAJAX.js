var appName = "/Simulator";
var prefix = appName+"/rest";

var sendPost = function(uri,data,async,fun_){
	
	console.log("Wysylam dane na serwer: " + data);
	
	var res = $.ajax({
		  type: "POST",
		  url: prefix + uri,
		  data: data,
		  async:   async,
		  processData: false,
		  success: function(data, textStatus, xhr) {
			  console.log('post ok');
			  if(async && fun_){
				  console.log('Po wyslaniu:' + data.responseText);
				  fun_(data);
			  }
          },
          error: function(xhr, textStatus, errorThrown) {
        	  console.log('post fail');
          },
          contentType: "application/json",
		});
	return res;
};

var sendGet = function(uri,param,async,function_){
	
	var len = 0;
	if(param){
		len = param.length;
	}
	
	uri += '?';
	if(len > 0){
		uri += param[0];
	}
	
	for(var i=1;i<len;i++){
		el = param[i];
		uri+='&'+el;
	}
	
	var res = jQuery.ajax({
		type: "GET",
        url:    prefix+uri,
        success: function(result) {
                     if(result.isOk == false)
                         alert(result.message);
                     else{
                    	 if(async && function_){
                 			function_(result);
                 		}
                     }
                 },
        async:   async
   });  

	return res;
};

