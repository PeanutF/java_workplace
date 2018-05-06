$(document).ready(function () {
    $("#login-btn").click(function () {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        $.ajax({
            url:"/user",
            data:{
                username:name,
                password:pwd
            },
            type:"POST",
            //contentType:"application/json; charset=utf-8",
            success:function (data) {
                alert(data);
            }
        });
        alert("stop");
        //这里的post地址是本地的，记得后面修改
        /*
        $.ajax({
url: actionurl,
type: "POST",
datType: "JSON",
contentType: "application/json"
data: "{'id': " + nodeId +"}",
async: false,
success: function () {}
});
        $.post("http://127.0.0.1:8762/jwt/token",JSON.stringify({
            username:name,
            password:pwd
        }),
            function (data,status) {
                if(status == 200){
                    //创建cookie
                    document.cookie = "token=" + data;
                   alert("token");
                }
                else{
                    alert("login unsuccessfully");
                }
            },"json");*/
    })
})