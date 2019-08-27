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
            toastr.error('链接超时！');
        },
        success: function (responseText, textStatus, XMLHttpRequest) {
            if(responseText.repData.data.usertypt=="-1"){
                toastr.info('用户名或密码不正确！');
                return;
            }
            location.reload();
        }
    });
}
function open_register() {
    location.href="register.do";
}