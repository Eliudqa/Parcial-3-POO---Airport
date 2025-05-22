/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import Models.Storage.PassengersStorage;
import Models.Storage.PlanesStorage;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */

//Es abstracta para no violar DIP y que las clases que utilicen sus metodos no dependan de una clase concreta
public abstract class SearchStorage {
    
    
     public static Plane getPlane(String idPlane){
        
        ArrayList<Plane> planes = PlanesStorage.getInstance().getPlanes();
        
        for(Plane plane : planes){
            if(idPlane.equals(plane.getId())){
                return plane;
            }
        }
        
        return null;
    }
    
    
    public static Location getLocation(String AirportId){
        
        ArrayList<Location> locations = LocationsStorage.getInstance().getLocations();
        
        for(Location location : locations){
            if(AirportId.equals(location.getAirportId())){
                return location;
            }
        }
        
        return null;
    }
    
    
    public static Passenger getPassenger(int passengerId){
        
        ArrayList<Passenger> passengers = PassengersStorage.getInstance().getPassengers();
        
        for(Passenger p : passengers){
            if(passengerId ==p.getId()){
                return p;
            }
        }
        
        return null;
        
    }
    
    
    public static Flight getFlight(String flightId){
        
        ArrayList<Flight> flights = FlightsStorage.getInstance().getFlights();
        
        for(Flight flight : flights){
            if(flightId.equals(flight.getId())){
                return flight;
            }
        }
        
        return null;
        
    }
}
