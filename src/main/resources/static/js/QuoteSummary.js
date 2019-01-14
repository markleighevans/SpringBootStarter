
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
      EditTargetQuoteSummaryID = EditBtnID.slice(3,EditBtnID.length);
      //alert(EditTargetQuoteSummaryID);
      EditModal (EditTargetQuoteSummaryID);
     }

     function DeleteHandler()
     {
      DeleteBtnID= DeleteHandler.caller.arguments[0].target.id;
      DeleteTargetQuoteSummaryID = DeleteBtnID.slice(3,DeleteBtnID.length)
      //alert(DeleteTargetQuoteSummaryID);
      $.get('/QuoteSummary/DeletebyID/' + DeleteTargetQuoteSummaryID, function()
      {
         TableRefresh(true);
      }
      )

     }

     function DIPHandler()
          {
           DIPBtnID= DIPHandler.caller.arguments[0].target.id;
           DIPTargetQuoteSummaryID = DIPBtnID.slice(3,DIPBtnID.length)

           var formData =
                   	{
                   		id : DIPTargetQuoteSummaryID
                   	}
                   	// DO POST
                   	console.log(JSON.stringify(formData));
                   	$.ajax({
               			type : "POST",
               			contentType : "application/json",
               			url : " /AffordabilityCase/CreatefromQuote/",
               			data : JSON.stringify(formData),
               			dataType : 'json',
               			success : function(data, status, jqXHR) {
               				 $(document).attr("title", 'Affordability Case '+ data.id);
               				 sessionStorage.setItem('affordability_record_id', data.id);
               				 window.location.assign("/AffordabilityCase")
               			},
               			error: function (xhr, ajaxOptions, thrownError) {
                                   alert(xhr.status);
                                   alert(thrownError);
                                   console.log('Post Error '+ xhr.status);
                                   console.log('Post Error '+ thrownError);
                                 }
               		});


          }
function EditModal(QuoteSummaryID) {

         $.getJSON( '/QuoteSummary/FindbyID/' +QuoteSummaryID , function(QuoteSummaryData)
                       {
                          $('#m_record-id').val(QuoteSummaryData.id);
                          $('#m_ProductDescription').val(QuoteSummaryData.productDescription);
                          $('#m_ApplicantCount').val(QuoteSummaryData.applicantCount);
                          $('#m_Applicant1Name').val(QuoteSummaryData.applicant1Name);
                          $('#m_Applicant2Name').val(QuoteSummaryData.applicant2Name);
                          $('#m_fromDate').val(convertJSONtoDate(QuoteSummaryData.fromDate));
                          $('#m_toDate').val(convertJSONtoDate(QuoteSummaryData.toDate));
                          $('#m_Amount').val(QuoteSummaryData.amount);
                           $("#myModal").modal('show');
                       });
       };



function TableRefresh(resetpaging )
{
       $('#QuoteSummaryTable').DataTable().ajax.reload(null, resetpaging);
          console.log("table refresh")
}

function fire_ajax_submit(){
        	// PREPARE FORM DATA
        	var formData = {
        		id : $("#m_record-id").val(),
        		productDescription:  $("#m_ProductDescription").val(),
        		applicantCount: $("#m_ApplicantCount").val(),
        		applicant1Name: $("#m_Applicant1Name").val(),
        		applicant2Name: $("#m_Applicant2Name").val(),
        		fromDate:   convertToJSONDate($("#m_fromDate").val()),
        		toDate:     convertToJSONDate($("#m_toDate").val()),
        		amount:     $("#m_Amount").val()
        	}

        	// DO POST
        	console.log(JSON.stringify(formData));
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "/QuoteSummary/add",
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

	 var table = $('#QuoteSummaryTable').DataTable({
            ajax: {
                    type : 'GET',
                                          url: 'QuoteSummary/all',
                                          dataSrc: ''},
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "id"},
				    { "mData": "productDescription" },
				    { "mData": "applicantCount" },
				    { "mData": "applicant1Name" },
				    { "mData": "applicant2Name" },
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
				    { "mData": "proceededWith" },
				    {   "data": null,
                                   "render": function(data) {

                                       return '<button onclick= EditHandler() class="btn btn-info btn-sm edit_btn" id="'+'edi'+data.id+'">'+
                                       '<span class="glyphicon glyphicon-pencil" aria-hidden="true" id="'+ 'eds'+data.id +'"></span>' +
                                       '</button>'
                                       + '<button onclick= DeleteHandler() class="btn btn-danger btn-sm del_btn" id="'+'del'+data.id+'">' +
                                       '<span class="glyphicon glyphicon-remove" aria-hidden="true" id="'+ 'des'+data.id +'"></span>'
                                       + '</button>'
                                       + '<button onclick= DIPHandler() class="btn btn-info btn-sm edit_btn" id="'+'dip'+data.id+'">' +
                                                                              '<span class="glyphicon glyphicon-transfer" aria-hidden="true" id="'+ 'des'+data.id +'"></span>'
                                                                              + '</button>';
                                   }}

			]
	 });


 $('#ModalSave').click( function () {
        fire_ajax_submit();
    } );


$('#btnAdd').click ( function()
    {
    // Clear the existing data then show the modal
     $('#m_record-id').val("");
     $('#m_ApplicantCount').val("");
     $('#m_Applicant1Name').val("");
     $('#m_Applicant2Name').val("");
     $('#m_ProductDescription').val("");
     $('#m_fromDate').val("");
     $('#m_toDate').val("");
     $('#m_amount').val("");

     $("#myModal").modal('show');

    }
);


} );
