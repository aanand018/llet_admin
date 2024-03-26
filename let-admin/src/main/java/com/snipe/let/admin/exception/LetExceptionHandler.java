package com.snipe.let.admin.exception;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareErrorResponse;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
* @author Jayaram B
* @since 2020-03-31
*/

@SuppressWarnings("rawtypes")
@ControllerAdvice
public class LetExceptionHandler {
	protected Logger logger = LoggerFactory.getLogger(super.getClass());

	public LetExceptionHandler() {
		super();
	}

	@ExceptionHandler(LetRestException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleApplicationException(LetRestException ex, HttpServletRequest request,
			HttpServletResponse response) {
		return prepareErrorResponse(ex);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleBadRequestsErrors(HttpMessageNotReadableException ex,
			HttpServletRequest request, HttpServletResponse response) {
		return prepareErrorResponse(ex, SC_BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex, HttpServletRequest request, HttpServletResponse response) {
		return prepareErrorResponse(ex, SC_BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleMethodArgException(MethodArgumentNotValidException ex,
			HttpServletRequest request, HttpServletResponse response) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		String message = "Validation failed for following argument(s):: {";
		if (fieldErrors != null && fieldErrors.size() > 0) {
			for (FieldError fieldError : fieldErrors) {
				message += fieldError.getField() + " : " + fieldError.getDefaultMessage() + ",";
			}
			message = message.substring(0, message.length() - 1) + " }";
		}
		return prepareErrorResponse(ex, SC_BAD_REQUEST, message);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleException(Throwable ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return prepareErrorResponse(ex, HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
}
