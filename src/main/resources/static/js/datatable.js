$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
                ajax: {
                    url: 'demo/all',
                    dataSrc: ''},
			"order": [[ 0, "asc" ]],
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

function ViewAction(id) {
            var _url = '@Url.Action("ActionMethod", "Controller", new { id=666})'.replace('666', id);
            window.location.href = _url;
        }
} );
