package com.example.codeassessment.controller;

import com.example.codeassessment.buisnessObject.FlightDataBOImpl;
import com.example.codeassessment.entity.FlightDataDTO;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class DisplayDataController {

	Logger logger = (Logger) LoggerFactory.getLogger(DisplayDataController.class);

	@Autowired
	public FlightDataBOImpl flightDataBO;
    
	@GetMapping("/getFlightInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDataDTO> getFlightInfo(
			@RequestParam("inputDate") String inputDate){
		
		logger.info("Get request on DisplayDataController for inputDate : "+inputDate+ ", at : "+new Date());
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format1.parse(inputDate);
			DateFormat format2 = new SimpleDateFormat("EEEE");
			String dayOfWeek = format2.format(date).toLowerCase();
			logger.info("Going to reterive flight data, for inputDate value : "+inputDate);
			return getFlightDataBO().getFlightInfoByDay(dayOfWeek);
		} catch(Exception ex){
			logger.error(ex.getMessage());
			throw new WebApplicationException(ex.getMessage(), Response.Status.BAD_REQUEST);
		} 
		
	}



	public FlightDataBOImpl getFlightDataBO() {
		return flightDataBO;
	}

	public void setFlightDataBO(FlightDataBOImpl flightDataBO) {
		this.flightDataBO = flightDataBO;
	}
}
