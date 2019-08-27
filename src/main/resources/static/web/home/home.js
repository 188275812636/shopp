$(function () {


});
function tognmk(obj) {
    var mkid = $(obj).next().val();
    $.ajax({
        url: "/tognmk.do",
        data: {"mkid": mkid},
        type: "post",
        timeout: 3000,
        dataType: "json",
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            toastr.error('链接超时！');
        },
        success: function (responseText, textStatus, XMLHttpRequest) {

        }
    });
}