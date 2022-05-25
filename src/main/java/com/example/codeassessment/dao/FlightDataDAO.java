package com.example.codeassessment.dao;

import com.example.codeassessment.entity.FlightData;

import java.util.List;

public interface FlightDataDAO {
    List<FlightData> getFlightInfoByDay(String dayToBeSearch);
    void createFlightData(List<FlightData> flightDataList);

}
