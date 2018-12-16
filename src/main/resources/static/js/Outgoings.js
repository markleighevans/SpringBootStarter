
    $("#myModal").modal('hide');

    function convertToJSONDate(strDate){
    console.log(strDate)
      var dt = new Date(strDate);
          return  dt.toJSON();
    }
      function convertJSONtoDate(strJSONDate){
        console.log(strJSONDate)
          var dt = new Date(strJSONDate);
          console.log(dt.toLocaleDateString());
              return  dt.toLocaleDateString();
        }



     function EditHandler()
     {

      EditBtnID= EditHandler.caller.arguments[0].target.id;
      EditTargetOutgoingsID = EditBtnID.slice(3,EditBtnID.length);
      //alert(EditTargetOutgoingsID);
      EditModal (EditTargetOutgoingsID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetOutgoingsID = DeleteBtnID.slice(3,DeleteBtnID.length)
      //alert(DeleteTargetOutgoingsID);
      $.get('/Outgoings/DeletebyID/' + DeleteTargetOutgoingsID, function()
      {
         TableRefresh(true);
      }
      )

     }
function EditModal(OutgoingsID) {

         $.getJSON( '/Outgoings/FindbyID/' +OutgoingsID , function(OutgoingsData)
                       {
                          $('#m_record-id').val(OutgoingsData.id);
                          $('#m_OutgoingsDescription').val(OutgoingsData.outgoingsDescription);
                          $('#m_fromDate').val(convertJSONtoDate(OutgoingsData.fromDate));
                          $('#m_toDate').val(convertJSONtoDate(OutgoingsData.toDate));
                          $('#m_amount').val(OutgoingsData.amount);
                          $('#m_OutgoingsType').prop('selectedIndex', OutgoingsData.outgoingsTypeId);
                           $("#myModal").modal('show');
                       });
       };



function TableRefresh(resetpaging )
{
       $('#OutgoingsTable').DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}

function fire_ajax_submit(){
        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		outgoingsTypeId : $("#m_OutgoingsType").prop('selectedIndex'),
        		outgoingsDescription:  $("#m_OutgoingsDescription").val(),
        		fromDate:   convertToJSONDate($("#m_fromDate").val()),
        		toDate:     convertToJSONDate($("#m_toDate").val()),
        		amount:     $("#m_amount").val()

        	}

        	// DO POST
        	console.log(JSON.stringify(formData));
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/Outgoings/add",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(data, status, jqXHR) {
    				//alert("Successfully posted"+ data);
    				TableRefresh(false);
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                        console.log('Post Error '+ xhr.status);
                        console.log('Post Error '+ thrownError);
                      }
    		});


        }

$(document).ready( function () {

$('#m_fromDate').datepicker({
                                  changeMonth: true,
                                  changeYear: true
                                });
$('#m_toDate').datepicker({
                                changeMonth: true,
                                changeYear: true
                              });

var OutgoingsTypeList = [];
var helpers =
{
    buildDropdown: function(result, dropdown, emptyMessage)
    {
        // Remove current options
        dropdown.html('');
        // Add the empty option with the empty message
        dropdown.append('<option value="">' + emptyMessage + '</option>');
        // Check result isnt empty
        if(result != '')
        {
            // Loop through each of the results and append the option to the dropdown
            $.each(result, function(k, v) {
                dropdown.append('<option value="' + v.id + '">' + v.outgoingsTypeName + '</option>');
                //console.log(v.id + "~" + v.outgoingsTypeName)
                OutgoingsTypeList.push( [v.id, v.outgoingsTypeName]  );
            });
        }
    }
}
// Get the list of Outgoings Types
	 $.ajax({
                 type: "GET",
                 url: "/OutgoingsType/all",
                 success: function(data)
                 {
                    // console.log(JSON.parse(data));
                     helpers.buildDropdown(
                        data,
                        $('#m_OutgoingsType'),
                         'Select an option'
                     );
                 }
             });


	 var table = $('#OutgoingsTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'Outgoings/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
		            {///////////////////// determine th OutgoingsType Label
		            "data": null,
                          "render": function(data)
                            {
                                var OutgoingsTypeLabel = '';
                                if ((data.outgoingsTypeId != null))
                                {
                                   for (var i=0, len=OutgoingsTypeList.length; i<len; i++)
                                        {
                                            if (data.outgoingsTypeId == OutgoingsTypeList[i][0])
                                            {
                                                OutgoingsTypeLabel = OutgoingsTypeList[i][1];
                                            }

                                        }
                                    return (data.outgoingsTypeId + ' ~ '+ OutgoingsTypeLabel )
                                };

		                    }
		            },
				    { "mData": "outgoingsDescription" },
				    { "data": null,
                      				        "render": function(data) {
                      				                 var LongDate = new Date(data.fromDate);
                      				                 return LongDate.toLocaleDateString();
                      				                 } },
				    {  "data": null,
				        "render": function(data) {
				                 var LongDate = new Date(data.toDate);
				                 return LongDate.toLocaleDateString();
				                 }
				    },
				    { "mData": "amount" },
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
    } );


$('#btnAdd').click ( function()
    {
    // Clear the existing data then show the modal
     $('#m_record-id').val("");
     $('#m_OutgoingsTypeId').val("");
     $('#m_OutgoingsDescription').val("");
     $('#m_fromDate').val("");
     $('#m_toDate').val("");
     $('#m_amount').val("");

     $("#myModal").modal('show');

    }
);


} );
