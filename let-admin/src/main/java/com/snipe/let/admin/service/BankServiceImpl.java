package com.snipe.let.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.BankRepository;
import com.snipe.let.admin.domain.BankDomain;
import com.snipe.let.admin.mapper.BankMapper;
import com.snipe.let.admin.model.BankModel;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BankMapper bankMapper;
	
	@Override
	public String saveBank(BankModel bankModel)throws Exception {
		BankDomain bankDomain = new BankDomain();
		BeanUtils.copyProperties(bankModel,bankDomain );
		bankRepository.save(bankDomain);
		return "bankSaved";
	}

	@Override
	public List<BankDomain>getBankList() throws Exception {
		List<BankDomain> bankDomain = bankRepository.findAll();
		return bankDomain;
	}

	@Override
	public String updateBank(BankModel bankModel) throws Exception {
		BankDomain bankDomain = new BankDomain();
		BeanUtils.copyProperties(bankModel, bankDomain);
		bankRepository.save(bankDomain);
		return "bank update";
	}

	@Override
	public String deleteBankById(String bankId) throws Exception {
		bankRepository.deleteByBankId(bankId);
		return "bankById deleted";
	}

	@Override
	public BankDomain getListByBankId(long bankId) throws Exception {
		BankDomain bankDomain = bankRepository.findByBankId(bankId);
		return bankDomain;
	}
}
