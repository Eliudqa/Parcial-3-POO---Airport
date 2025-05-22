/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Location;
import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class SearchStorage {
    
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
}
