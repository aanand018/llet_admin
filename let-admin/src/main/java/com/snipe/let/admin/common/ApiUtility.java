package com.snipe.let.admin.common;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snipe.let.admin.constants.Constants;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_READ_TIMEOUT;

public class ApiUtility {
	private static final Logger logger = LoggerFactory.getLogger(ApiUtility.class);

	public static CloseableHttpResponse doHttpPost(final String url, Map<String, String> headers, final String content)
			throws Exception {

		CloseableHttpResponse httpResponse = null;
		try {
			final HttpClientBuilder hcb = HttpClientBuilder.create();
			final CloseableHttpClient client = hcb.build();

			RequestConfig rc = RequestConfig.custom().setConnectTimeout(Constants.API_TIME_OUT)
					.setSocketTimeout(Constants.API_TIME_OUT).build();

			HttpRequestBase hrb = new HttpPost(url);
			hrb.setConfig(rc);
			if (headers != null) {
				Iterator<Map.Entry<String, String>> headersIterator = headers.entrySet().iterator();
				while (headersIterator.hasNext()) {
					Map.Entry<String, String> e = headersIterator.next();
					hrb.setHeader(e.getKey(), e.getValue());
				}
			}
			if (content != null) {
				((HttpPost) hrb).setEntity(new StringEntity(content, StandardCharsets.UTF_8.name()));
			}
			httpResponse = client.execute(hrb);
		} catch (Exception e) {
			try {
				logger.error("Exception in doHttpPost Url" + url + e.getMessage());
			} catch (Exception e1) {
			}
			if (e instanceof ConnectTimeoutException) {
				throw new BACKEND_SERVER_READ_TIMEOUT();
			}
		}
		return httpResponse;
	}

	public static CloseableHttpResponse doHttpGet(final String url, Map<String, String> headers) throws Exception {
		CloseableHttpResponse httpResponse = null;
		try {
			final HttpClientBuilder hcb = HttpClientBuilder.create();
			final CloseableHttpClient client = hcb.build();

			RequestConfig rc = RequestConfig.custom().setConnectTimeout(Constants.API_TIME_OUT)
					.setSocketTimeout(Constants.API_TIME_OUT).build();

			HttpRequestBase hrb = new HttpGet(url);
			hrb.setConfig(rc);
			if (headers != null) {
				Iterator<Map.Entry<String, String>> headersIterator = headers.entrySet().iterator();
				while (headersIterator.hasNext()) {
					Map.Entry<String, String> e = headersIterator.next();
					hrb.setHeader(e.getKey(), e.getValue());
				}
			}
			httpResponse = client.execute(hrb);
		} catch (Exception e) {
			try {
				logger.error("Exception in doHttpGet Url" + url + e.getMessage());
			} catch (Exception e1) {
			}
			if (e instanceof ConnectTimeoutException) {
				throw new BACKEND_SERVER_READ_TIMEOUT();
			}
		}
		return httpResponse;
	}

	public static CloseableHttpResponse doHttpPut(final String url, Map<String, String> headers, final String content)
			throws Exception {

		CloseableHttpResponse httpResponse = null;
		try {
			final HttpClientBuilder hcb = HttpClientBuilder.create();
			final CloseableHttpClient client = hcb.build();

			RequestConfig rc = RequestConfig.custom().setConnectTimeout(Constants.API_TIME_OUT)
					.setSocketTimeout(Constants.API_TIME_OUT).build();

			HttpRequestBase hrb = new HttpPut(url);
			hrb.setConfig(rc);
			if (headers != null) {
				Iterator<Map.Entry<String, String>> headersIterator = headers.entrySet().iterator();
				while (headersIterator.hasNext()) {
					Map.Entry<String, String> e = headersIterator.next();
					hrb.setHeader(e.getKey(), e.getValue());
				}
			}
			if (content != null) {
				((HttpPut) hrb).setEntity(new StringEntity(content, StandardCharsets.UTF_8.name()));
			}
			httpResponse = client.execute(hrb);
		} catch (Exception e) {
			try {
				logger.error("Exception in doHttpPut Url" + url + e.getMessage());
			} catch (Exception e1) {
			}
			if (e instanceof ConnectTimeoutException) {
				throw new BACKEND_SERVER_READ_TIMEOUT();
			}
		}
		return httpResponse;
	}

	public static CloseableHttpResponse doHttpDelete(final String url, Map<String, String> headers) throws Exception {

		CloseableHttpResponse httpResponse = null;
		try {
			final HttpClientBuilder hcb = HttpClientBuilder.create();
			final CloseableHttpClient client = hcb.build();

			RequestConfig rc = RequestConfig.custom().setConnectTimeout(Constants.API_TIME_OUT)
					.setSocketTimeout(Constants.API_TIME_OUT).build();

			HttpRequestBase hrb = new HttpDelete(url);
			hrb.setConfig(rc);
			if (headers != null) {
				Iterator<Map.Entry<String, String>> headersIterator = headers.entrySet().iterator();
				while (headersIterator.hasNext()) {
					Map.Entry<String, String> e = headersIterator.next();
					hrb.setHeader(e.getKey(), e.getValue());
				}
			}
			httpResponse = client.execute(hrb);
		} catch (Exception e) {
			try {
				logger.error("Exception in doHttpDelete Url" + url + e.getMessage());
			} catch (Exception e1) {
			}
			if (e instanceof ConnectTimeoutException) {
				throw new BACKEND_SERVER_READ_TIMEOUT();
			}
		}
		return httpResponse;
	}

	public static Map<String, String> getHeaders(String apiKey, String apiToken) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json; charset=UTF-8");
		headers.put("x-api-key", apiKey);
		if (null != apiToken)
			headers.put("x-api-token", apiToken);
		headers.put("x-bypass-token", "Yes");
		return headers;
	}
}
