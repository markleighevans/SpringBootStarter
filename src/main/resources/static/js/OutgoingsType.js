
    $("#myModal").modal('hide');
     function EditHandler()
     {

      EditBtnID= EditHandler.caller.arguments[0].target.id;
      EditTargetOutgoingsTypeID = EditBtnID.slice(3,EditBtnID.length);
      //alert(EditTargetOutgoingsTypeID);
      EditModal (EditTargetOutgoingsTypeID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetOutgoingsTypeID = DeleteBtnID.slice(3,DeleteBtnID.length)
      //alert(DeleteTargetOutgoingsTypeID);
      $.get('/OutgoingsType/DeletebyID/' + DeleteTargetOutgoingsTypeID, function()
      {
         TableRefresh(true);
      }
      )

     }
function EditModal(OutgoingsTypeID) {

         $.getJSON( '/OutgoingsType/FindbyID/' +OutgoingsTypeID , function(OutgoingsTypeData)
                       {
                           $('#m_record-id').val(OutgoingsTypeData.id);
                           $('#m_name').val(OutgoingsTypeData.OutgoingsTypeName);
                           $('#m_indexLinked').attr('checked', OutgoingsTypeData.indexLinked);

                           $("#myModal").modal('show');
                       });
       };



function TableRefresh(resetpaging )
{
       $('#OutgoingsTypeTable').DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}

function fire_ajax_submit(){

        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		outgoingsTypeName : $("#m_name").val(),
        		indexLinked: $("#m_indexLinked").is(':checked')
        	}

        	// DO POST
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/OutgoingsType/add",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(data, status, jqXHR) {
    				//alert("Successfully posted"+ data);
    				TableRefresh(false);
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                      }
    		});


        }

$(document).ready( function () {



	 var table = $('#OutgoingsTypeTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'OutgoingsType/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
		            { "mData": "outgoingsTypeName" },
				    {
                        "data": null,
                       'render': function (data){
                        if (data.indexLinked ) {
                                           return '<input type=\"checkbox\" disabled checked value="' + data.indexLinked + '">';
                          } else {
                                           return '<input type=\"checkbox\" disabled value="' + data.indexLinked + '"/>';
                                       }
                       }}
                     ,
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
     $('#m_record-id').val("");
     $('#m_name').val("");
     $('#m_weighting').val("");
     $('#m_weighting').val("");
     $('#m_indexLinked').attr('checked', true);

     $("#myModal").modal('show');

    }
);


} );
