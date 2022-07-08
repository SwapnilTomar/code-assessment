package com.example.codeassessment.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "Error")
public class WSExceptionObject {
	
	private String errorCode;
	private String errorDescription;
	
	
	@XmlElement(name= "ErrorCode")
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@XmlElement(name= "ErrorDescription")
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	
	
	
	

}
