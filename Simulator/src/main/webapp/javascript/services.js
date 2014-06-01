var getCurrentUserId = function(){
	
	var id = sendGet("/users/getId",[],false,null);
	var r = parseInt(id.responseText);
	console.log(r);
	return r;
};

var getHistory = function(userId,fun){
	
	var p = [];
	p.push('userId=' + userId);
	sendGet("/flyHistory/byUserId",p,true,fun);
}