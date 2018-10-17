$(document).ready(function(){
	$("#login").click(function(){
		$("#registerform").hide();
		$("#forgetform").hide();
		$("#loginform").show();
	});
	$("#register").click(function(){
		$("#loginform").hide();
		$("#forgetform").hide();
		$("#registerform").show();
	});
	$("#forget").click(function(){
		$("#loginform").hide();
		$("#registerform").hide();
		$("#forgetform").show();
	});
	


$("#signup").click(function(){
	
	//验证邮箱格式
if($("#Remail").val()=="")
	{
   		alert("邮箱不能为空");
   		return false;
	}
	var Remail=$("#Remail").val();
if(!Remail.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
	{
   		alert("邮箱格式不正确！请重新输入");
   		return false;
	}
	
	var data = {};
	url = "http://localhost:8080/user/register";
	data.username = $("#Rusername").val();
	data.sex = $("#Rsex").val();
	data.age = $("#Rage").val();
	data.password = $("#Rpassword").val();
	data.telephone = $("#Rtelephone").val();
	data.email = $("#Remail").val();
	submit(data, url, "#signup");
	
});

$("#reset").click(function(){
	
	//验证邮箱格式
if($("#Femail").val()=="")
	{
   		alert("邮箱不能为空");
   		return false;
	}
	var Remail=$("#Femail").val();
if(!Remail.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
	{
   		alert("邮箱格式不正确！请重新输入");
   		return false;
	}
	
	var data = {};
	url = "http://localhost:8080/user/forget";
	data.email = $("#Femail").val();
	if(confirm("重置密码后，新密码将发送到邮箱，你确定要重置密码吗？")){
		submit(data, url, "#reset");
	}
});

$("#signin").click(function(){
	
	//验证邮箱格式
if($("#Lemail").val()=="")
	{
   		alert("邮箱不能为空");
   		return false;
	}
	var Remail=$("#Lemail").val();
if(!Remail.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
	{
   		alert("邮箱格式不正确！请重新输入");
   		return false;
	}
	
	var data = {};
	url = "http://localhost:8080/user/login";
	data.email = $("#Lemail").val();
	data.password = $("#Lpassword").val();
	submit(data, url, "#signin");
	
});

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
        	
            if(data.code == 0 && name == "#signin"){
            	alert(data.message+"1");
            	var storage = window.localStorage;
            	storage.setItem("email", $("#Lemail").val());
            	storage.setItem("token", data.token);
            	window.location.href = "pages/index.html";
            	
            }else{
            	alert(data.message);
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
});


