/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Location;
import Models.Storage.LocationsStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationsRefreshers implements ILocationsRefreshers {
    
  @Override
  public Response refreshLocations() {
        ArrayList<Location> locations = LocationsStorage.getInstance().getLocations();

        if (locations.isEmpty()) {
            return new Response("No locations registered", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();
        for (Location l : locations) {
            rows.add(new Object[]{l.getAirportId(), 
                l.getAirportName(), 
                l.getAirportCity(), 
                l.getAirportCountry()
            });
        }

        return new Response("Locations loaded succesfully", 200, rows);
    } 
}
