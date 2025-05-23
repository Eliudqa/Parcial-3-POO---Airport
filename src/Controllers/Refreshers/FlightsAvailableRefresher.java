/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Flight;
import Models.Storage.FlightsStorage;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsAvailableRefresher implements IFlightsAvailableRefresher  {
    
    @Override
    public ArrayList<String> refreshAvailableFlights(){
        ArrayList<Flight> flights = FlightsStorage.getInstance().getFlights();
        ArrayList<String> ids = new ArrayList<>();

        
        for (Flight f : flights) {
             Flight copy = f.copy(); // copia independiente

            ids.add(copy.getId()+"");
        }
        
        return ids;
        
      } 
}
