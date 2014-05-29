var prefix = "/Simulator/rest";

var sendPost = function(uri,data){
	
	console.log("Wysylam dane na serwer: " + data);
	
	$.ajax({
		  type: "POST",
		  url: prefix + uri,
		  data: data,
		  processData: false,
		  success: function(data, textStatus, xhr) {
			  console.log('post ok');
          },
          error: function(xhr, textStatus, errorThrown) {
        	  console.log('post fail');
          },
          contentType: "application/json",
		});
}