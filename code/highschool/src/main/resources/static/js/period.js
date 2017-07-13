
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$("#modalTitle").html("添加");
    	$("input[name='periodId']").val(0);
    	$("#modal").modal("show");
	});
    
    $(".update").click(function(e){
    	$("#modalTitle").html("修改");
    	var dataset = e.currentTarget.dataset;
    	console.log(dataset.beginTime,dataset.endTime);
    	$("input[name='weekday']").val(dataset.weekday);
    	//$("input[name='beginTime']").val(dataset.beginTime);
    	//$("input[name='endTime']").val(dataset.endTime);
    	$("input[name='periodId']").val(dataset.id);
    	$("#modal").modal("show");
    });
    
	$(".delete").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : '删除'
				},
				cancel : {
					label : '取消'
				}
			},
			message : '确认要删除吗？',
			callback : function(result) {
				if (result) {
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					console.log(id);
					jQuery.ajax({
						url : '/manage/deletePeriod',
						processData : true,
						dataType : "text",
						data : {
							periodId : id
						},
						success : function(data) {
							console.log(id);
							alert(data);
							location.reload();

						}
					});
				}
			}
		});
	});
    
});
