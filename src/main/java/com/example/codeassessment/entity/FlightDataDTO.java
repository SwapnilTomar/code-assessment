package com.example.codeassessment.entity;

public class FlightDataDTO {

    private String departureTime;
    private String Destination;
    private String destinationAirportIATA;
    private String flightNo;

    public FlightDataDTO() {
    }
    public FlightDataDTO(String departureTime, String destination, String destinationAirportIATA, String flightNo) {
        this.departureTime = departureTime;
        Destination = destination;
        this.destinationAirportIATA = destinationAirportIATA;
        this.flightNo = flightNo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDestinationAirportIATA() {
        return destinationAirportIATA;
    }

    public void setDestinationAirportIATA(String destinationAirportIATA) {
        this.destinationAirportIATA = destinationAirportIATA;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
}
