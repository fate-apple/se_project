
jQuery(document).ready(function() {

    
    $("#add").click(function(e) {
    	$('#modalTitle').html("添加");
    	$('#modal').modal('show');
	});
    
	$(".delete").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : 'Delete'
				},
				cancel : {
					label : 'Cancel'
				}
			},
			message : 'Sure to delete?',
			callback : function(result) {
				if (result) {

					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					console.log(id);

				}
			}
		});
	});
    
});
