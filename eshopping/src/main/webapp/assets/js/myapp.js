$(function() {
	// to solve active menu problem
	switch (menu) {

	case 'About us':
		$('#about').addClass('active');
		break;

	case 'Contact us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a-' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable

	var $table = $('productListTable');

	// execute when table is present

	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = '/json/data/category/' + window.categoryId + '/products';
		}

		$table
				.dataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 5,
					ajax: {
						url : jsonUrl,
						dataSrc : ''
					},
					columns: [
						{
							data : 'name',
						},
						{
							data : 'name',
						},
						
						
					]
				
				});

	}

});
