var currUserId = null;

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
		var t = $('#historyTable tr:last');
		d = new Date();
		d.setTime(hist[i].timeLong);
		date = f = moment(d).format('ddd DD MMMM YYYY, h:mm:ss a');
		t.after('<tr><td><div class=\"rowText\">'+date+'</div><div class=\"rowButton\"><button type=\"submit\" id=\"'+hist[i].id+'\" class=\"btn btn-success\" onClick="play(this)">Zobacz</button></div></td></tr>');
	}
	
};

var play = function(el)
{
	console.log(el);
	var id = el.id;
	if(id){
		var h = getHistory(id);
		console.log(h);
		redirect("/index.html?posX="+h.posX+"&posY="+h.posY+"&posZ="+h.posZ+"&velX="+h.velX+"&velY="+h.velY+"&velZ="+h.velZ);
	}
	
};