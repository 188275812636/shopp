$(function () {

});
function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    var usertype = $("#usertype").val();
    if(username==""||password==""){
        //toastr.success('提交数据成功');
        //toastr.error('Error');
        //toastr.warning('只能选择一行进行编辑');
        //toastr.info('info');
        toastr.warning('请输入用户名和密码');
        return;
    }
    $.ajax({
        url: "/loginIn.do",
        data: {"username": username,"password":password,"usertype":usertype},
        type: "post",
        timeout: 3000,
        dataType: "json",
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            location.reload();
        },
        success: function (responseText, textStatus, XMLHttpRequest) {
            location.reload();
        }
    });
}
function open_register() {
    location.href="register.do";
}