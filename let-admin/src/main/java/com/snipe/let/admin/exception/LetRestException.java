package com.snipe.let.admin.exception;

import static org.apache.http.HttpStatus.SC_OK;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

/**
 *
 * @author Jayaram B
 * @since 2020-03-31
 */

public class LetRestException extends RuntimeException {
	private static final long serialVersionUID = -977217199574702703L;

	public static int INTERNAL_ERROR_CODE = -1;
	protected int httpErrorCode = SC_OK;
	protected int errorCode = Integer.MAX_VALUE;

	protected String exReason;

	protected Map<String, Object> meta;
	protected Map<String, String> dictionary;

	public LetRestException() {
		super();
		this.meta = new LinkedHashMap<String, Object>();
	}

	public LetRestException(String message) {
		super(message);
		this.meta = new LinkedHashMap<String, Object>();
	}

	public LetRestException(String message, Throwable t) {
		super(message, t);
		this.meta = new LinkedHashMap<String, Object>();
	}

	public LetRestException(String message, Throwable t, int errCode) {
		this(message, t);
		errorCode = errCode;
	}

	public LetRestException(String message, Throwable t, int errCode, int httpErrCode) {
		this(message, t);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public LetRestException(int errCode, int httpErrCode, String message) {
		this(message);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public LetRestException(int errCode, int httpErrCode, String message, Throwable t) {
		this(message, t);
		errorCode = errCode;
		httpErrorCode = httpErrCode;
	}

	public String getExReason() {
		return exReason;
	}

	public void setExReason(String exReason) {
		this.exReason = exReason;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(int httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * Common Exceptions
	 */
	public static final class BACKEND_SERVER_ERROR extends LetRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_SERVER_ERROR() {
			super(1000, HttpStatus.SC_INTERNAL_SERVER_ERROR, String.format("Backend Server Error, Please Retry."));
		}
	}

	public static final class BACKEND_SERVER_READ_TIMEOUT extends LetRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_SERVER_READ_TIMEOUT() {
			super(1001, HttpStatus.SC_GATEWAY_TIMEOUT,
					String.format("Backend Server read timeout Error, Please Retry."));
		}
	}

	public static final class ACCESS_DENIED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public ACCESS_DENIED() {
			super(1002, HttpStatus.SC_UNAUTHORIZED, String.format("Access denied Error"));
		}
	}

	public static final class FORBIDDEN extends LetRestException {
		private static final long serialVersionUID = 1L;

		public FORBIDDEN() {
			super(1003, HttpStatus.SC_FORBIDDEN, String.format("Forbidden Error"));
		}
	}

	public static final class SC_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public SC_NOT_FOUND() {
			super(1004, HttpStatus.SC_NOT_FOUND, String.format("Not Found"));
		}
	}

	public static final class BACKEND_PARSE_ERROR extends LetRestException {
		private static final long serialVersionUID = 1L;

		public BACKEND_PARSE_ERROR() {
			super(1005, HttpStatus.SC_INTERNAL_SERVER_ERROR, String.format("Backend parse Error"));
		}
	}

	public static final class SAVE_FAILED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public SAVE_FAILED(String message) {
			super(1006, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	public static final class UPDATE_FAILED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public UPDATE_FAILED(String message) {
			super(1007, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	public static final class COUNT_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public COUNT_NOT_FOUND(String message) {
			super(1008, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	public static final class NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public NOT_FOUND(String message) {
			super(1009, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	public static final class DELETE_FAILED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public DELETE_FAILED(String message) {
			super(1010, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	/**
	 * Password Exceptions : The Error codes can be used to handle in App or website
	 * Profile Error code range - 2001 to 2015
	 */
	public static final class PASSWORD_PATTERN_NOT_MATCHED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public PASSWORD_PATTERN_NOT_MATCHED() {
			super(2001, HttpStatus.SC_NOT_FOUND, String.format(
					"Password does Not Match, Password Pattern Should Minimum eight characters, at least one uppercase letter, one lowercase letter,one number and one sepcial Symbol"));
		}
	}

	public static final class PASSWORD_MISMATCH extends LetRestException {
		private static final long serialVersionUID = 1L;

		public PASSWORD_MISMATCH() {
			super(2002, HttpStatus.SC_NOT_FOUND, String.format("Please make sure your passwords match"));
		}
	}

	public static final class OLD_PASSWORD__MISMATCH extends LetRestException {
		private static final long serialVersionUID = 1L;

		public OLD_PASSWORD__MISMATCH() {
			super(2003, HttpStatus.SC_NOT_FOUND, String.format("Invalid Old Password"));
		}
	}

	public static final class PASSWORD_NOT_UPDATED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public PASSWORD_NOT_UPDATED() {
			super(2004, HttpStatus.SC_NOT_FOUND, String.format("Unable to update password"));
		}
	}

	public static final class OLD_PASSWORD_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public OLD_PASSWORD_NOT_FOUND() {
			super(2005, HttpStatus.SC_NOT_FOUND, String.format("Please enter old password"));
		}
	}

	public static final class FIRSTNAME_PATTERN_NOT_MATCH extends LetRestException {
		private static final long serialVersionUID = 1L;

		public FIRSTNAME_PATTERN_NOT_MATCH() {
			super(2006, HttpStatus.SC_NOT_FOUND, String.format("Please specify a Valid First name"));
		}
	}

	public static final class EMAILID_PATTERN_NOT_MATCH extends LetRestException {
		private static final long serialVersionUID = 1L;

		public EMAILID_PATTERN_NOT_MATCH() {
			super(2007, HttpStatus.SC_NOT_FOUND, String.format("Please specify a Valid emailId"));
		}
	}

	public static final class PROFILE_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public PROFILE_NOT_FOUND() {
			super(2008, HttpStatus.SC_NOT_FOUND, String.format("Profile Details Not found"));
		}
	}

	/**
	 * /** Document and Image Upload Exceptions : The Error codes can be used to
	 * handle in App or website Document and Image upload Request Error code range -
	 * 3301 to 4000
	 */
	public static final class EMPTY_FILE extends LetRestException {
		private static final long serialVersionUID = 1L;

		public EMPTY_FILE(String msg) {
			super(3301, HttpStatus.SC_NO_CONTENT, String.format(msg));
		}
	}

	public static final class FILE_UPLOAD_FAILED extends LetRestException {
		private static final long serialVersionUID = 1L;

		public FILE_UPLOAD_FAILED() {
			super(3302, HttpStatus.SC_NOT_FOUND, String.format("Failed to upload image. Please try later.."));
		}

		public FILE_UPLOAD_FAILED(String msg) {
			super(3303, HttpStatus.SC_NOT_FOUND, String.format(msg));
		}
	}

	/**
	 * /** Role Exceptions : The Error codes can be used to handle in App or website
	 * Role Error code range - 4001 to 4010
	 */
	public static final class ROLE_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public ROLE_NOT_FOUND(String id) {
		}
	}

	public static final class VALIDATE extends LetRestException {
		private static final long serialVersionUID = 1L;

		public VALIDATE(String message) {
			super(4011, HttpStatus.SC_NOT_FOUND, message);
		}
	}

	public static final class STOCK_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public STOCK_NOT_FOUND(String userId, long subcategoryId) {
			super(4012, HttpStatus.SC_NOT_FOUND, String.format("No stock found"));
		}
	}
	
	
	
	
	public static final class Catalogue_NOT_FOUND extends LetRestException {
		private static final long serialVersionUID = 1L;

		public Catalogue_NOT_FOUND(long stateId, long cityId, LocalDateTime fromDate,LocalDateTime toDate, String storeType,String catalogueType) {
			super(4013, HttpStatus.SC_NOT_FOUND, String.format("NO Catelogues Found"));
		}
		
		public Catalogue_NOT_FOUND(long stateId, long cityId, LocalDateTime fromDate,LocalDateTime toDate) {
			super(4014, HttpStatus.SC_NOT_FOUND, String.format("NO Catelogues Found"));
		}
		
		
		
	}
}
