function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url: "/loginIn.c",
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