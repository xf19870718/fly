$(function () {
    $(".main-content").mask("show");
    /*-------------------------------
     初始化日期下拉列表插件
     -------------------------------*/
    $(".select2").select2({
        width: '100%',
        minimumResultsForSearch: -1,
        placeholder: "Select a state"
    });
    /*-------------------------------
     获取昨天的时间
     -------------------------------*/
    var d = new Date();
    d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
    $('#SYear').attr("data-selected", d.getFullYear());
    $('#SMonth').attr("data-selected", d.getMonth() + 1);
    $('#SDay').attr("data-selected", d.getDate());
    /*-------------------------------
     请求昨天的数据报表 placecountgetData
     -------------------------------*/
    var ajxaYear = d.getFullYear();
    var ajxaMonth = d.getMonth() + 1;
    var ajxaDay = d.getDate();
    var ajxapagination = 1;
    placecountgetData();
    function placecountgetData() {
        console.info(ajxaYear, ajxaMonth, ajxaDay, ajxapagination);
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
                    var barData
                    barData = data.dataRows;
                    var barLen = barData.length;

                    $(".Pmsg").remove();
                    $(".zr-element").css("display", "block");
                    /*-------------------------------
                     是否有数据
                     -------------------------------*/
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
    /*-------------------------------
     查询数据
     -------------------------------*/
    $("#queryBtn").on("click", function () {

        ajxaYear = isnbsp(selectYearId.val());
        ajxaMonth = isnbsp(selectMonthId.val());
        ajxaDay = isunll(selectDayId.val());
        function isunll(nullVal) {
            if (nullVal == null) {
                nullVal = 0;
            }
            return nullVal;
        }

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
    /*-------------------------------
     年月日联动插件效果
     -------------------------------*/
    var selectYearId = $('#SYear'); //年所在的控件
    var selectMonthId = $('#SMonth'); //月所在的控件
    var selectDayId = $('#SDay'); //日所在的控件
    var selpagination = $("#pagination");//显示区间所在的控件
    var selYearVal = d.getFullYear();
    var selMonthVal = d.getMonth() + 1;
    var selDayVal = d.getDate();

    /*-----------------------------
     初始化【年，月】下拉列表
     -------------------------------*/
    initYearMonth();
    function initYearMonth() {
        for (var i = (selYearVal - 5); i <= (selYearVal); i++) {
            selectYearId.append('<option value="' + i + '">' + i + '</option>')
        }
        for (var i = 0; i <= 12; i++) {
            if (i == 0) {
                selectMonthId.append('<option value="' + i + '">' + "&nbsp;" + '</option>');
            } else {
                selectMonthId.append('<option value="' + i + '">' + i + '</option>');
            }
        }
        ;
    };
    selectYearId.val(selYearVal).trigger("change");
    selectMonthId.val(selMonthVal).trigger("change");
    initDay();
    /*-----------------------------
     初始化【日】下拉列表
     -------------------------------*/
    function initDay() {
        var selectedYear = selectYearId.val();
        var selectedMonth = selectMonthId.val();
        var selectedDay = selectDayId.val();
        selectDayId.val("0").trigger("change");
        selectDayId.empty();
        if (selectedMonth != 0) {
            var dayvalue;
            if (selectedMonth == 1 || selectedMonth == 3 || selectedMonth == 5 || selectedMonth == 7 || selectedMonth == 8 || selectedMonth == 10 || selectedMonth == 12) {
                dayvalue = 31
            } else if (selectedMonth == 4 || selectedMonth == 6 || selectedMonth == 11 || selectedMonth == 9) {
                dayvalue = 30
            } else if (selectedMonth == 2) {
                if (selectedYear % 4 == 0 && (selectedYear % 4 != 0 || selectedYear % 400 == 0)) { //闰年
                    dayvalue = 29
                } else {
                    dayvalue = 28
                }
            }
            ;
            /*日所在的控件添加数据*/
            for (var i = 0; i <= dayvalue; i++) {
                if (i == 0) {
                    selectDayId.append('<option value="' + i + '">' + "&nbsp" + '</option>');
                } else {
                    selectDayId.append('<option value="' + i + '">' + i + '</option>');
                }
            }
            ;
            selectDayId.val(selectedDay).trigger("change");
        }
        ;
    };
    /*-----------------------------
     初始化【日】下拉列表默认选择值
     -------------------------------*/
    selectDayId.val(selDayVal).trigger("change");
    /*-----------------------------
     【月为空的时候】删除日
     -------------------------------*/
    selectMonthId.live("change", function () {
        initDay();
    })

    /*-------------------------------
     获取区间范围下拉列表值
     -------------------------------*/
    selpagination.change(function () {
        ajxapagination = $(this).val();
    });

});