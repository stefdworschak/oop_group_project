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
public class FlightAppNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare and instantiate FlightsGUI class
        FlightsGUI gui = new FlightsGUI();
        //Set gui to visible
        gui.setVisible(true);
        //Set window to not be resizable
        gui.setResizable(false);
        //Give GUI a title
        gui.setTitle("Book flights");
        
        //Instantiable class that converts flightDates text to DAT file
        //LoadTxt load = new LoadTxt();
        //load.runCode();
        
    }
    
}
