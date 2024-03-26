package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.EmployeeDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
import com.snipe.let.admin.utils.DataValidation;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataValidation dataValidation;

	@Override
	public String addEmployee(EmployeeDomain employeeDomain) throws Exception {
		try {
			entityManager.persist(employeeDomain);
			return "Employee Details Saved";
		} catch (Exception e) {
			logger.error("Exception addEmployee in EmployeeDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<EmployeeDomain> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDomain getEmployeeListById(long EmployeeID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(EmployeeDomain employeeDomain) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(long EmployeeID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
