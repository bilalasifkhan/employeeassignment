package com.qts.employeeprojectbackend.daoimpl;

public class HRUtilRandomizer {
	private static int employeeID = 1001;

	public static int getEmployeeID() {
		return employeeID++;
	}

}
