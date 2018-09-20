$(document).ready(function(){
	$("#login").click(function(){
		$("#registerform").hide();
		$("#loginform").show();
	});
	$("#register").click(function(){
		$("#loginform").hide();
		$("#registerform").show();
	});
	
//	登陆 注册 忘记密码的ajax
	$("#js-btn").click(function() {
    var data = {} ;
    var name = $("#js-btn").attr('class') ;
    var url = "" ;
    if(name.indexOf("rtn")>0) {
        data.userEmail = $("#js-field__email").val() ;
        data.userPass = $("#js-field__pass").val() ;
        url = "http://localhost:8080/user/login" ;
    } else if(name.indexOf("new")>0) {
        data.userEmail = $("#js-field__email").val() ;
        data.userPass = $("#js-field__pass").val() ;
        data.userRepass = $("#js-field__r-pass").val() ;
        url = "http://localhost:8080/user/register" ;
    } else if(name.indexOf("rst")>0) {
        data.userEmail = $("#js-field__email").val() ;
        url = "http://localhost:8080/user/forget" ;
    }
    submit(data, url) ;
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
	data.age = parseInt($("#Rage").val());
	alert(typeof data.age);
	data.password = $("#Rpassword").val();
	data.telephone = $("#Rtelephone").val();
	data.email = $("#Remail").val();
	submit(data, url);
	
});

function submit(data,url) {
    $.ajax({
        cache: !1,
        type: "POST",
        url: url,
        dataType: "json",
        data: data,
        async: !0,
        beforeSend: function () {
            $("#signup").html("提交中..."), $("#signup").attr("disabled", "disabled")
        },
        success: function (data) {
        	
            var result  = jQuery.parseJSON(data);
            alert(result.message);
            alert("hello world");
            layer.alert(result.message);
        },
        error: function(e){
        	
        	alert(e.status+"错误！");
        },
        complete: function () {
            $("#signup").html("success"), $("#signup").removeAttr("disabled")
        }
    })
}
});


