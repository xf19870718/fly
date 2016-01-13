// 基于准备好的dom，初始化echarts图表
myBarChart02 = echarts.init(document.getElementById('main2'));
var option = {
    title: {
        text: '场所数据量比例统计',
        subtext: '',
        x: 'left'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        orient: 'horizontal',
        x: 'center',
        data: ['独立用户数', '认证成功人数']
    },
    toolbox: {
        show: true,
        feature: {
            /*mark: {
             show: true
             },
             dataView: {
             show: true,
             readOnly: false
             },
             magicType: {
             show: true,
             type: ['line', 'bar']
             },
             restore: {
             show: true
             },*/
            saveAsImage: {
                show: true
            }
        }
    },
    calculable: true,
    dataZoom: {
        show: true,
        realtime: true,
        start: 0,
        end: 50
    },
    xAxis: [{
        type: 'category',
        data: ['-'],
        axisLabel: {
            rotate: 1
        }
    }],

    yAxis: [{
        type: 'value'
    }],
    series: [{
        name: '独立用户数',
        type: 'bar',
        data: ['-'],
        markPoint: {
            data: [{
                type: 'max',
                name: '最大值'
            }, {
                type: 'min',
                name: '最小值'
            }]
        },

    }, {
        name: '认证成功人数',
        type: 'bar',
        data: ['-'],
        markPoint: {
            data: [{
                type: 'max',
                name: '最大值'
            }, {
                type: 'min',
                name: '最小值'
            }]
        },

    }]
};

// 为echarts对象加载数据 
myBarChart02.setOption(option);
$(".zr-element").css("display", "none");