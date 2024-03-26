package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.model.BankModel;
import com.snipe.let.admin.service.BankService;

@RestController
@RequestMapping("/v1")
// @CrossOrigin(origins = "http://localhost:4200")
@SuppressWarnings("rawtypes")
public class BankController {

	@Autowired
	BankService bankService;

	@RequestMapping(value = "/addBank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addBank(@RequestBody BankModel bankModel) throws Exception {
		return prepareSuccessResponse(bankService.saveBank(bankModel));
	}

	@RequestMapping(value = "/bankList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getBankList() throws Exception {
		return prepareSuccessResponse(bankService.getBankList());
	}

	@RequestMapping(value = "/bankList/{bankID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getBankListById(@PathVariable("bankID") long bankID) throws Exception {
		return prepareSuccessResponse(bankService.getListByBankId(bankID));
	}

	@RequestMapping(value = "/updateBank", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateBank(@RequestBody BankModel bankModel) throws Exception {
		return prepareSuccessResponse(bankService.updateBank(bankModel));
	}

	@RequestMapping(value = "/deleteBank/{bankId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteBankById(@PathVariable("bankId") String bankId) throws Exception {
		return prepareSuccessResponse(bankService.deleteBankById(bankId));
	}

//	@RequestMapping(value = "/bankCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
//	@ResponseBody
//	public ResponseEntity<GenericRes> bankCount() throws Exception {
//		return prepareSuccessResponse(bankService.bankCount());
//	}
}
