/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IPassengersRefreshers;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Passenger;
import Models.Storage.PassengersStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PassengersRefresher implements IPassengersRefreshers {
    
    private final IStorageGet ISG;

    public PassengersRefresher(IStorageGet ISG) {
        this.ISG = ISG;
    }
    
  @Override
  public Response refreshPassengers() {
        ArrayList<Passenger> passengers = ISG.getPassengers();

        if (passengers.isEmpty()) {
            return new Response("No passengers registered", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();
        
        for (Passenger p : passengers) {
            Passenger copy = p.copy(); // copia independiente (Patron prototype)

            rows.add(new Object[]{p.getId(), p.getFullname(), 
                copy.getBirthDate(), 
                copy.calculateAge(),
                copy.generateFullPhone(), 
                copy.getCountry(), 
                copy.getNumFlights()});
        };
        

        return new Response("Passengers loaded succesfully", 200, rows);
    } 
}
