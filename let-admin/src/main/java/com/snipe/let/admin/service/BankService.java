package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.BankDomain;
import com.snipe.let.admin.model.BankModel;
import com.snipe.let.admin.model.CityModel;

public interface BankService {
	
	public String saveBank(BankModel bankModel) throws Exception;
	
	public List<BankDomain> getBankList() throws Exception;

	public String updateBank(BankModel bankModel) throws Exception;
	
	public String deleteBankById(String bankId) throws Exception;
	
	public BankDomain getListByBankId(long bankId) throws Exception;



}
