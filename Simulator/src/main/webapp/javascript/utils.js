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

var getAllQueryStringParams = function()
{
    var sPageURL = window.location.search.substring(1);
    var res = [];
    if(sPageURL){
    	var sURLVariables = sPageURL.split('&');

        for (var i = 0; i < sURLVariables.length; i++)
        {
            var sParameterName = sURLVariables[i].split('=');
            res.push(sParameterName[1]);
        }
    }
    return res;
    
};