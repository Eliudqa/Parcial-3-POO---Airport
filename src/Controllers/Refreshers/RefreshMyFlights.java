/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.ISearchStorage;
import Models.Flight;
import Models.Passenger;
import Models.Storage.PassengersStorage;
import core.controllers.utils.Response;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class RefreshMyFlights implements IRefreshMyFlights {
    
    private final ISearchStorage searchStorage;
    
    public RefreshMyFlights(ISearchStorage searchStorage){
        this.searchStorage = searchStorage;
    }
    
    
    @Override
    public Response getMyFlightsRows(Long passengerId) {

        Passenger passenger = searchStorage.getPassenger(passengerId);

        if (passenger == null) {
            return new Response("Passenger not found", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();

        for (Flight flight : passenger.getFlights()) {
                Flight copy = flight.copy(); // copia independiente

            rows.add(new Object[]{
                copy.getId(),
                copy.getDepartureDate(),
                copy.calculateArrivalDate()
            });
        }

        return new Response("Flights loaded successfully", 200, rows);
    }
}
