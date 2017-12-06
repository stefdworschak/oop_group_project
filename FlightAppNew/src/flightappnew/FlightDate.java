/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightappnew;

import java.io.Serializable;

/**
 *
 * @author x15037835
 */
public class FlightDate implements Serializable {
    
    private int id;
    String routeNo, flightNo, departure, destination, date, weekday, month;

    public FlightDate(int id, String flightNo, String routeNo, String date, String departure, String destination, String weekday, String month) {
        this.id = id;
        this.routeNo = routeNo;
        this.flightNo = flightNo;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.weekday = weekday;
        this.month = month;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }
    
    public FlightDate(){
        this(0,"","","","","","","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    public String printDetails(){
        return id+", "+routeNo+", "+flightNo+", "+departure+", "+destination+", "+date+", "+weekday+", "+month;
    }
    
}
