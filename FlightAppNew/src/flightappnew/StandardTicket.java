/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightappnew;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class StandardTicket implements Serializable {
    
    protected String flightNo, routeNo;
    protected int passengerCount;
    protected double price;

    public StandardTicket(String flightNo, String routeNo, int passengerCount, double price) {
        this.flightNo = flightNo;
        this.passengerCount = passengerCount;
        this.price = price;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public StandardTicket() {
        this("","",0,0.0);
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
