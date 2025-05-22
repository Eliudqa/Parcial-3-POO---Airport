/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Passenger;
import Models.Storage.PassengersStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PassengersRefresher implements IPassengersRefreshers {
    
    
  @Override
  public Response refreshPassengers() {
        ArrayList<Passenger> passengers = PassengersStorage.getInstance().getPassengers();

        if (passengers.isEmpty()) {
            return new Response("No passengers registered", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();
        for (Passenger p : passengers) {
            rows.add(new Object[]{p.getId(), p.getFullname(), 
                p.getBirthDate(), 
                p.calculateAge(),
                p.generateFullPhone(), 
                p.getCountry(), 
                p.getNumFlights()});
        };
        

        return new Response("Passengers loaded succesfully", 200, rows);
    } 
}
