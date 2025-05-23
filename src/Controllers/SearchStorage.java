/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.ISearchStorage;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */

//Es abstracta para no violar DIP y que las clases que utilicen sus metodos no dependan de una clase concreta
public class SearchStorage implements ISearchStorage {
    
    private final IStorageGet ISG;

    public SearchStorage(IStorageGet ISG) {
        this.ISG = ISG;
    }
    
    
    
     @Override
     public Plane getPlane(String idPlane){
        
        ArrayList<Plane> planes = ISG.getPlanes();
        
        for(Plane plane : planes){
            if(idPlane.equals(plane.getId())){
                return plane;
            }
        }
        
        return null;
    }
    
    
     @Override
    public Location getLocation(String AirportId){
        
        ArrayList<Location> locations = ISG.getLocations();
        
        for(Location location : locations){
            if(AirportId.equals(location.getAirportId())){
                return location;
            }
        }
        
        return null;
    }
    
    
     @Override
    public Passenger getPassenger(Long passengerId){
        
        ArrayList<Passenger> passengers = ISG.getPassengers();
        
        for(Passenger p : passengers){
            if(passengerId ==p.getId()){
                return p;
            }
        }
        
        return null;
        
    }
    
    
     @Override
    public Flight getFlight(String flightId){
        
        ArrayList<Flight> flights = ISG.getFlights();
        
        for(Flight flight : flights){
            if(flightId.equals(flight.getId())){
                return flight;
            }
        }
        
        return null;
        
    }
}
