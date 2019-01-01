
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
      EditTargetIncomeID = EditBtnID.slice(3,EditBtnID.length);
      //alert(EditTargetIncomeID);
      EditModal (EditTargetIncomeID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetIncomeID = DeleteBtnID.slice(3,DeleteBtnID.length)
      //alert(DeleteTargetIncomeID);
      $.get('/Income/DeletebyID/' + DeleteTargetIncomeID, function()
      {
         TableRefresh(true);
      }
      )

     }
function EditModal(IncomeID) {

         $.getJSON( '/Income/FindbyID/' +IncomeID , function(IncomeData)
                       {
                          $('#m_record-id').val(IncomeData.id);
                          $('#m_incomeDescription').val(IncomeData.incomeDescription);
                          $('#m_stressOutcome').val(IncomeData.stressOutcome);
                          $('#m_fromDate').val(convertJSONtoDate(IncomeData.fromDate));
                          $('#m_toDate').val(convertJSONtoDate(IncomeData.toDate));
                          $('#m_amount').val(IncomeData.amount);
                          $('#m_IncomeType').prop('selectedIndex', IncomeData.incomeTypeId);
                           $("#myModal").modal('show');
                       });
       };



function TableRefresh(resetpaging )
{
       $('#IncomeTable').DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}

function fire_ajax_submit(){
        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		incomeTypeId : $("#m_IncomeType").prop('selectedIndex'),
        		incomeDescription:  $("#m_incomeDescription").val(),
        		stressOutcome: $("#m_stressOutcome").val(),
        		fromDate:   convertToJSONDate($("#m_fromDate").val()),
        		toDate:     convertToJSONDate($("#m_toDate").val()),
        		amount:     $("#m_amount").val()

        	}

        	// DO POST
        	console.log(JSON.stringify(formData));
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/Income/add",
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

var IncomeTypeList = [];
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
                dropdown.append('<option value="' + v.id + '">' + v.incomeTypeName + '</option>');
                IncomeTypeList.push( [v.id, v.incomeTypeName, v.stressOutcome]  );
            });
        }
    }
}
// Get the list of Income Types
	 $.ajax({
                 type: "GET",
                 url: "/IncomeType/all",
                 success: function(data)
                 {
                    // console.log(JSON.parse(data));
                     helpers.buildDropdown(
                        data,
                        $('#m_IncomeType'),
                         'Select an option'
                     );
                 }
             });


	 var table = $('#IncomeTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'Income/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
		            {///////////////////// determine th IncomeType Label
		            "data": null,
                          "render": function(data)
                            {
                                var IncomeTypeLabel = '';
                                if ((data.incomeTypeId != null))
                                {
                                   for (var i=0, len=IncomeTypeList.length; i<len; i++)
                                        {
                                            if (data.incomeTypeId == IncomeTypeList[i][0])
                                            {
                                                IncomeTypeLabel = IncomeTypeList[i][1];
                                            }

                                        }
                                    return (data.incomeTypeId + ' ~ '+ IncomeTypeLabel )
                                };

		                    }
		            },
				    { "mData": "incomeDescription" },
				    { "mData": "stressOutcome" },
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


      //// update the stress outcome if the Income Type Changes
	 $('#m_IncomeType').on('change', function() {
      var NewIncomeTypeID = $("#m_IncomeType").prop('selectedIndex');
      console.log('m_IncomeType Change, NewIncomeTypeID=' + NewIncomeTypeID)
      for (var i=0, len=IncomeTypeList.length; i<len; i++)
                                              {
                                                  if (NewIncomeTypeID == IncomeTypeList[i][0])
                                                  {
                                                      StressOutcomeValue = IncomeTypeList[i][2];
                                                  }

                                              }
        $('#m_stressOutcome').val(StressOutcomeValue);

     });


 $('#ModalSave').click( function () {
        fire_ajax_submit();
    } );


$('#btnAdd').click ( function()
    {
    // Clear the existing data then show the modal
     $('#m_record-id').val("");
     $('#m_incomeTypeId').val("");
     $('#m_incomeDescription').val("");
     $('#m_stressOutcome').val("");
     $('#m_fromDate').val("");
     $('#m_toDate').val("");
     $('#m_amount').val("");

     $("#myModal").modal('show');

    }
);


} );
