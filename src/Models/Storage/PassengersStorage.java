/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PassengersStorage {
    
    // Singleton
    private static PassengersStorage instance;
    
    //ArrayList
    private ArrayList<Passenger> passengers;
    
    
    public PassengersStorage() {
        passengers = new ArrayList<>();
    }

    public static PassengersStorage getInstance() {
        if (instance == null) {
            instance = new PassengersStorage();
        }
        return instance;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    
    
    
    
    
}
