package com.example.codeassessment.controller;

import com.example.codeassessment.buisnessObject.FlightDataBOImpl;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
public class UploadDataController {

    @Autowired
    public FlightDataBOImpl flightDataBO;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(settings);
        List<Record> recordsList = parser.parseAllRecords(inputStream);
        getFlightDataBO().createFlightData(recordsList);
        return  "Upload Successfull !!!!!";
    }

    public FlightDataBOImpl getFlightDataBO() {
        return flightDataBO;
    }

    public void setFlightDataBO(FlightDataBOImpl flightDataBO) {
        this.flightDataBO = flightDataBO;
    }
}
