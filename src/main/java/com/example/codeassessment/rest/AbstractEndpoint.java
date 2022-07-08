package com.example.codeassessment.rest;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import ch.qos.logback.classic.Logger;

public class AbstractEndpoint {

	Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	protected Response buildResponse(int statusCode, String errorMessage) {
		WSExceptionObject exceptionObject = new WSExceptionObject();
		exceptionObject.setErrorCode(String.valueOf(statusCode));
		exceptionObject.setErrorDescription(errorMessage);
		
		Response response = Response.status(statusCode)
							.entity(convertToString(exceptionObject))
							.type(MediaType.APPLICATION_JSON)
							.build();
		
		return (response);
	}
	
	private String convertToString(Object container) {
		
		String jsonInString = new String();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JaxbAnnotationModule());
			
			jsonInString = mapper
					.writerWithDefaultPrettyPrinter()
					.writeValueAsString(container);
		} catch (Throwable th) {
			logger.error(th.getMessage(), th);
		}
		
		return jsonInString;
	}
}
