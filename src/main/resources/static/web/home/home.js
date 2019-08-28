$(function () {


});
function tognmk(obj) {
    $(obj).parent().submit();
}

function togncd(obj) {
    $(obj).next().submit();
}


//admin
function addsp() {
    var spmc=$("#spmc").val();
    var spmk=$("#spmk").val();
    var spfl=$("#spfl").val();
    var spms=$("#spms").val();
    var yxbz=$("#yxbz").val();
    $.ajax({
        url: "/addSp.do",
        data: {"spmc": spmc,"spmk": spmk,"spfl": spfl,"spms": spms,"yxbz": yxbz},
        type: "post",
        timeout: 3000,
        dataType: "json",
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            toastr.error('链接超时！');
        },
        success: function (responseText, textStatus, XMLHttpRequest) {
            toastr.success(responseText.msg);
            $("#closeModel").click();
        }
    });
}
function changespmk() {
    var mkid=$("#spmk").val();
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
            $("#spfl").empty();
            var data = responseText.repData.gncd;
            var spfl=document.getElementById('spfl');
            for (var i = 0; i < data.length; i++) {
                spfl.options.add(new Option(data[i].gn_mc,data[i].id));
            }
        }
    });
}