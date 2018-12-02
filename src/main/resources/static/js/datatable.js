$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
                ajax: {
                    url: 'demo/all',
                    dataSrc: ''},
			"order": [[ 0, "asc" ]],
			 select: true,
			buttons: [

                                {
                                    extend: 'selected',
                                    action: function ( e, dt, node, config ) {
                                        var rows = dt.rows( { selected: true } ).count();

                                        alert( 'There are '+rows+'(s) selected in the table' );
                                    }
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


$('#employeesTable').on( 'click', 'tbody tr', function () {
    if ( table.row( this, { selected: true } ).any() ) {
        table.row( this ).deselect();
    }
    else {
        table.row( this ).select();
    }
} );


} );
