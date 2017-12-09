/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightappnew;

/**
 *
 * @author Stefan
 */
public class BusinessTicket extends StandardTicket {
    private Boolean loungeAccess, priorityBoarding;

    public BusinessTicket(String flightNo, String routeNo, int passengerCount, double price, Boolean loungeAccess, Boolean priorityBoarding) {
        super(flightNo,routeNo, passengerCount, price);
        this.loungeAccess = loungeAccess;
        this.priorityBoarding = priorityBoarding;
    }

    public BusinessTicket() {
        this("","",0,0.0,false,false);
    }

    public Boolean getLoungeAccess() {
        return loungeAccess;
    }

    public void setLoungeAccess(Boolean loungeAccess) {
        this.loungeAccess = loungeAccess;
    }

    public Boolean getPriorityBoarding() {
        return priorityBoarding;
    }

    public void setPriorityBoarding(Boolean priorityBoarding) {
        this.priorityBoarding = priorityBoarding;
    }
    
    @Override
    public String printTicketDetails(){
        return super.printTicketDetails()+"Lounge Access: " + loungeAccess + "\n"
               +"Priority Boarding: " + priorityBoarding + "\n";
    }
    
    
}
