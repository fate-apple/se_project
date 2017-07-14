
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "../img/background/bg.png"
	              , "../img/background/se.jpg"
	              
	             ], {duration: 3000, fade: 750});
    
    $("#login").click(function(e) {
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var usertype;
		var radio = document.getElementsByName("usertype"); 
	    for (i=0; i<radio.length; i++) {  
	        if (radio[i].checked) {  
	            usertype = radio[i].value;  
	        }  
	    } 
		
		console.log(username, password,usertype);
		jQuery.ajax({
			url : '/se/manage/news',
				processData : true,
				dataType : "text",
				data : {
					username : username,
					password : password,
					usertype : usertype
				},
				success : function(data) {
					console.log(data);

				}
			});
		
	});
    
    
});
