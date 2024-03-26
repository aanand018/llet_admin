package com.snipe.let.admin.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.snipe.let.admin.common.Status;
import com.snipe.let.admin.config.LETProperties;
import com.snipe.let.admin.constants.Constants;
import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.utils.CommonUtils;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@ComponentScan(basePackages = { "com.snipe.let" })
@SuppressWarnings("rawtypes")
public class LETFilter implements Constants, Filter {

	@Autowired
	LETProperties letProperties;

	@Autowired
	JwtToken jwtToken;

	private static final Logger logger = LoggerFactory.getLogger(LETFilter.class);

	@SuppressWarnings("unused")
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(config.getServletContext());
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("In doFilter");
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,X-API-KEY,X-API-TOKEN");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addIntHeader("Access-Control-Max-Age", 3600);
		response.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String url = request.getRequestURL().toString();
		if (url.contains("swagger") || url.contains("api-docs")
				|| request.getRequestURI().equals(request.getContextPath() + "/health")
				|| url.contains("/v1/subCategoriesList/CategoriesTypeId/") || url.contains("v1/subCategoriesList/")
				|| url.contains("/v1/getBanners") || url.contains("/bankList") || url.contains("/categoriesList")
				|| url.contains("/categoriesTypeList") || url.contains("/cityList") || url.contains("/countryList")
				|| url.contains("/stateList") || url.contains("/v1/city")|| url.contains("/v1/city")){
			chain.doFilter(request, response);
		} else {
			String xApiKey = request.getHeader(ACCESS_KEY_HEADER);
			String xApiToken = request.getHeader(ACCESS_TOKEN_HEADER);
			String jsonResponse = null;
			letProperties.setAccessTokenKey(xApiToken);
			if (!request.getMethod().equalsIgnoreCase("OPTIONS")) {
				jsonResponse = validateRequest(xApiKey);
			}
			String requestPath = request.getRequestURI().substring(request.getContextPath().length());
			if (jsonResponse == null && !request.getMethod().equalsIgnoreCase("OPTIONS")) {
				String xByPassToken = request.getHeader(BY_PASS_TOKEN);
				if (!"Yes".equalsIgnoreCase(xByPassToken))
					jsonResponse = validateApiToken(xApiToken, requestPath, Arrays.asList());
			}

			if (jsonResponse != null) {
				response.setStatus(401);
				response.getWriter().println(jsonResponse);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void destroy() {
	}

	public String validateApiToken(String xApiToken, String requestPath, List<String> exludePathList) {
		GenericRes response = new GenericRes();
		if (!exludePathList.contains(requestPath)) {
			boolean isInvalid = true;
			try {
				isInvalid = (null == xApiToken || !jwtToken.isValidToken(xApiToken, requestPath));
			} catch (Exception e) {
				isInvalid = true;
			}

			if (isInvalid) {
				response.setExCode("INVALID_HEADER_API_TOKEN");
				response.setResCode(1012);
				response.setMessage("Invalid Header Api Token");
				response.setStatus(Status.FAILURE);
				return CommonUtils.getJson(response);
			}
		}
		return null;
	}

	public String validateRequest(String xApiKey) {
		GenericRes response = new GenericRes();
		if (!letProperties.getHeaderApiKey().equalsIgnoreCase(xApiKey)) {
			response.setExCode("INVALID_HEADER_API_KEY");
			response.setResCode(1011);
			response.setMessage("Invalid Header Api Key");
			response.setStatus(Status.FAILURE);
			return CommonUtils.getJson(response);
		}
		return null;
	}
}
