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
public class FlexTicket extends StandardTicket {
    
    private Boolean inFligthMeal, baggageAllowance; 

    public FlexTicket(String flightNo, String routeNo, int passengerCount, double price, Boolean inFligthMeal, Boolean baggageAllowance) {
        super(flightNo, routeNo, passengerCount, price);
        this.inFligthMeal = inFligthMeal;
        this.baggageAllowance = baggageAllowance;
    }

    public FlexTicket() {
        this("","",0,0.0,false,false);
    }

    public Boolean getInFligthMeal() {
        return inFligthMeal;
    }

    public void setInFligthMeal(Boolean inFligthMeal) {
        this.inFligthMeal = inFligthMeal;
    }

    public Boolean getBaggageAllowance() {
        return baggageAllowance;
    }

    public void setBaggageAllowance(Boolean baggageAllowance) {
        this.baggageAllowance = baggageAllowance;
    }   
    
    @Override
    public String printTicketDetails(){
        return super.printTicketDetails()+"In-Flight Meal: " + inFligthMeal + "\n"
               +"Baggage Allowance: " + baggageAllowance + "\n";
    }
    
}
