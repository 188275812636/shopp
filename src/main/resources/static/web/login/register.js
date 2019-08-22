function register() {
    var username = $("username").val();
    var password = $("password").val();
    var usertype = $("usertype").val();
    var truename = $("truename").val();
    $.ajax({
        url: "/register.do",
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
    window.close();
}