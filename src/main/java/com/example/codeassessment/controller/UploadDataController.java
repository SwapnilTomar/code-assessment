package com.example.codeassessment.controller;

import com.example.codeassessment.buisnessObject.FlightDataBOImpl;
import com.example.codeassessment.rest.AbstractEndpoint;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class UploadDataController extends AbstractEndpoint{

	Logger logger = (Logger) LoggerFactory.getLogger(UploadDataController.class);
	
	@Autowired
	public FlightDataBOImpl flightDataBO;

	@PostMapping("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadData(
			@RequestParam("file") MultipartFile file) {
		logger.info("Post request on UploadDataController at : "+new Date());
		
		try {
			
			if(file == null || file.isEmpty()) {
				Response response = buildResponse(Response.Status.BAD_REQUEST.getStatusCode(),"No Data to upload in file.");
				return response;
			}
			
			InputStream inputStream = file.getInputStream();
			CsvParserSettings settings = new CsvParserSettings();
			settings.setHeaderExtractionEnabled(true);
			CsvParser parser = new CsvParser(settings);
			List<Record> recordsList = parser.parseAllRecords(inputStream);

			logger.info("recordsList size to update : "+recordsList.size());
			getFlightDataBO().createFlightData(recordsList);
			
			return Response.status(HttpStatus.OK.value()).build();
		} catch (IOException io) {
			throw new WebApplicationException(io.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
		} catch (Throwable th) {
			throw new WebApplicationException(th.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
		}
	}



	public FlightDataBOImpl getFlightDataBO() {
		return flightDataBO;
	}

	public void setFlightDataBO(FlightDataBOImpl flightDataBO) {
		this.flightDataBO = flightDataBO;
	}
}
