/**
 * 
 */
/**
 * 
 */

define([ 'app' ], function(app) {
 
	app.controller('ysAnalysisCtrl', [ '$scope', function($scope) {
		debugger 
		$scope.title = "Chart Test"
		require([ 'chartJs/dist/echarts' ],function(echarts){//按需加载
			// --- 折柱 ---
			var myChart = echarts.init(document.getElementById('mainChart'));
			// 指定图表的配置项和数据
			var option = {
				title : {
					text : 'ECharts 入门示例'
				},
				tooltip : {},
				legend : {
					data : [ '销量' ]
				},
				xAxis : {
					data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
				},
				yAxis : {},
				series : [ {
					name : '销量',
					type : 'bar',
					data : [ 5, 20, 36, 10, 10, 20 ]
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		});
		
	} ]);

});