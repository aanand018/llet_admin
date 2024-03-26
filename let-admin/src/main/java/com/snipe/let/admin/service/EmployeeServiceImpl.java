package com.snipe.let.admin.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.common.ApiUtility;
import com.snipe.let.admin.common.GenericHttpClient;
import com.snipe.let.admin.common.JsonUtil;
import com.snipe.let.admin.common.LetEnum;
import com.snipe.let.admin.config.LETProperties;
import com.snipe.let.admin.dao.EmployeeDAO;
import com.snipe.let.admin.domain.EmployeeDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
import com.snipe.let.admin.exception.LetRestException.SC_NOT_FOUND;
import com.snipe.let.admin.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	LETProperties letProperties;

	@Override
	public String addEmployee(EmployeeModel employeeModel) throws Exception {
		EmployeeDomain employeeDomain = new EmployeeDomain();
//		EmployeeDomain profileDetails = addProfileInfo(employeeModel);
		long pId = 1;
		EmployeeDomain profileDetails1 = getProfileInfo(pId);
		BeanUtils.copyProperties(employeeModel, employeeDomain);
		employeeDomain.setProfileId(profileDetails1.getProfileId());
		return employeeDAO.addEmployee(employeeDomain);
	}

	private EmployeeDomain getProfileInfo(long pId) throws Exception {
		Map<String, Object> httpResponse = GenericHttpClient.doHttpGet(letProperties.getAuthUrl() + "/profile/" + pId,
				ApiUtility.getHeaders(letProperties.getHeaderApiKey(), letProperties.getAccessTokenKey()),
				LetEnum.AUTH.name());
		int statusCode = (int) httpResponse.get("statusCode");
		JSONObject jsonResponse = (JSONObject) httpResponse.get("response");
		if (jsonResponse != null) {
			if (statusCode != HttpStatus.OK.value())
				throw new SC_NOT_FOUND();
			else {
				EmployeeDomain profileInfo = JsonUtil.fromJson(jsonResponse.getJSONObject("data").toString(),
						EmployeeDomain.class);
				return profileInfo;
			}
		} else {
			throw new BACKEND_SERVER_ERROR();
		}
	}

	private EmployeeDomain addProfileInfo(EmployeeModel employeeModel) throws Exception {
		String reqBody = JsonUtil.toJsonString(employeeModel);
		Map<String, Object> httpResponse = GenericHttpClient.doHttpPost(letProperties.getAuthUrl() + "/save/profile",
				ApiUtility.getHeaders(letProperties.getAccessTokenKey(), letProperties.getHeaderApiKey()), reqBody,
				LetEnum.AUTH.name());
		int statusCode = (int) httpResponse.get("statusCode");
		JSONObject jsonResponse = (JSONObject) httpResponse.get("response");
		if (jsonResponse != null) {
			if (statusCode != HttpStatus.OK.value())
				throw new SC_NOT_FOUND();
			else {
				EmployeeDomain profileInfo = JsonUtil.fromJson(jsonResponse.getJSONObject("data").toString(),
						EmployeeDomain.class);
				return profileInfo;
			}
		} else {
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<EmployeeModel> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel getEmployeeListById(long EmployeeID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(EmployeeModel employeeModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(long EmployeeID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
