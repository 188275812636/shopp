function register() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("password1").value;
    var usertype = document.getElementById("usertype").value;
    var truename = document.getElementById("truename").value;
    if(username==""||password==""||password1==""||usertype==""){
        toastr.warning('请填写基本信息！');
        return;
    }
    if(password!=password1){
        toastr.warning('两次密码不一致！');
    }
    $.ajax({
        url: "/to_register.do",
        data: {"username": username,"password":password,"usertype":usertype,"truename":truename},
        type: "post",
        timeout: 3000,
        dataType: "json",
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        },
        success: function (responseText, textStatus, XMLHttpRequest) {

        }
    });
    toastr.success('注册成功！3秒后跳转登录页面...');
    setTimeout(function(){ location.href="login.do"; },3000);

}