package com.sample.springrest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = { CustException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(CustException ex) {
		return new ErrorResponse(400, ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse resourceNotFound(Exception ex) {
		return new ErrorResponse(404, ex.getMessage());
	}

	/*
	 * @ExceptionHandler(CustException.class) public ResponseEntity<ErrorObject>
	 * myException(CustException c){ ErrorObject obj = new ErrorObject();
	 * obj.setErrorCode("500"); obj.setErrorMessage("unable to process request."
	 * ); obj.setErrorDesc("internal server error"); return new
	 * ResponseEntity<ErrorObject>(obj, HttpStatus.INTERNAL_SERVER_ERROR) ; }
	 */

}
