$(function () {
    // 下拉列表初始化
    $(".main-content").mask("show");

    MerNameinit();
    var MerNameinitHtml = '<option value="0">请选择</option>';
    var aJxaPost = {
        "aJxaEnterpriseId": "",
        "aJxaunit": "",
        "aJxastartTime": "",
        "aJxaendTime": ""
    }
    /*
     $("#main > div").append(errorHtml);
     $(".zr-element").css("display", "none");
     $(".echarts-tooltip zr-element").remove();*/
    /*初始化商户名称*/
    function MerNameinit() {
        /*var reqType = type;*/
        $.ajax({
            url: ajxaUrl + "/statistics/count/getEnterpriseAll",
            type: "post",
            dataType: ajxaType,
            data: {},
            success: function (data) {
                console.info(data);
                if (data.status == "success") {

                    var merLen = data.dataRows.length;
                    for (var j = 0; j < merLen; j++) {
                        var errorHtml = $("<div class='Pmsg'>" + data.msg + "</div>");
                        MerNameinitHtml = MerNameinitHtml + ('<option value=' + data.dataRows[j].id + '>' + data.dataRows[j].name + '</option>');
                    }
                    ;
                    $("#placeSelect").append(MerNameinitHtml);
                    $("#placeSelect").val(function () {
                        return $(this).data("selected");
                    }).trigger("change");
                    $("#placeSelect").select2().select2('val', $('#placeSelect option:eq(0)').val());
                    $("#placeSelect").select2({
                        width: '100%',
                        minimumResultsForSearch: -1,
                    });
                    $(".main-content").mask("hidden");

                } else {
                    console.log("get query data status err");
                }
            },
            error: function (xhr) {
                console.log("get query data error： " + xhr.status + " " + xhr.statusText);
            }
        });
    };
    $("#placeSelect").on("change", function () {
        $(".errorSel").css("display", "none");
    });
    //查询图表信息
    $("#userqueryBtn").on("click", function () {

        console.info("click");
        $(".inputError").css("display", "none");
        var isPost = true;

        if ($("#placeSelect").val() == 0) {
            $(".errorSel").css("display", "inline-block");
            isPost = false;

        }
        ;

        if ($("#dtp_StrartInput").val() == "") {
            isPost = false;
            $(".errorS").css("display", "inline-block");
        }
        ;

        if ($("#dtp_EndInput").val() == "") {
            isPost = false;
            $(".errorE").css("display", "inline-block");
        }
        ;
        if (isPost) {
            aJxaPost = {
                "aJxaEnterpriseId": $("#placeSelect").select2("val"),
                "aJxaunit": $('input[name="selectType"]:checked').val(),
                "aJxastartTime": $("#dtp_StrartInput").val(),
                "aJxaendTime": $("#dtp_EndInput").val(),
            };
            getData2();
        }
        ;
    })

    function getData2() {
        $(".Pmsg").remove();
        $(".panel").mask("show");
        /*var reqType = type;*/
        console.info("查询用户数据", aJxaPost.aJxaEnterpriseId, aJxaPost.aJxaunit, aJxaPost.aJxastartTime, aJxaPost.aJxaendTime);
        $.ajax({
            url: ajxaUrl + "/statistics/count/user",
            type: "post",
            dataType: ajxaType,
            data: {
                enterpriseId: aJxaPost.aJxaEnterpriseId,
                unit: aJxaPost.aJxaunit,
                startTime: aJxaPost.aJxastartTime,
                endTime: aJxaPost.aJxaendTime
            },
            success: function (data) {

                if (data.status == "success") {
                    var userbarData;
                    userbarData = data.dataRows;
                    var barLen = userbarData.length;
                    $(".panel").mask("hidden");
                    // 没有数据显示文字
                    if (barLen < 1) {
                        var errorHtml = $("<div class='Pmsg'>" + data.msg + "</div>");
                        $("#main2 > div").append(errorHtml);
                        return;
                    } else {
                        $(".zr-element").css("display", "block");
                    }

                    var xData = new Array();
                    var s1Data = new Array();
                    var s2Data = new Array();
                    /*					var s3Data = new Array();*/
                    for (var j = 0; j < barLen; j++) {
                        xData.push(userbarData[j].year);
                        s1Data.push(parseFloat(userbarData[j].aloneSum));
                        s2Data.push(parseFloat(userbarData[j].authSum));

                        /*	s3Data.push(parseFloat(userbarData[j].clickSum));*/

                    }
                    var tempOption = myBarChart02.getOption();
                    tempOption.xAxis[0].data = xData;
                    tempOption.series[0].data = s1Data;
                    tempOption.series[1].data = s2Data;
                    tempOption.title.text = userbarData[0].enterpriseName;
                    /*					tempOption.series[2].data = s3Data;*/
                    myBarChart02.clear();
                    myBarChart02.setOption(tempOption);

                } else {
                    console.log("get query data status err");
                }
            },
            error: function (xhr) {
                console.log("get query data error： " + xhr.status + " " + xhr.statusText);
            }
        });
    };

});