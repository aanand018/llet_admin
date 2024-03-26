package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.EmployeeDomain;

public interface EmployeeDAO {

	public String addEmployee(EmployeeDomain employeeDomain) throws Exception;

	public List<EmployeeDomain> getEmployeeList() throws Exception;

	public EmployeeDomain getEmployeeListById(long EmployeeID) throws Exception;

	public String updateEmployee(EmployeeDomain employeeDomain) throws Exception;

	public String deleteEmployeeById(long EmployeeID) throws Exception;

}
