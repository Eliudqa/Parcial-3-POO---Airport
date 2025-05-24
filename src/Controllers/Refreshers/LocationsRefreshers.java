/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import Controllers.Interfaces.Storage.IStorageGet;
import Controllers.Sorts.ISortLocations;
import Models.Location;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationsRefreshers implements ILocationsRefreshers {
    
    private final IStorageGet ISG;
    private final ISortLocations ISL;

    public LocationsRefreshers(IStorageGet ISG,ISortLocations ISL) {
        this.ISG = ISG;
        this.ISL = ISL;
    }
    
  @Override
  public Response refreshLocations() {
        // Obtenemos una copia del arrayList de storage original
        ArrayList<Location> locations = ISG.getCopyLocations();

        if (locations.isEmpty()) {
            return new Response("No locations registered", 404);
        }
        ISL.sortLocations(locations);
        ArrayList<Object[]> rows = new ArrayList<>();
        
        for (Location l : locations) {
              Location copy = l.copy(); // copia independiente

            rows.add(new Object[]{l.getAirportId(), 
                copy.getAirportName(), 
                copy.getAirportCity(), 
                copy.getAirportCountry()
            });
        }

        return new Response("Locations loaded succesfully", 200, rows);
    } 
}
