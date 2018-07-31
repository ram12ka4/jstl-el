$(document).ready(
		function() {

			$('.doctor-record').on(
					'click',
					function() {

						var id = $(this).attr('data-id');
						//alert(id);

						$('.myModal .modal-body').load(
								'/welcome.do?ACTION=FETCH_RECORD&ip=' + id,
								function() {

									$('.myModal').modal({
										show : true
									});
								});
					});

			$(document).on('click', '.delete-doctor-rec', function() {
				var id = $(this).data('id');
				//alert(id);
				$('.deleteModal .delete-doc-rec-per').attr('data-id', id);
				$('.myModal').modal('hide');
				$('.deleteModal').modal({
					show : true
				});
			});

			$(document).on('click', '.delete-doc-rec-per', function() {
				var id = $(this).data('id');
				//alert("Final Delete id " + id);

				req = $.ajax({

					dataType : 'html',
					type : 'GET',
					url : '/welcome.do',
					data : {
						ACTION : "DELETE_RECORD",
						ip : id
					},
					success: function(data){
						//alert("Data Value " + data);
						alert("DATA deleted successfully");
						$('.deleteModal').modal('hide');
						$('.doctor-record').trigger("click");
						$('#foo').trigger('custom', ["Custom", "Event"]);
					},
					error: function(data){
						//alert("Data Value " + data);
						alert("Data error");
					}

				});
			});
			
			$('#foo').on('custom', function(event, param1, param2){
				alert(param1 + "\n" + param2);
			});
			
		});
