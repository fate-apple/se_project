jQuery(document).ready(function() {

	$(".select").click(function(e) {
		var dataset = e.currentTarget.dataset;
		if(dataset.number>=dataset.capability){
			alert("人数已满！")
		}
		else{
			bootbox.confirm({
				buttons : {
					confirm : {
						label : '选择'
					},
					cancel : {
						label : '取消'
					}
				},
				message:"确认要选择吗？",
				callback : function(result) {
					if (result) {
						var dataset = e.currentTarget.dataset;
						var id = dataset.id;
						console.log(id);
						jQuery.ajax({
							url : '/manage/electivecourse/select',
							processData : true,
							dataType : "text",
							data : {
								courseId : id
							},
							success : function(data) {
								console.log(id);
								bootbox.alert({
									message :"选择成功",
									callback : function() {
										location.reload();
									}
								});

							},
							error:function(data){
								bootbox.alert({message:"选择失败"});
							}
						});
					}
				}
			});
			//end bootbox
		}
	});
    
});
