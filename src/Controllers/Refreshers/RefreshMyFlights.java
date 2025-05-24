/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IRefreshMyFlights;
import Controllers.Interfaces.ISearchStorage;
import Controllers.Sorts.ISortMyFlights;
import Models.Flight;
import Models.Passenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class RefreshMyFlights implements IRefreshMyFlights {

    private final ISearchStorage searchStorage;
    private final ISortMyFlights ISMF;

    public RefreshMyFlights(ISearchStorage searchStorage, ISortMyFlights ISMF) {
        this.searchStorage = searchStorage;
        this.ISMF = ISMF;
    }

    @Override
    public Response getMyFlightsRows(String passengerIdStr) {
        Long passengerId;
        try{
             passengerId = Long.parseLong(passengerIdStr);
        }catch(NumberFormatException e){
            return new Response("Please, select an user first", Status.BAD_REQUEST);
        }
        
        Passenger passenger = searchStorage.getPassenger(passengerId);

        if (passenger == null) {
            return new Response("Passenger not found", Status.NOT_FOUND);
        }

        if (passenger.getNumFlights() == 0) {
            return new Response("Lista Vacia", Status.NO_CONTENT);

        }

        ArrayList<Object[]> rows = new ArrayList<>();
        
        // Obtengo una copia de la lista de los vuelos en pasajeros
        ArrayList<Flight> flights = passenger.getCopyFlights();
        ISMF.sortMyFlights(flights);
        for (Flight flight : flights) {

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
