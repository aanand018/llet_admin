package com.snipe.let.admin.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.snipe.let.admin.common.ApiUtility;
import com.snipe.let.admin.common.GenericHttpClient;
import com.snipe.let.admin.common.LetEnum;
import com.snipe.let.admin.config.LETProperties;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
import com.snipe.let.admin.exception.LetRestException.STOCK_NOT_FOUND;
import com.snipe.let.admin.model.StockModel;

@Component
@SuppressWarnings("unused")
public class RetailerCommonServices {

	@Autowired
	LETProperties letProperties;

	public StockModel getAvailableStock(String userId, long subCategoryId) throws Exception {
		StockModel stockModel = new StockModel();
		Map<String, Object> httpResponse = GenericHttpClient.doHttpGet(
				letProperties.getRetailerUrl() + "/product/stock/" + userId + "/" + subCategoryId,
				ApiUtility.getHeaders(letProperties.getHeaderApiKey(), letProperties.getAccessTokenKey()),
				LetEnum.RETAILER.name());
		int statusCode = (int) httpResponse.get("statusCode");
		JSONObject jsonResponse = (JSONObject) httpResponse.get("response");
		JSONObject data = (JSONObject) jsonResponse.get("data");
		if (jsonResponse != null) {
			if (statusCode != HttpStatus.OK.value()) {
				throw new STOCK_NOT_FOUND(userId, subCategoryId);
			} else {
				Double availableQuantity = data.getDouble("availableQuantity");
				stockModel.setAvailableQuantity(availableQuantity);
				Double totalQuantity = data.getDouble("totalQuantity");
				stockModel.setTotalQuantity(totalQuantity);
				Double availableStock = data.getDouble("availableStock");
				stockModel.setAvailableStock(availableStock);
			}
		} else {
			throw new BACKEND_SERVER_ERROR();
		}
		return stockModel;
	}

}
