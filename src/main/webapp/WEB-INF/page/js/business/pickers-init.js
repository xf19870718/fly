$(function () {
    var dtpStartOpaciton = {
        "format": "yyyy-mm-dd",
        "minView": "2",
        "startDate": "2010-01-01",
    };
    var dtpEndOpaciton = {
        "format": "yyyy-mm-dd",
        "minView": "2",
        "startDate": "2010-01-01",
        "endDate": ""
    };
    var dtpData = {
        "dtp_StartInputVal": "",
        "dtp_EndInputVal": "",
        "returnDate": "",
        "AddDayCount": 31
    };
    /*初始化时间选择器*/
    setDtpOpciton(0);
    /*单选按钮组选择结果判断年月日相关选项数据*/
    $("input:radio[name='selectType']").change(function () {
        var type = $(this).val();
        if (type == "3") { /*当选择年的*/
            dtpStartOpaciton.minView = 5;
            dtpStartOpaciton.format = "yyyy";
            dtpEndOpaciton.minView = 5;
            dtpEndOpaciton.format = "yyyy";
            dtpData.AddDayCount = 4 * 365;


        } else if (type == "2") { /*当选择月*/
            dtpStartOpaciton.minView = 3;
            dtpStartOpaciton.format = "yyyy-mm";
            dtpEndOpaciton.minView = 3;
            dtpEndOpaciton.format = "yyyy-mm";
            dtpData.AddDayCount = 365;
        } else if (type == "1") { /*当选择日*/
            dtpStartOpaciton.minView = 2;
            dtpStartOpaciton.format = "yyyy-mm-dd";
            dtpEndOpaciton.minView = 2;
            dtpEndOpaciton.format = "yyyy-mm-dd";
            dtpData.AddDayCount = 31;
        }
        ;
        /*根据选择结果更新日期选择器模式*/
        setDtpOpciton(0);
        $("#dtp_StrartInput").val("");
        $("#dtp_EndInput").val("");
        $("#form_datetime-start input").val("");
        $("#form_datetime-end input").val("");
    });
    /*当开始时间选择框发生变化的时候*/
    $("#form_datetime-start").on("changeDate", function () {
        dtpData.dtp_StartInputVal = $("#dtp_StrartInput").val();
        dtpEndOpaciton.startDate = dtpData.dtp_StartInputVal;
        addDate(dtpData.dtp_StartInputVal, dtpData.AddDayCount);
        $(".error1").css("display", "none");
        $(".errorS").css("display", "none");
        dtpEndOpaciton.endDate = dtpData.returnDate;
        console.info(dtpData.returnDate);
        setDtpOpciton(2);

    });
    /*当结束时间选择框发生变化的时候*/
    $("#form_datetime-end").on("changeDate", function () {
        dtpData.dtp_EndInputVal = $("#dtp_EndInput").val();
        dtpStartOpaciton.endDate = dtpData.dtp_EndInputVal;
        console.info(dtpData.returnDate);
        addDate(dtpData.dtp_EndInputVal, -dtpData.AddDayCount);
        dtpStartOpaciton.startDate = dtpData.returnDate;
        setDtpOpciton(1);
        $(".error2").css("display", "none");
        $(".errorE").css("display", "none");
    });
    // 添加减少结束日期
    function addDate(thisDate, AddDayCount) {
        var str = thisDate;
        // 转换日期格式
        str = str.replace(/-/g, '/'); // "2010/08/01";
        // 创建日期对象
        var date = new Date(str);
        // 加一天
        date.setDate(date.getDate() + AddDayCount);
        dtpData.returnDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
    }

    /*动态设置选择器属性参数*/
    function setDtpOpciton(setval) {
        /*清除历史参数*/
        if (setval == 1) {
            /*开始日期*/
            $('#form_datetime-start').datetimepicker('remove');
            $("#form_datetime-start").datetimepicker({
                language: 'zh-CN',
                autoclose: false,
                weekStart: 1,
                autoclose: 1,

                startView: 4,
                minView: dtpStartOpaciton.minView,
                format: dtpStartOpaciton.format,
                linkFormat: "yyyy-mm-dd",
                maxView: 3,
                startDate: dtpStartOpaciton.startDate,
                endDate: dtpStartOpaciton.endDate,
                forceParse: false,
                minuteStep: 10
            });
        } else if (setval == 2) {
            /*结束日期*/
            console.info(dtpEndOpaciton.endDate);
            $('#form_datetime-end').datetimepicker('remove');
            $("#form_datetime-end").datetimepicker({
                language: 'zh-CN',
                autoclose: true,
                weekStart: 1,
                autoclose: 1,

                startView: 4,
                minView: dtpEndOpaciton.minView,
                format: dtpEndOpaciton.format,
                linkFormat: "yyyy-mm-dd",
                maxView: 3,
                startDate: dtpEndOpaciton.startDate,
                endDate: dtpEndOpaciton.endDate,
                forceParse: false,
                minuteStep: 10
            });

        } else {

            /*开始日期*/
            $('#form_datetime-start').datetimepicker('remove');
            $("#form_datetime-start").datetimepicker({
                language: 'zh-CN',
                autoclose: true,
                weekStart: 1,
                autoclose: 1,

                startView: 4,
                minView: dtpStartOpaciton.minView,
                format: dtpStartOpaciton.format,
                linkFormat: "yyyy-mm-dd",
                maxView: 3,
                startDate: dtpStartOpaciton.startDate,
                endDate: dtpStartOpaciton.endDate,
                forceParse: false,
                minuteStep: 10
            });
            /*结束日期*/
            $('#form_datetime-end').datetimepicker('remove');
            $("#form_datetime-end").datetimepicker({
                language: 'zh-CN',
                autoclose: true,
                weekStart: 1,
                autoclose: 1,

                startView: 4,
                minView: dtpEndOpaciton.minView,
                format: dtpEndOpaciton.format,
                linkFormat: "yyyy-mm-dd",
                maxView: 3,
                startDate: dtpEndOpaciton.startDate,
                endDate: dtpEndOpaciton.endDate,
                forceParse: false,
                minuteStep: 10
            });
        }
    };
})