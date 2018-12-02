
    $("#myModal").modal('hide');
     function EditHandler()
     {

      EditBtnID= EditHandler.caller.arguments[0].target.id;
      EditTargetUserID = EditBtnID.slice(3,EditBtnID.length);
      alert(EditTargetUserID);
      EditModal (EditTargetUserID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetUserID = DeleteBtnID.slice(3,DeleteBtnID.length)
      alert(DeleteTargetUserID);
      $.get('/demo/DeletebyID/' + DeleteTargetUserID, function()
      {
         TableRefresh();
      }
      )

     }
function EditModal(UserID) {

         $.getJSON( '/demo/FindbyID/' +UserID , function(UserData)
                       {
                           $('#m_record-id').val(UserData.id);
                           $('#m_name').val(UserData.name);
                           $('#m_password').val(UserData.password);
                           $('#m_email').val(UserData.email);
                           $("#myModal").modal('show');
                       });
       };



function TableRefresh()
{
 // $('#employeesTable').DataTable().ajax.clear();

         // $('#employeesTable').DataTable().destroy();

       $('#employeesTable').DataTable().ajax.reload();
         //$('#employeesTable').DataTable().draw();
          console.log("table refresh")
}

function fire_ajax_submit(){

        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		name : $("#m_name").val(),
        		password :  $("#m_password").val(),
        		email:  $("#m_email").val()
        	}

        	// DO POST
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/demo/add",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(data, status, jqXHR) {
    				//alert("Successfully posted"+ data);
    				TableRefresh();
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                      }
    		});


        }

$(document).ready( function () {



	 var table = $('#employeesTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'demo/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
		            { "mData": "name" },
				    { "mData": "password" },
				    { "mData": "email" },
				    {   "data": null,
                                   "render": function(data) {

                                       return '<button onclick= EditHandler() class="btn btn-info btn-sm edit_btn" id="'+'edi'+data.id+'">'+
                                       '<span class="glyphicon glyphicon-pencil" aria-hidden="true" id="'+ 'eds'+data.id +'"></span>' +
                                       '</button>'
                                       + '<button onclick= DeleteHandler() class="btn btn-danger btn-sm del_btn" id="'+'del'+data.id+'">' +
                                       '<span class="glyphicon glyphicon-remove" aria-hidden="true" id="'+ 'des'+data.id +'"></span>'
                                       + '</button>';
                                   }}

			]
	 })

 $('#ModalSave').click( function () {
        fire_ajax_submit();
        TableRefresh();

    } );


$('#btnAdd').click ( function()
    {
    $('#m_record-id').hide();
     $("#myModal").prop("readonly", true);

    }
);


} );
