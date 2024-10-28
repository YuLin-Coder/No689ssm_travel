$(function() {

$("#viewsname").blur(
		function() {
			$("#viewsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#viewsname").after("<span id='viewsname_msg' style='color: red'>景点名称不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>景点区域不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>景点图片不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>门票价格不能为空</span>");
			}
	});

$("#address").blur(
		function() {
			$("#address_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#address").after("<span id='address_msg' style='color: red'>景点地址不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>景点介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var viewsname = $("#viewsname").val();
var cateid = $("#cateid").val();
var image = $("#image").val();
var price = $("#price").val();
var address = $("#address").val();
var contents = $("#contents").val();
$("#viewsname_msg").empty();
$("#cateid_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#address_msg").empty();
$("#contents_msg").empty();
if (viewsname == "" || viewsname == null) {
	$("#viewsname").after("<span id='viewsname_msg' style='color: red'>景点名称不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>景点区域不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>景点图片不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>门票价格不能为空</span>");
	return false;
}
if (address == "" || address == null) {
	$("#address").after("<span id='address_msg' style='color: red'>景点地址不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>景点介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#viewsname_msg").empty();
$("#cateid_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#address_msg").empty();
$("#contents_msg").empty();
});

});
