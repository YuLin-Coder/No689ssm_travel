$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#viewsid").blur(
		function() {
			$("#viewsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#viewsid").after("<span id='viewsid_msg' style='color: red'>景点不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>浏览次数不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var viewsid = $("#viewsid").val();
var num = $("#num").val();
$("#usersid_msg").empty();
$("#viewsid_msg").empty();
$("#num_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (viewsid == "" || viewsid == null) {
	$("#viewsid").after("<span id='viewsid_msg' style='color: red'>景点不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>浏览次数不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#viewsid_msg").empty();
$("#num_msg").empty();
});

});
