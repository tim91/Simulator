var getCurrentUserId = function(){
	
	var id = sendGet("/users/getId",[],false,null);
	var r = parseInt(id.responseText);
	console.log(r);
	return r;
};

var getAllHistory = function(userId,fun){
	
	var p = [];
	sendGet("/flyHistory/byUserId/" + userId,p,true,fun);
}

var getHistory = function(id){
	res = sendGet("/flyHistory/byId/"+id,[],false,null);
	return res.responseJSON;
}

var redirect = function(link){
	window.location.href = appName + link;
}