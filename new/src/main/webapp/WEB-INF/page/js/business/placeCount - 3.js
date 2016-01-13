$(function () {
    $(".main-content").mask("show");
    $("#SYear").select2({
        width: '100%',
        minimumResultsForSearch: -1,
        placeholder: "Select a state"
    });
    $("#SMonth").select2({
        width: '100%',
        minimumResultsForSearch: -1
    });
    $("#SDay").select2({
        width: '100%',
        minimumResultsForSearch: -1
    });
    $("#pagination").select2({
        width: '100%',
        minimumResultsForSearch: -1
    })
    var d = new Date();
    d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
    $('#SYear').attr("data-selected", d.getFullYear());
    $('#SMonth').attr("data-selected", d.getMonth() + 1);
    $('#SDay').attr("data-selected", d.getDate());
    /*记录年月日选择*/
    var ajxaYear = d.getFullYear();
    var ajxaMonth = d.getMonth() + 1;
    var ajxaDay = d.getDate();
    var ajxapagination = 1;
    /*运行下拉列表插件*/
    placecountgetData();

    function placecountgetData() {
        console.info(ajxaYear, ajxaMonth, ajxaDay, ajxapagination);
        /*var reqType = type;*/
        $.ajax({
            url: ajxaUrl + "/statistics/count/enterprise",
            type: "post",
            dataType: ajxaType,
            data: {
                "year": ajxaYear,
                "month": ajxaMonth,
                "day": ajxaDay,
                "pagination": ajxapagination,
            },
            success: function (data) {
                $(".main-content").mask("hidden");
                console.info(data);
                if (data.status == "success") {
                    var tableData, barData, pieData;
                    barData = data.dataRows;
                    var barLen = barData.length;
                    $(".Pmsg").remove();
                    $(".zr-element").css("display", "block");
                    if (barLen < 1) {
                        var errorHtml = $("<div class='Pmsg'>" + data.msg + "</div>");
                        $("#main > div").append(errorHtml);
                        $(".zr-element").css("display", "none");
                        $(".echarts-tooltip zr-element").remove();
                        return;
                    }

                    var xData = new Array();
                    var s1Data = new Array();
                    var s2Data = new Array();
                    var s3Data = new Array();
                    for (var j = 0; j < barLen; j++) {
                        xData.push(barData[j].enterpriseName);
                        s1Data.push(parseFloat(barData[j].authSum));
                        s2Data.push(parseFloat(barData[j].showSum));
                        s3Data.push(parseFloat(barData[j].clickSum));
                    }
                    var tempOption = myBarChart.getOption();
                    tempOption.xAxis[0].data = xData;
                    tempOption.series[0].data = s1Data;
                    tempOption.series[1].data = s2Data;
                    tempOption.series[2].data = s3Data;
                    myBarChart.clear();
                    myBarChart.setOption(tempOption);

                } else {
                    console.log("get query data status err");
                }
            },
            error: function (xhr) {
                console.log("get query data error： " + xhr.status + " " + xhr.statusText);
            }
        });
    };
    /*查询数据*/
    $("#queryBtn").on("click", function () {

        ajxaYear = isnbsp($("#select2-chosen-1").html());
        ajxaMonth = isnbsp($("#select2-chosen-2").html());
        ajxaDay = isnbsp($("#select2-chosen-3").html());
        function isnbsp(val) {
            if (val == "&nbsp;") {
                val = 0;

            }
            return val;
        };
        $(".Pmsg").remove();
        $(".panel").mask("show");
        placecountgetData();
    });


    //年月日联动效果
    var yearid = $('#SYear'); //年所在的控件
    var monthid = $('#SMonth'); //月所在的控件
    var dayid = $('#SDay'); //天所在的控件
    var selpagination = $("#pagination");
    var myDate = new Date();
    var year = myDate.getFullYear();
    selpagination.change(function () {
        ajxapagination = $(this).val();
    })
    for (var i = (year - 5); i <= (year); i++) {
        yearid.append('<option value="' + i + '">' + i + '</option>')
    }
    // 初始化年份
    inityearid();
    yearid.click(function () {
        monthid.html('');
        setSelected();
        monthid.append('<option value="' + 0 + '">' + "&nbsp;" + '</option>');
        for (var i = 1; i <= 12; i++) {
            monthid.append('<option value="' + i + '">' + i + '</option>');
        }
        resterdate();
        $("#SDay").html('');
    });
    monthid.click(function () {
        var yearValue = yearid.val()
        var monthValue = parseInt(monthid.val())
        var dayvalue;
        ajxaMonth = monthValue;
        if (monthValue == 0) {
            $("#SDay").val("0").trigger("change");

        } else {
            if (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12) {
                dayvalue = 31
            } else if (monthValue == 4 || monthValue == 6 || monthValue == 11 || monthValue == 9) {
                dayvalue = 30
            } else if (monthValue == 2) {

                if (yearValue % 4 == 0 && (yearValue % 4 != 0 || yearValue % 400 == 0)) { //闰年
                    dayvalue = 29
                } else {
                    dayvalue = 28
                }
            }
            ;
            for (var i = 0; i <= dayvalue; i++) {
                if (i == 0) {
                    dayid.append('<option value="' + i + '">' + "&nbsp;" + '</option>');
                } else {
                    dayid.append('<option value="' + i + "a" + '">' + i + '</option>');
                }
            }
            ;
        }
    });
    /*初始化年*/
    function inityearid() {
        monthid.html('');
        for (var i = 0; i <= 12; i++) {
            if (i == 0) {
                monthid.append('<option value="' + i + '">' + "&nbsp;" + '</option>');
            } else {
                monthid.append('<option value="' + i + '">' + i + '</option>');
            }
        }
        setSelected();
        initmonthid();
    };
    // 初始化日
    function initmonthid() {
        var yearValue = yearid.val()
        var monthValue = parseInt(monthid.val());
        ajxaMonth = monthValue;
        var dayvalue;
        if (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12) {
            dayvalue = 31
        } else if (monthValue == 4 || monthValue == 6 || monthValue == 11 || monthValue == 9) {
            dayvalue = 30
        } else if (monthValue == 2) {

            if (yearValue % 4 == 0 && (yearValue % 4 != 0 || yearValue % 400 == 0)) { //闰年
                dayvalue = 29
            } else {
                dayvalue = 28
            }
        }
        ;
        setSelected();
        for (var i = 0; i <= dayvalue; i++) {
            if (i == 0) {
                dayid.append('<option value="' + i + '">' + "&nbsp" + '</option>');
            } else {
                dayid.append('<option value="' + i + '">' + i + '</option>');
            }
        }
        ;
        setSelected();
    };

    function setSelected() {
        $(".select2").val(function () {
            return $(this).data("selected");
        }).trigger("change");
    }


    // 初始化下拉列表
    function resterdate() {
        $("#SMonth").val("0").trigger("change"); //当年变化的时候设置默认值
        $("#SDay").val("0").trigger("change");


    };

});