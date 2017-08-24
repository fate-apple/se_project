
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "../img/background/bg.png"
	              , "../img/background/se.jpg"
	              
	             ], {duration: 3000, fade: 750});
    
    $("#login").click(function(e) {
    	var username;
    	var password;
		var usertype;
		var radio = document.getElementsByName("usertype"); 
	    for (i=0; i<radio.length; i++) {  
	        if (radio[i].checked) {  
	            usertype = radio[i].value;  
	        }  
	    } 
		if (usertype=="person"){
			username = $("input[name='username']").val();
		}
		if (usertype=="class"){
			var grade = document.getElementById("selectGrade").value;
			var classNo = document.getElementById("grade"+grade).value;
			username = "g"+grade+"c"+classNo;
		}
		password = $("input[name='password']").val();
		console.log(username, password,usertype);
        $.ajax({
            type: "post",
            url: "/auth",
            contentType: "application/json",
            data: JSON.stringify({
                "username": username,
                "password": password
            }),
            dataType: 'json',
            success: function (resp) {
                //alert(resp.token);
                if (1) {
                    //将token存在本地存储，然后跳转到主页面
                    localStorage.setItem('token', resp.token);
                    top.location.href = "/base/news";
                }
            }
        });
		
	});
    

    
});

function radioShow(){
	var radio = document.getElementsByName("usertype");
	if(radio[1].checked){
		document.getElementById("normal").style.display="none";
		document.getElementById("selectClass").style.display="block";
	}
	if(radio[0].checked){
		document.getElementById("selectClass").style.display="none";
		document.getElementById("normal").style.display="block";
	}
};

function classChange(){
    var grade = $("#selectGrade").val();
    for(i=1;i<=3;i++){
    	document.getElementById("grade"+i).style.display="none";
    }
    document.getElementById("grade"+grade).style.display="block";
    
};
