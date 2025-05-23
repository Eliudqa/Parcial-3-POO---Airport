/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Creators;

import Models.Flight;
import Models.Location;
import Models.Plane;
import java.time.LocalDateTime;

/**
 *
 * @author HOLA
 */
public class FlightCreator implements IFlightCreator {
    
    @Override
    public Flight CreateFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation, 
            String year, String month, String day, String hour, String minutes, 
            String hoursDurationArrival, String minutesDurationArrival, 
            Location scaleLocation, String hoursDurationScale, String minutesDurationScale){
        
                Flight flight;
                LocalDateTime departureDate = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), 
                        Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minutes));


        if (scaleLocation==null) {
             flight = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, 
                     departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival), 
                     Integer.parseInt(hoursDurationScale), Integer.parseInt(minutesDurationScale));
        } else {
             flight = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival));
        }
        plane.addFlight(flight); 
        return flight;

    }
    
}
