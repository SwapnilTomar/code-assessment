package com.example.codeassessment.controller;

import com.example.codeassessment.buisnessObject.FlightDataBOImpl;
import com.example.codeassessment.entity.FlightDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DisplayDataController {

    @Autowired
    public FlightDataBOImpl flightDataBO;

    @GetMapping("/getFlightInfo")
    public List<FlightDataDTO> getFlightInfo(@RequestParam("inputDate") String inputDate) throws Exception {

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format1.parse(inputDate);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String dayWeekText = format2.format(date);
        return getFlightDataBO() .getFlightInfoByDay(dayWeekText.toLowerCase());
    }
    public FlightDataBOImpl getFlightDataBO() {
        return flightDataBO;
    }

    public void setFlightDataBO(FlightDataBOImpl flightDataBO) {
        this.flightDataBO = flightDataBO;
    }
}
