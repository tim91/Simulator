var getCurrentUserId = function(){
	
	var id = sendGet("/users/getId",[],false,null);
	var r = parseInt(id.responseText);
	console.log(r);
	return r;
};

var saveHistory = function(vals){
	var id = sendPost("/flyHistory",vals,false,null);
	saveHistoryInLocalStorage(vals, id.responseText);
}

var saveHistoryInLocalStorage = function(vals,id){
	if(typeof(Storage)!=="undefined")
	{
		console.log(id + ' zapisuje: ' + vals + ' localStorage');
		localStorage.setItem('H'+id,vals);
	}
}

var getCurrentUser = function(){
	
	var res = sendGet("/users",[],false,null);
	return res.responseJSON;
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