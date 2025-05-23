/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Flight;
import Models.Storage.FlightsStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsRefreshers implements IFlightsRefresher {

    private final IStorageGet ISG;

    public FlightsRefreshers(IStorageGet ISG) {
        this.ISG = ISG;
    }

    @Override
    public Response refreshFlights() {
        ArrayList<Flight> flights = ISG.getFlights();

        if (flights.isEmpty()) {
            return new Response("No flights registered", 404);
        }

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

        return new Response("Planes loaded succesfully", 200, rows);
    }
}
