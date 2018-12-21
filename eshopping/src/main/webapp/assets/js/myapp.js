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
		$('#listProducts').addClass('active');
		$('#a-' + menu).addClass('active');
		break;
	}

});
