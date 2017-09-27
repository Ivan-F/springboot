function fetchData(url){
	if(url != null && url != ""){
		url = "http://" + url;
	}else{
		url = "https://api.github.com/";
	}
	fetch(url,{
		method:"GET",
		header:{"Access-Control-Allow-Origin":"*"},
		 mode: 'cors', 
		 redirect: 'follow',
	}).then(function(response){
		return response.json();
	}).then(function(data){
		document.getElementById("well").innerText=JSON.stringify(data);
	})
	
}
	
	
	window.onload=function(){
		document.getElementById("url")
			.onblur=function(e){
				var url = document.getElementById("url").value;
				fetchData(url)
			}
	}
