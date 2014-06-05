var currUserId = null;
var getCurrentUserId = function(){
	
	var id = sendGet("/users/getId",[],false,null);
	var r = parseInt(id.responseText);
	console.log(r);
	return r;
};

var saveHistory = function(vals){
	var jsons = sendPost("/flyHistory",vals,false,null);
	var j = JSON.parse(jsons.responseText);
	saveHistoryInLocalStorage(vals, j.id);
	addHistoryToTable(j);
}

var saveHistoryInLocalStorage = function(vals,id){
	if(typeof(Storage)!=="undefined")
	{
		console.log(id + ' zapisuje: ' + vals + ' localStorage');
		localStorage.setItem('H'+id,vals);
	}
}

var addHistoryToTable = function(j){
	var t = [];
	t.push(j);
	createHistoryTable(t);
};

var getCurrentUser = function(){
	
	var res = sendGet("/users",[],false,null);
	return res.responseJSON;
};

var getAllHistory = function(userId,fun){
	
	var p = [];
	sendGet("/flyHistory/byUserId/" + userId,p,true,fun);
}

var getHistory = function(id,fun){
	res = sendGet("/flyHistory/byId/"+id,[],false,fun);
	return res.responseJSON;
}

var redirect = function(link){
	window.location.href = appName + link;
}

var initHistoryPage = function(){
	
	
	var id = getQueryStringParams("userId");
	
	if(id){
		console.log('znalazlem z rzadaniu: ' + id);
		
	}else{
		console.log('pobieram sam');
		id= getCurrentUserId();
	}
	
	console.log('ZNalezione id uzytkownika: ' + id);
	
	currUserId = id;
	getAllHistory(id,createHistoryTable);
};

var createHistoryTable = function(hist){
	console.log('Tworze tabelke dla: ' + hist)
	
	var len = hist.length;
	moment.lang("pl");
	for(var i=0; i< len ; i++){
		var t = $('#historyTable tbody tr:last');
		d = new Date();
		d.setTime(hist[i].timeLong);
		date = f = moment(d).format('ddd DD MMMM YYYY, h:mm:ss a');
		t.after('<tr><td><div class=\"rowText\">'+date+'</div><div class=\"rowButton\"><button id=\"'+hist[i].id+'\" class=\"btn btn-success\" onClick="play(this)">Zobacz</button></div></td></tr>');
	}
	
};

var play = function(el)
{
	console.log(el);
	var id = el.id;
	if(id){
		//sprawdz localStorage
		var fromLocal = localStorage.getItem('H'+id);
		var h = null;
		if(fromLocal){
			console.log('Pobralem z localStorageL ' + fromLocal);
			h = JSON.parse(fromLocal);
		}else{
			h = getHistory(id);
		}
		console.log(h);
		stop();
		init(h,false);
		
	}
	
};