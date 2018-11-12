$(document).ready(function () {


    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
       //
    });

  $("#clear-button").click(function (event) {
        //Clear form content.
      alert("clear button pressed");
       $("#name").val("");
        $("#password").val("");
        $("#email").val("");
    });


  $("#ajax-button").click(function (event) {
        //stop submit the form, we will post it manually.
       //alert("Ajax button clicked");
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
    			success : function(data, status, jqXHR) {
    			   $("#header ul").append('<li>'+ JSON.stringify(data) + '</li>');
    				//alert("Successfully posted"+ data);
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                      }
    		});


        }


});
