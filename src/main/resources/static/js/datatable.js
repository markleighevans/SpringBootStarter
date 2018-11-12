$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
			"sAjaxSource": "demo/all",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
		      { "mData": "name" },
				  { "mData": "password" },
				  { "mData": "email" }
			]
	 })
});