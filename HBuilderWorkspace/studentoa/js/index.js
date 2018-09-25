function load(){
	var storage = window.localStorage;
	$.post(
		"http://localhost:8080/user/",
		{
			email: storage["email"],
			token: storage["token"]
		},
		function(data){
				$("#yourselves").html(data.data.username);
		}
	);
	$("#yourselves").html(storage["username"]);
}

$(document).ready(function(){
  $("#personInfo").click(function(){
    $("#motherBoard").load("personInfo/personInfo.html");
  });
  
})