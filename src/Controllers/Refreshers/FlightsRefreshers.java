/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import Controllers.Interfaces.Storage.IStorageGet;
import Controllers.Sorts.ISortFlights;
import Models.Flight;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsRefreshers implements IFlightsRefresher {

    private final IStorageGet ISG;
    private final ISortFlights ISF;

    public FlightsRefreshers(IStorageGet ISG,ISortFlights ISF) {
        this.ISG = ISG;
        this.ISF = ISF;
    }

    @Override
    public Response refreshFlights() {
        // Obtenemos una copia del arrayList de storage original
        ArrayList<Flight> flights = ISG.getCopyFlights();

        if (flights.isEmpty()) {
            return new Response("No flights registered", 404);
        }
        
        ISF.sortFlights(flights);
        ArrayList<Object[]> rows = new ArrayList<>();
        
        for (Flight f : flights) {
            Flight copy = f.copy(); // copia independiente

            rows.add(new Object[]{f.getId(),
                copy.getDepartureLocation().getAirportId(),
                copy.getArrivalLocation().getAirportId(),
                (copy.getScaleLocation() == null ? "-" : copy.getScaleLocation().getAirportId()),
                copy.getDepartureDate(),
                copy.calculateArrivalDate(),
                copy.getPlane().getId(),
                copy.getNumPassengers()});
        }

        return new Response("Flights loaded succesfully", 200, rows);
    }
}
