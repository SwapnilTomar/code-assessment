package com.example.codeassessment.buisnessObject;

import com.example.codeassessment.entity.FlightDataDTO;
import com.univocity.parsers.common.record.Record;

import java.util.List;

public interface FlightDataBO {
    void createFlightData(List<Record> recordsList);
    List<FlightDataDTO> getFlightInfoByDay(String dayToBeSearch);
}
