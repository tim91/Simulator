var initHistoryPage = function(){
	
	
	var id = getQueryStringParams("userId");
	
	if(id){
		console.log('znalazlem z rzadaniu: ' + id);
		
	}else{
		console.log('pobieram sam');
		id= getCurrentUserId();
	}
	
	console.log('ZNalezione id uzytkownika: ' + id);
	
	getHistory(id,createHistoryTable);
};

var createHistoryTable = function(hist){
	console.log('Tworze tabelke dla: ' + hist)
};

var getQueryStringParams = function(sParam)
{
    var sPageURL = window.location.search.substring(1);
    if(sPageURL){
    	var sURLVariables = sPageURL.split('&');

        for (var i = 0; i < sURLVariables.length; i++)
        {
            var sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] == sParam)
            {
                return sParameterName[1];
            }
        }
    }
    
};