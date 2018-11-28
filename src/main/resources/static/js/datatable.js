$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
                ajax: {
                    url: 'demo/all',
                    dataSrc: ''},
			"order": [[ 0, "asc" ]],
			 select: true,
			buttons: [
                        {
                            text: 'Row selected data',
                            action: function ( e, dt, node, config ) {
                                alert(
                                    'Row data: '+
                                    JSON.stringify( dt.row( { selected: true } ).data() )
                                );
                            },
                            enabled: true
                        },
                        {
                            text: 'Count rows selected',
                            action: function ( e, dt, node, config ) {
                                alert( 'Rows: '+ dt.rows( { selected: true } ).count() );
                            },
                            enabled: true
                        }
                    ],
			"aoColumns": [
			        { "mData": "id"},
		            { "mData": "name" },
				    { "mData": "password" },
				    { "mData": "email" },
				    { data: null,
                                                      title: 'Action',
                                                      wrap: true,
                                                      "render": function (item) {
                                                          return  "<a href=demo/FindbyID/"+ item.id +">Edit</a>";

                                                      }
                                                      }

			]
	 })



    $('#employeesTable tbody').on( 'click', 'tr', function (){
         $(this).toggleClass('selected');
     } );

 $('#btn').click( function () {
       alert(table.cell('.selected',1).data());
        //console.log(table.rows('.selected').data());
        //alert("Check the console for selected data");
    } );

table.on( 'select deselect', function () {
        var selectedRows = table.rows( { selected: true } ).count();

        table.button( 0 ).enable( selectedRows === 1 );
        table.button( 1 ).enable( selectedRows > 0 );
    } );

} );
