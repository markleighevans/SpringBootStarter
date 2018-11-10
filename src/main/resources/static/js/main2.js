$(document).ready(function () {


    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
       //
    });

  $("#post-button").click(function (event) {
        //stop submit the form, we will post it manually.
       alert("Post button clicked");
       //fire_post_submit();
    });


  $("#ajax-button").click(function (event) {
        //stop submit the form, we will post it manually.
       alert("Ajax button clicked");
       fire_ajax_submit();
    });

    function fire_ajax_submit(){

        	// PREPARE FORM DATA
        	var formData = {
        		name : $("#name").val(),
        		password :  $("#password").val(),
        		email:  $("#email").val()
        	}

        	// DO POST
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/demo/add",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(result) {
    				console.log("AJAX Success");

    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                      }
    		});


        }


});
