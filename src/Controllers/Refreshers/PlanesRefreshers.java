/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Plane;
import Models.Storage.PlanesStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PlanesRefreshers implements IPlanesRefreshers {
    
       
  @Override
  public Response refreshPlanes() {
        ArrayList<Plane> planes = PlanesStorage.getInstance().getPlanes();

        if (planes.isEmpty()) {
            return new Response("No airplanes registered", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();
        for (Plane p : planes) {
            rows.add(new Object[]{
                p.getId(),
                p.getBrand(),
                p.getModel(),
                p.getMaxCapacity(),
                p.getAirline(),
                p.getNumFlights()
            });
        }

        return new Response("Planes loaded succesfully", 200, rows);
    } 
  }
        
