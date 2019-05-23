$(document).ready(function() {	
	$('.btn').click(function(){
	if($("#id").val() <8){
		$.ajax({	
	        url: "http://localhost:8080/task/"+ $("#id").val() 
	    }).then(function(data) {
	    	$(".title").html("主题"+data.id);
	    	$(".context").html(data.context);
	    	
	    	console.log(data)
	    });
	}
		else{
			alert("目前只能查询8以下的主题呢!");
		}
	});    
});
