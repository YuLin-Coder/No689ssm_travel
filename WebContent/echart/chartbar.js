$(function() {
	$('#sub').click(function(){
		var loc = $("input[name='basepath']").val();
		var start = $("input[name='start']").val();
		var end = $("input[name='end']").val();
		var id = $("#viewsid").val();
		var url = loc + "chart/chartbar.action?start=" + start + "&end=" + end + "&id=" + id;
		if (start == '' || start == null) {
			alert('请选择开始日期');
			return;
		}
		if (end == '' || end == null) {
			alert('请选择结束日期');
			return;
		}
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			success : function(json) {
				var name = json.names.replace("[", "").replace("]", "").split(",");
				var val = json.count.replace("[", "").replace("]", "").split(",");
				var strName = [];
				var strCount = [];
				for (var i = 0; i < name.length; i++) {
					strName.push({
						"value" : name[i]
					});
				}
				for (var i = 0; i < val.length; i++) {
					strCount.push({
						"name" : name[i],
						"value" : val[i]
					});
				}
				var option = {
					title : {
						text : '门票销售情况统计',
						left : 'center'
					},
					xAxis : {
						type : 'category',
						data : strName
					},
					yAxis : {
						type : 'value'
					},
					series : [ {
						data : strCount,
						type : 'bar'
					} ]
				};
				// 初始化echarts实例
				var myChart = echarts.init(document.getElementById('chartmain'));
				// 使用制定的配置项和数据显示图表
				myChart.setOption(option);
			},
			error : function() {
				alert("ajax请求发生错误3");
			}
		});
		
	});
})