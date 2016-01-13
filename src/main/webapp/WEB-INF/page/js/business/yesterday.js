$(function () {
    $(".main-content").mask("show");
    var domHtml = ""
    $("#dataDisplay").html("");
    $.ajax({
        url: ajxaUrl + "/statistics/count/yesterday",
        type: "post",
        dataType: ajxaType,
        data: {},
        success: function (data) {
            if (data.status == "success") {
                $(".main-content").mask("hidden");
                var len = data.dataRows.length;
                for (var i = 0; i < len; i++) {
                    domHtml = $('<ul class ="col-md-4"><li><h4 class="pros-title">' + data.dataRows[i].title + '</h4></li><li><h3>' + data.dataRows[i].sum + ' </h3></li><li class="p-chart-title"> 日：' + ajxaDataformat(data.dataRows[i].day) + '</li><li class="p-chart-title"> 周：' + ajxaDataformat(data.dataRows[i].week) + '</li><li class="p-chart-title">月：' + ajxaDataformat(data.dataRows[i].month) + '</li></ul>');
                    $("#dataDisplay").append(domHtml);
                }
                $("#dataDisplay ul:last").css("border", "none");


            } else {
            }
        },
        error: function (xhr) {
        }
    });

    /**/
    function ajxaDataformat(data) {

        if (data < 0) {
            data = (Math.abs(data) * 100).toFixed(2) + "%" + "<span class='glyphicon glyphicon-arrow-down downicon'></span>";
        } else if (data == "-") {
            data = "—";

        } else {

            data = (Math.abs(data) * 100).toFixed(2) + "%" + "<span class='glyphicon glyphicon-arrow-up upicon'></span>";

        }
        return data

    }
});