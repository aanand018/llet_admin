package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.snipe.let.admin.domain.BankDomain;

public interface BankRepository extends JpaRepository<BankDomain, Long> {


public long deleteByBankId(String bankId);
	
public BankDomain findByBankId(long bankId);

}
