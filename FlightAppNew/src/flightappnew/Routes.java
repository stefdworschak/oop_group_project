/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightappnew;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Stefan
 */
public class Routes {
    private String routeNo, flightNo, ticket_type;
    private int numPassenger;
    private double price,revenue;
    
    private int pilots, crew, boarding, lounge, baggage;
    
    private final double pilotCost=50000.0, crewCost = 25000.0, boardingCost = 25000.0, loungeCost =22000.0,baggageCost = 19000.0;
    
    private double staffCost;
    
    //{"Teams":[{},{}]}
    //{"FligtNo123",["Standard":10,Flex:20,Business:30]}
    
    
    Hashtable<String, Hashtable> flights = new Hashtable<String, Hashtable>();
    
    private String output;
    
    public Routes(){
        output = "";
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getTicketType() {
        return ticket_type;
    }

    public void setTicketType(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public int getNumPassenger() {
        return numPassenger;
    }

    public void setNumPassenger(int numPassenger) {
        this.numPassenger = numPassenger;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void addTicket(){
        
        //Declare & instantiate new temporary Hashtable calles types of type String & Integer
        //This is used to store the incrementing quantities of Standard, Flex and Business Tickets per flight
        //Similar to JSON object: 
        //flights = {"BEPAR12312":[{"Standard Ticket": 10}, {"Flex Ticket": 20}, {"Business Ticket":30}]}
        Hashtable<String, Integer> types = new Hashtable<String, Integer>();
        
        //Check if current flightNo is already in the Hashtable
        if(flights.containsKey(flightNo)){
            //Declare a temp variable to store the incremented value     
            Integer nums = 0;
            //Replace the empty Hastable with the one previously stored in Hashtable flights
            //where the current flightNo is the key
            types = (Hashtable) flights.get(flightNo);

            //if types contains the ticket type already
            if(types.containsKey(ticket_type)) {
                //Get the value from the ticket_type key in the types Hashtable
                //and store it in nums
                nums = (Integer) types.get(ticket_type);
                //To replace the value with the incremented value
                //we need to first remove the key
                types.remove(ticket_type);
                //then put the key back in the types Hashmap
                types.put(ticket_type, nums+numPassenger);
                //then remove the types Hashmap for the current key
                flights.remove(flightNo);
                //And put it back in the flights Hashmap
                flights.put(flightNo, types);
            } else {
                //If the current ticket type is not in the types Hashtable
                //put it in
                /*
                types = (Hashtable)flights.get(flightNo);
                */
                
                types.put(ticket_type, (Integer)numPassenger);
                //And add it to the flights Hashtable
                flights.put(flightNo, types);
            }
        } else {
            //If the flight number is not in the Hashtable yet
            //Add ticket_type and numPassenger to types
            types.put(ticket_type, numPassenger);
            //And add types into flights
            flights.put(flightNo, types);
        
        }       
        
        //Add ticket price to revenue
        revenue += price*numPassenger;
        
    }
    
    public String printDetails(){
        //Declaring and instantiating summary variables
        int numFlights = 0, stTickets =0, fxTickets=0,bsTickets=0;
        //We consider each crew to cover 3 flights as their route
        final int rNum = 3; //Number of flights per route
        //Get the keys which are the flightNumbers from the flights Hashtable
        //And store them as Enumeration
        Enumeration flightNos = flights.keys();
        
        //Loop through the enumerations until there are none left
        while(flightNos.hasMoreElements()){
            
            //Declare and assign the current element to a variable
            //Explicitly cast it as String
            String thisFlight = (String) flightNos.nextElement();
            //Get the types Hashtable for the current flight from the flights Hashtable
            Hashtable newTypes = (Hashtable) flights.get(thisFlight);
            
            stTickets =  newTypes.get("Standard Ticket") == null ? 0 : (int) newTypes.get("Standard Ticket");
            fxTickets =  newTypes.get("Flex Ticket") == null ? 0 : (int) newTypes.get("Flex Ticket");
            bsTickets =  newTypes.get("Business Ticket") == null ? 0 : (int) newTypes.get("Business Ticket");
            System.out.println(thisFlight);
            //captains, crew, boarding, lounge, baggage;
            if((stTickets + fxTickets + bsTickets) > 5 && (stTickets + fxTickets + bsTickets) < 30) {
                
                pilots += 2;
                crew += 2;
                boarding += 1;
                System.out.println(thisFlight+" "+pilots);
            } else if((stTickets + fxTickets + bsTickets) >= 30) {
                pilots += 2;
                crew += 4;
                boarding += 2;
                System.out.println(thisFlight+" "+pilots);
            } else {
                System.out.println((stTickets + fxTickets + bsTickets));
            }
            
            if(fxTickets > 0){
                crew += 2;
                baggage += 2;
            }
            if(bsTickets >0){
                boarding += 2;
                lounge += 2;
            }
            
            
            
            
            //output += thisFlight+" - Standard Tickets: "+stTickets+", Flex Tickets: "+fxTickets+", Business Tickets: "+bsTickets+" sold.\n";
            numFlights++;
            //System.out.println("FlightNo: "+flightNos.nextElement());
           // Hashtable<String, Integer> types = new Hashtable<String, Integer>();
        }
        
        staffCost = (pilots/rNum)*pilotCost+(crew/rNum)*crewCost+(boarding/rNum)*boardingCost+(baggage/rNum)*baggageCost+(lounge/rNum)*loungeCost;
        
        output += "Number of total flights: "+numFlights+"\n\n";
        output += "Planned Staff:\n";
        output += "Pilots: "+Math.round(Math.ceil(pilots/rNum)/2)*2+"\n";
        output += "Cabin Crew: "+(int)Math.ceil(crew/rNum)+"\n";
        output += "Boarding: "+(int)Math.ceil(boarding/rNum)+"\n";
        output += "\nExtra Staff: \n";
        output += "Baggage Handlers: "+(int)Math.ceil(baggage/rNum)+"\n";
        output += "Lounge Staff: "+(int)Math.ceil(lounge/rNum)+"\n";
        output += "\nStaff Costs: €"+staffCost+"\n";
        output += "Revenue: €"+revenue+"\n";
        output += "Net Profit: €"+(revenue-staffCost);
        //output += "\n\nThere are a total of "+numFlights+" flights.";
        return output;
    }
    
}
