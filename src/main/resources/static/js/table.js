			$(document).ready(function() {
				$("#attendantTable").DataTable({
						'aoColumnDefs': [{
        				'bSortable': false,
        				'aTargets': [-1]
    				}]
				});
			})
