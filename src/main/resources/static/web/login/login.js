function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    if(username==""||password==""){
        //1  toastr.success('提交数据成功');
        //2  toastr.error('Error');
        //3  toastr.warning('只能选择一行进行编辑');
        //4  toastr.info('info');
        toastr.warning('请输入用户名和密码');
    }
    $.ajax({
        url: "/loginIn.do",
        data: {"username": username,"password":password},
        type: "post",
        timeout: 3000,
        dataType: "json",
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        },
        success: function (responseText, textStatus, XMLHttpRequest) {

        }
    });
}