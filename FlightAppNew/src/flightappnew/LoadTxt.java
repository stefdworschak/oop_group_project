package flightappnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author x15037835
 */
public class LoadTxt {

        public void runCode(){
            FlightDate flightDate;
            ArrayList<FlightDate> fList = new ArrayList<>();
            String line = null;
            String[] fl = new String[9];
            int c =0;


            try {

            FileReader inputFile = new FileReader("flight_dates.txt");
            BufferedReader bReader = new BufferedReader(inputFile);

            while((line = bReader.readLine()) != null) {

                fl = line.split(",");
                flightDate = new FlightDate((c+1),fl[1],fl[2],fl[3],fl[4],fl[5],fl[6],fl[7]);
                fList.add(flightDate);   
                c++;

            }   

            bReader.close();

            for(int j =0; j < fList.size();j++){
                System.out.println(fList.get(j).printDetails());
            }

            File file = new File("flightDate.DAT");
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(fList);

            } catch(FileNotFoundException e) {

            } catch(IOException ex) {
            }


            //flightDate = new FlightDate();
        }
        
        public void runSimpleCode(){
            FlightDateSimple flightDate;
            ArrayList<FlightDateSimple> fListSimple = new ArrayList<>();
            String line = null;
            String[] fl = new String[7];
            int c =0;


            try {

            FileReader inputFile = new FileReader("flight_dates.txt");
            BufferedReader bReader = new BufferedReader(inputFile);

            while((line = bReader.readLine()) != null) {

                fl = line.split(",");
                flightDate = new FlightDateSimple((c+1),fl[1],fl[2],fl[3],fl[4],fl[5],fl[6]);
                fListSimple.add(flightDate);   
                c++;

            }   

            bReader.close();

            for(int j =0; j < fListSimple.size();j++){
                System.out.println(fListSimple.get(j).printDetails());
            }

            File file = new File("flightDate.DAT");
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(fListSimple);

            } catch(FileNotFoundException e) {

            } catch(IOException ex) {
            }


            //flightDate = new FlightDate();
        }
    
}
