/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.ILocationAvailableRefresher;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Location;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationAvailableRefresher implements ILocationAvailableRefresher {
    
    private final IStorageGet ISG;

    public LocationAvailableRefresher(IStorageGet ISG) {
        this.ISG = ISG;
    }
    
    @Override
    public ArrayList<String> refreshAvailableLocations(){
        ArrayList<Location> locations = ISG.getLocations();
        ArrayList<String> ids = new ArrayList<>();

        
        for (Location l : locations) {
             Location copy = l.copy(); // copia independiente

            ids.add(copy.getAirportId()+"");
        }
        
        return ids;
        
      } 
    
}
