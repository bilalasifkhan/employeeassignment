CREATE TABLE employee (
	id IDENTITY,
	emp_id VARCHAR(50),
	name VARCHAR(50),
	salary BIGINT(20),
	grade INT,
	is_active BOOLEAN,
	
	CONSTRAINT pk_employee_id PRIMARY KEY (id)

);

