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
		$('#a_' + menu).addClass('active');
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

		$table.dataTable({

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
							data: 'code',
							mRender: function(data,type,row){
								return '<img src="'+windows.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" />';
							}
						},
						
						{
							data : 'name',
						},
						{
							data : 'brand',
						},
						{
							data : 'unitPrice',
							mRender: function(data,type,row){
								return '&#8377; ' + data;
							}
						},
						{
							data : 'quantity',
						},
						{
							data: 'id',
							bSorted: false,
							mRender: function(data,type,row){
								var str= '';
								str += '<a href=" '+window.contextRoot+'/show/'+data+'/product" class="btn  btn-primary"><span class="glyphicon gluphicon-eye-open"></span>View</a> &#160;';
								str += '<a href=" '+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-primary"	><span class="glyphicon gluphicon-shopping-cart"></span>Add to cart</a>';
								
								return str;
							},
						}
					]
				
				});

	}

});
