var IncomeTypeList = [];
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
                if (emptyMessage == 'Select Income Type')
                {
                      dropdown.append('<option value="' + v.id + '">' + v.incomeTypeName + '</option>');
                      IncomeTypeList.push( [v.id, v.incomeTypeName, v.stressOutcome]  );
                }
                else
                {
                dropdown.append('<option value="' + v.id + '">' + v.outgoingsTypeName + '</option>');
                                OutgoingsTypeList.push( [v.id, v.outgoingsTypeName]  );

                }
            });
        }
    }
}

function TableRefresh(TargetTable, resetpaging )
{
       $(TargetTable).DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}



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
         TableRefresh('#IncomeTable', true);
      }
      )

     }
function EditModal(IncomeID) {

         $.getJSON( '/Income/FindbyID/' +IncomeID , function(IncomeData)
                       {
                          $('#m_income_record-id').val(IncomeData.id);
                          $('#m_incomeDescription').val(IncomeData.incomeDescription);
                          $('#m_income_stressOutcome').val(IncomeData.stressOutcome);
                          $('#m_income_fromDate').val(convertJSONtoDate(IncomeData.fromDate));
                          $('#m_income_toDate').val(convertJSONtoDate(IncomeData.toDate));
                          $('#m_income_amount').val(IncomeData.amount);
                          $('#m_IncomeType').prop('selectedIndex', IncomeData.incomeTypeId);
                           $("#IncomeModal").modal('show');
                       });
       };




function SaveIncome(){
        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_income_record-id").val(),
        		affordabilityCaseID : $( "#m_affordability_record-id").val(),
        		incomeTypeId : $("#m_IncomeType").prop('selectedIndex'),
        		incomeDescription:  $("#m_incomeDescription").val(),
        		stressOutcome: $("#m_income_stressOutcome").val(),
        		fromDate:   convertToJSONDate($("#m_income_fromDate").val()),
        		toDate:     convertToJSONDate($("#m_income_toDate").val()),
        		amount:     $("#m_income_amount").val()

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
    				TableRefresh('#IncomeTable', false);
    			},
    			error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                        console.log('Post Error '+ xhr.status);
                        console.log('Post Error '+ thrownError);
                      }
    		});


        }

        function SaveOutgoings(){
                	// PREPARE FORM DATA
                	var formData = {
                		id : $("#m_Outgoingsrecord-id").val(),
                		outgoingsTypeId : $("#m_OutgoingsType").prop('selectedIndex'),
                		outgoingsDescription:  $("#m_OutgoingsDescription").val(),
                		affordabilityCaseID : $( "#m_affordability_record-id").val(),
                		fromDate:   convertToJSONDate($("#m_OutgoingsfromDate").val()),
                		toDate:     convertToJSONDate($("#m_OutgoingstoDate").val()),
                		amount:     $("#m_Outgoingsamount").val()

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
            				TableRefresh('#OutgoingsTable', false);
            			},
            			error: function (xhr, ajaxOptions, thrownError) {
                                alert(xhr.status);
                                alert(thrownError);
                                console.log('Post Error '+ xhr.status);
                                console.log('Post Error '+ thrownError);
                              }
            		});


                }

 function CreateDefaultOutgoings(){
                	// PREPARE FORM DATA
                	var formData = {
                		id : $( "#m_affordability_record-id").val(),
                		fromDate:   convertToJSONDate(  $('#m_CaseFromDate').val()),
                		toDate:     convertToJSONDate( $('#m_CaseToDate').val())

                	}

                	// DO POST
                	console.log(JSON.stringify(formData));
                	$.ajax({
            			type : "POST",
            			contentType : "application/json",
            			url : "/Outgoings/addDefault",
            			data : JSON.stringify(formData),
            			dataType : 'json',
            			success : function(data, status, jqXHR) {
            				//alert("Successfully posted"+ data);
            				TableRefresh('#OutgoingsTable', false);
            			},
            			error: function (xhr, ajaxOptions, thrownError) {
                                alert(xhr.status);
                                alert(thrownError);
                                console.log('Post Error '+ xhr.status);
                                console.log('Post Error '+ thrownError);
                              }
            		});


                }



function PopulateCaseData (affordability_record_id)
{
$.getJSON( '/AffordabilityCase/FindbyID/' +affordability_record_id , function(CaseData)
                       {
                          $('#m_affordability_record-id').val(CaseData.id);
                          $('#m_Case_Description').val(CaseData.name);
                          $('#m_Applicant_Count').val(CaseData.applicantCount);
                          $('#m_CaseFromDate').val(convertJSONtoDate(CaseData.fromDate));
                          $('#m_CaseToDate').val(convertJSONtoDate(CaseData.toDate));

                       });
       };

function PopulateIncomeTable(affordability_record_id)
{
// Populate the Income Table List
	 var table = $('#IncomeTable').DataTable({
            ajax: {
                    type : 'GET',
                    url: '/Income/FindbyAffordabilityCaseID/' + affordability_record_id,
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
				    { "mData": "amount",
				    render: $.fn.dataTable.render.number( ',', '.', 2, '£' )
				    },
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


}
function PopulateOutgoingsTable (affordability_record_id)
{
  var table = $('#OutgoingsTable').DataTable({
             ajax: {
                     type : 'GET',
                                           url: 'Outgoings/FindbyAffordabilityCaseID/' + affordability_record_id,
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
 				    { "mData": "amount" ,
 				    render: $.fn.dataTable.render.number( ',', '.', 2, '£' )
 				    },
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
}
function CreateNewCase(){
        	// PREPARE FORM DATA
        	var formData =
        	{
        		id : $("#m_affordability_record-id").val(),
        		name : $("#m_Case_Description").val(),
        		applicantCount : $("#m_Applicant_Count").val()
        	}
        	// DO POST
        	console.log(JSON.stringify(formData));
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/AffordabilityCase/add",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(data, status, jqXHR) {
    				$("#m_affordability_record-id").val(data.id);
    				 sessionStorage.setItem('affordability_record_id', data.id);
    				 $(document).attr("title", 'Affordability Case '+ data.id);
    				 PopulateIncomeTable();
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
    $("#IncomeModal").modal('hide');

var affordability_record_id =  sessionStorage.getItem('affordability_record_id');
$('#m_income_fromDate').datepicker({
                                  changeMonth: true,
                                  changeYear: true
                                });
$('#m_income_toDate').datepicker({
                                changeMonth: true,
                                changeYear: true
                              });
                              $('#m_OutgoingsfromDate').datepicker({
                                                                changeMonth: true,
                                                                changeYear: true
                                                              });
                              $('#m_OutgoingstoDate').datepicker({
                                                              changeMonth: true,
                                                              changeYear: true
                                                            });


// Get the list of Income Types and populate the drop down and client array
	 $.ajax({
                 type: "GET",
                 url: "/IncomeType/all",
                 success: function(data)
                 {
                    // console.log(JSON.parse(data));
                     helpers.buildDropdown(
                        data,
                        $('#m_IncomeType'),
                         'Select Income Type'
                     );
                 }
             });
    $.ajax({
                 type: "GET",
                 url: "/OutgoingsType/all",
                 success: function(data)
                 {
                    // console.log(JSON.parse(data));
                     helpers.buildDropdown(
                        data,
                        $('#m_OutgoingsType'),
                         'Select Outgoings Type'
                     );
                 }
             });

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
        $('#m_income_stressOutcome').val(StressOutcomeValue);

     });
       $('#IncomeDiv').show();
                 $('#OutgoingsDiv').hide();

PopulateCaseData (affordability_record_id);
PopulateOutgoingsTable(affordability_record_id);
PopulateIncomeTable(affordability_record_id);


 $('#btnIncome').click( function () {
        if ($('#IncomeDiv').css('display') == 'none')
        {
            $('#IncomeDiv').show();
            $('#OutgoingsDiv').hide();
        }
    } );



 $('#btnOutgoings').click( function () {
        if ($('#OutgoingsDiv').css('display') == 'none')
        {
            $('#OutgoingsDiv').show();
             $('#IncomeDiv').hide();

        }
        else
        {
             $('#OutgoingsDiv').hide();
        };
    } );

 $('#btnCaseAdd').click( function () {
        CreateNewCase();
    } );

 $('#btnDefaultOutgoings').click( function () {
        CreateDefaultOutgoings();
    } );


$('#IncomeModalSave').click( function () {
        SaveIncome();
    } );

    $('#OutgoingsModalSave').click( function () {
            SaveOutgoings();
        } );


    $('#IncomeModalSetDate').click( function () {
             $('#m_income_fromDate').val($('#m_CaseFromDate').val());
             $('#m_income_toDate').val($('#m_CaseToDate').val());

        } );

  $('#OutgoingsModalSetDate').click( function () {
             $('#m_OutgoingsfromDate').val($('#m_CaseFromDate').val());
             $('#m_OutgoingstoDate').val($('#m_CaseToDate').val());

        } );


$('#btnIncomeAdd').click ( function()
    {
    // Clear the existing data then show the modal
     $('#m_income_record-id').val("");
     $('#m_incomeTypeId').val("");
     $('#m_incomeDescription').val("");
     $('#m_income_stressOutcome').val("");
     $('#m_income_fromDate').val("");
     $('#m_income_toDate').val("");
     $('#m_income_amount').val("");

     $("#IncomeModal").modal('show');

    }
);

$('#btnOutgoingsAdd').click ( function()
    {
    // Clear the existing data then show the modal
     $('#m_Outgoingsrecord-id').val("");
     $('#m_OutgoingsTypeId').val("");
     $('#m_OutgoingsDescription').val("");
     $('#m_OutgoingsfromDate').val("");
     $('#m_OutgoingstoDate').val("");
     $('#m_Outgoingsamount').val("");

     $("#OutgoingsModal").modal('show');

    }
);


} );
