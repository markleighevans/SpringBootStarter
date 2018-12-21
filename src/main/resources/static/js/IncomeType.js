
    $("#myModal").modal('hide');
     function EditHandler()
     {

      EditBtnID= EditHandler.caller.arguments[0].target.id;
      EditTargetIncomeTypeID = EditBtnID.slice(3,EditBtnID.length);
      //alert(EditTargetIncomeTypeID);
      EditModal (EditTargetIncomeTypeID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetIncomeTypeID = DeleteBtnID.slice(3,DeleteBtnID.length)
      //alert(DeleteTargetIncomeTypeID);
      $.get('/IncomeType/DeletebyID/' + DeleteTargetIncomeTypeID, function()
      {
         TableRefresh(true);
      }
      )

     }
function EditModal(IncomeTypeID) {

         $.getJSON( '/IncomeType/FindbyID/' +IncomeTypeID , function(IncomeTypeData)
                       {
                           $('#m_record-id').val(IncomeTypeData.id);
                           $('#m_name').val(IncomeTypeData.incomeTypeName);
                            $('#m_stressOutcome').val(IncomeTypeData.stressOutcome);
                           $('#m_weighting').val(IncomeTypeData.incomeTypeWeighting);
                           $('#m_indexLinked').attr('checked', IncomeTypeData.indexLinked);

                           $("#myModal").modal('show');
                       });
       };



function TableRefresh(resetpaging )
{
       $('#IncomeTypeTable').DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}

function fire_ajax_submit(){

        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		incomeTypeName : $("#m_name").val(),
        		stressOutcome : $("#m_stressOutcome").val(),
        		incomeTypeWeighting:  $("#m_weighting").val(),
        		indexLinked: $("#m_indexLinked").is(':checked')
        	}

        	// DO POST
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/IncomeType/add",
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



	 var table = $('#IncomeTypeTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'IncomeType/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
		            { "mData": "incomeTypeName" },
		            { "mData": "stressOutcome" },
				    { "mData": "incomeTypeWeighting" },
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
     $('#m_stressOutcome').val("");
     $('#m_indexLinked').attr('checked', true);

     $("#myModal").modal('show');

    }
);


} );
