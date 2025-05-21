/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Flight;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsStorage {
    
    // Singleton
    private static FlightsStorage instance;
    
    private ArrayList<Flight> flights;
    
    
    public FlightsStorage() {
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
    
    
    
}
