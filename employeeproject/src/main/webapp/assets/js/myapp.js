$(function() {
	
	//Creating active menu highlight
	switch(menu) {
		case 'Find Employee':
			$('#findEmployee').addClass('active');
			break;
		case 'Add Employee':
			$('#addEmployee').addClass('active');
			break;
		case 'Update Employee':
			$('#updateEmployee').addClass('active');
			break;
		case 'Delete Employee':
			$('#deleteEmployee').addClass('active');
			break;
		case 'Promote Employee':
			$('#promoteEmployee').addClass('active');
			break;
		default:
			$('#home').addClass('active');
			break
	}
});