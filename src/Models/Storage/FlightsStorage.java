/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddFlight;
import Controllers.Interfaces.Storage.IStorageGetFlights;
import Models.Flight;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsStorage implements IStorageAddFlight, IStorageGetFlights {
    
    // Singleton
    private static FlightsStorage instance;
    
    //ArrayList
    private ArrayList<Flight> flights;
    
    
    private FlightsStorage() {
        flights = new ArrayList<>();
    }

    public static FlightsStorage getInstance() {
        if (instance == null) {
            instance = new FlightsStorage();
        }
        return instance;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
    
    @Override
    public void addFlight(Flight flight){
        this.flights.add(flight);
    }
    
    
    
    
}
