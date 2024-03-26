package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.EmployeeDomain;

public interface EmployeeRepository extends JpaRepository<EmployeeDomain, Long> {

}
