package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.model.EmployeeModel;

public interface EmployeeService {

	public String addEmployee(EmployeeModel employeeModel) throws Exception;

	public List<EmployeeModel> getEmployeeList() throws Exception;

	public EmployeeModel getEmployeeListById(long EmployeeID) throws Exception;

	public String updateEmployee(EmployeeModel employeeModel) throws Exception;

	public String deleteEmployeeById(long EmployeeID) throws Exception;

}
