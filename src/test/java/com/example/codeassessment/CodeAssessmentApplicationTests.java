package com.example.codeassessment;

import java.io.File;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.assertj.core.api.Assertions;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.codeassessment.controller.DisplayDataController;
import com.example.codeassessment.entity.FlightDataDTO;
import com.google.gson.Gson;

import ch.qos.logback.classic.Logger;

@SpringBootTest
public class CodeAssessmentApplicationTests {

	public CodeAssessmentApplicationTests() {}

	Logger logger = (Logger) LoggerFactory.getLogger(DisplayDataController.class);

	public static final String EXTERNAL_UPLOAD_URL = "D:/temp/flights.csv";
	
	@Test
	public void testUploadData() {

		String endpoint = "http://localhost:8082/upload"; 

		try {
			Client client = ClientBuilder.newClient();
			File file = new File(EXTERNAL_UPLOAD_URL);
			if (file.exists()) {
				logger.info("File Exist => " + file.getName() + " :: " + file.getAbsolutePath());
			}

			FileDataBodyPart filePart = new FileDataBodyPart("file",file);
			FormDataMultiPart multiPart = new FormDataMultiPart();
			multiPart.bodyPart(filePart);

			Response response = client.target(endpoint).register(MultiPartFeature.class)
					.request()
					.post(Entity.entity(multiPart,MediaType.MULTIPART_FORM_DATA_TYPE));

			logger.info("status code: "+response.getStatus());

			Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlightInfo() {
		String date = "10/05/2021";
		String endpoint = "http://localhost:8082/getFlightInfo"; 

		try {

			GenericType<List<FlightDataDTO>> genericType = new GenericType<List<FlightDataDTO>>(){};

			Client client = ClientBuilder.newClient();

			List<FlightDataDTO> flightData = client.target(endpoint)
					.queryParam("inputDate", date)
					.request(MediaType.APPLICATION_JSON_TYPE)
					.get(genericType);

			if( flightData!= null && !flightData.isEmpty()) {
				Gson gson = new Gson();
				String fdd = gson.toJson(flightData);
				logger.info("Flight Data: " + fdd);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
