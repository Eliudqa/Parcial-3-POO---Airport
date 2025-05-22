/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Flight;
import Models.Storage.FlightsStorage;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class FlightsRefreshers implements IFlightsRefresher  {
    
    
  @Override
  public Response refreshFlights() {
        ArrayList<Flight> flights = FlightsStorage.getInstance().getFlights();

        if (flights.isEmpty()) {
            return new Response("No flights registered", 404);
        }

        ArrayList<Object[]> rows = new ArrayList<>();
        for (Flight f : flights) {
            rows.add(new Object[]{f.getId(), 
                f.getDepartureLocation().getAirportId(), 
                f.getArrivalLocation().getAirportId(), 
                (f.getScaleLocation() == null ? "-" : f.getScaleLocation().getAirportId()), 
                f.getDepartureDate(), 
                mainController.calculateArrivalDate(f), 
                f.getPlane().getId(), f.getNumPassengers()});
        }

        return new Response("Planes loaded succesfully", 200, rows);
    } 
}