$(document).ready(function(){
	var storage = window.localStorage;
	
	//加载个人信息
  $("#personInfo").click(function(){
  	$("#motherBoard").load("personInfo/personInfo.html");
	$.getJSON(
		"http://localhost:8080/userAction/findUser?email="+storage["email"],
		
		function(data){
			updateUserFresh(data.data);
		}
	);
    
  });
  

  
    //修改个人信息
  $("#updateUserInfo").click(function(){

  	var url = "http://localhost:8080/userAction/updateUser";
	var data = {};
	data.id = $("#Pid").val();
	data.username = $("#Pusername").val();
	data.sex = $("#Psex").val();
	data.age = $("#Page").val();
	data.telephone = $("#Ptelephone").val();
	data.email = $("#Pemail").val();
	if(confirm("确定修改个人信息为表单中的信息吗？")){
		submit(data, url, "#updateUserInfo");
   }
	
	
});

//分页显示我的好友列表
$("#myFriendList").click(function(){
	$("#motherBoard").load("friend/friendList.html");
});

});

  //加载我的日程
 $("#schedule").click(function(){
  	window.open("schedule/index.html");
 });

//ajax提交
function submit(data,url,name) {
    $.ajax({
        cache: !1,
        type: "POST",

        url: url,
        dataType: "json",
        data: data,
        async: !0,
        beforeSend: function () {
        	
            $(name).html("提交中..."), $(name).attr("disabled", "disabled");
        },
        success: function (data) {
        	
            
            if(data.code==0 &&name.equals("#updateUserInfo") && data.data != null){
            	alert(data.message);
            	updateUserFresh(data.data);
            }
        },
        error: function(){
        	alert("错误！！");
        },
        complete: function () {
            $(name).html("success"), $(name).removeAttr("disabled");
        }
    });
}
//刷新更新后的用户信息
function updateUserFresh(data){
	$("#Pid").val(data.id);
	$("#Pusername").val(data.username);
	$("#Page").val(data.age);
	$("#Psex").val(data.sex);
	$("#Ptelephone").val(data.telephone);
	$("#Pemail").val(data.email);
}
