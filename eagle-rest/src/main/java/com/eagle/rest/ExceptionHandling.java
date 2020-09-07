package com.eagle.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	//Below ExceptionHandlers return HTTP responses of type <BrandErrorResponse>
		@ExceptionHandler
		public ResponseEntity<BrandErrorResponse> handleException(BrandNotFoundException e){
			
			//Below code sets the body of the response
			BrandErrorResponse error = new BrandErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
			
			return new ResponseEntity<BrandErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler
		public ResponseEntity<BrandErrorResponse> handleException(BrandIsNegativeException e){
			
			//This code sets the body of the response
			BrandErrorResponse error = new BrandErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
			
			return new ResponseEntity<BrandErrorResponse>(error, HttpStatus.NOT_FOUND);
			
		}
		
		//Below is a generic Exception Handler
		@ExceptionHandler
		public ResponseEntity<BrandErrorResponse> handleException(Exception e)
		{
			BrandErrorResponse error = new BrandErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
			return new ResponseEntity<BrandErrorResponse>(error,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<DistributorErrorResponse> handleException(DistributorNotFoundException e){
			
			DistributorErrorResponse error = new DistributorErrorResponse();
			error.setErrorMessage(e.getMessage());
			error.setStatus(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<DistributorErrorResponse>(error, HttpStatus.NOT_FOUND);
					
		}

}
