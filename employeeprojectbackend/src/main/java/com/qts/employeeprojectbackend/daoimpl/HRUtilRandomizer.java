package com.qts.employeeprojectbackend.daoimpl;

import java.util.UUID;

public class HRUtilRandomizer {
	

	public static String getEmployeeID() {
		//return "EMP"+Integer.toString(employeeID);
		return "EMP" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

}
