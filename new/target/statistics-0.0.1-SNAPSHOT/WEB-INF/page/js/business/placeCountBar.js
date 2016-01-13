// 基于准备好的dom，初始化echarts图表
myBarChart = echarts.init(document.getElementById('main'));
var option = {
    title: {
        text: '场所数据量比例统计',
        subtext: '',
        x: 'left',

    },

    tooltip: {

        trigger: 'axis'
    },
    legend: {
        orient: 'horizontal',
        x: 'center',
        data: ['认证通过人数', '广告展示量', '广告点击量']
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
        name: '认证通过人数',
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
        }

    }, {
        name: '广告展示量',
        type: 'bar',
        data: ['-'],
        markPoint: {
            data: [{
                name: '年最高',
                value: 100,
                xAxis: 8,
                yAxis: 100,
                symbolSize: 18
            }, {
                name: '年最低',
                value: 33,
                xAxis: 3,
                yAxis: 33
            }]
        }

    }, {
        name: '广告点击量',
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
        }

    }]
};

// 为echarts对象加载数据 
myBarChart.setOption(option);