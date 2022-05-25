package com.example.codeassessment.buisnessObject;

import com.example.codeassessment.dao.FlightDataDAO;
import com.example.codeassessment.entity.FlightData;
import com.example.codeassessment.entity.FlightDataDTO;
import com.univocity.parsers.common.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightDataBOImpl implements FlightDataBO{
    @Autowired
    private FlightDataDAO flightDataDAO;
    @Override
    public void createFlightData(List<Record> recordsList){
        List<FlightData> flightDataList = new ArrayList<FlightData>();
        recordsList.forEach(record -> {
            FlightData flightData = new FlightData();
            flightData.setDepartureTime(record.getString("Departure Time"));
            flightData.setDestination(record.getString("Destination"));
            flightData.setDestinationAirportIATA(record.getString("Destination Airport IATA"));
            flightData.setFlightNo(record.getString("Flight No"));
            flightData.setMonday(record.getString("Monday"));
            flightData.setTuesday(record.getString("Tuesday"));
            flightData.setWednesday(record.getString("Wednesday"));
            flightData.setThursday(record.getString("Thursday"));
            flightData.setFriday(record.getString("Friday"));
            flightData.setSaturday(record.getString("Saturday"));
            flightDataList.add(flightData);
        });
        getFlightDataDAO().createFlightData(flightDataList);
    }

    @Override
    public List<FlightDataDTO> getFlightInfoByDay(String dayToBeSearch){
        List<FlightDataDTO> flightDataDTOList = new ArrayList<FlightDataDTO>();
        List<FlightData> flightDataList = getFlightDataDAO().getFlightInfoByDay(dayToBeSearch);
        flightDataList.forEach(record ->{
            FlightDataDTO flightDataDTO = new FlightDataDTO(record.getDepartureTime(),record.getDestination(),
                    record.getDestinationAirportIATA(),record.getFlightNo());
            flightDataDTOList.add(flightDataDTO);
        });
        return flightDataDTOList;
    }
    public FlightDataDAO getFlightDataDAO() {
        return flightDataDAO;
    }

    public void setFlightDataDAO(FlightDataDAO flightDataDAO) {
        this.flightDataDAO = flightDataDAO;
    }
}
