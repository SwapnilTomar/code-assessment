package com.example.codeassessment.entity;

import javax.persistence.*;

@Entity
@Table(name="FLIGHT_DATA")
public class FlightData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FLIGHT_DATA_ID")
    private Long flightDataId;
    @Column(name = "DEPARTURE_TIME")
    private String departureTime;
    @Column(name = "DESTINATION")
    private String Destination;
    @Column(name = "DESTINATI_ON_AIRPORT_IATA")
    private String destinationAirportIATA;
    @Column(name = "FLIGHT_NO")
    private String flightNo;
    @Column(name = "SUNDAY")
    private String sunday;
    @Column(name = "MONDAY")
    private String monday;
    @Column(name = "TUESDAY")
    private String tuesday;
    @Column(name = "WEDNESDAY")
    private String wednesday;
    @Column(name = "THURSDAY")
    private String thursday;
    @Column(name = "FRIDAY")
    private String friday;
    @Column(name = "SATURDAY")
    private String saturday;
    public FlightData() {
    }

    public FlightData(String departureTime, String destination, String destinationAirportIATA, String flightNo) {
        this.departureTime = departureTime;
        Destination = destination;
        this.destinationAirportIATA = destinationAirportIATA;
        this.flightNo = flightNo;
    }

    public Long getFlightDataId() {
        return flightDataId;
    }

    public void setFlightDataId(Long flightDataId) {
        this.flightDataId = flightDataId;
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

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

}
