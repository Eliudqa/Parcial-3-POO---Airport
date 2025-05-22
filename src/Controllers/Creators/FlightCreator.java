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
public abstract class FlightCreator {
    
    public static Flight CreateFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation, String year,
            int month, int day, int hour, int minutes, String hoursDurationArrival,
            String minutesDurationArrival, Location scaleLocation,
            int hoursDurationScale, int minutesDurationScale){
        
                Flight flight;
                LocalDateTime departureDate = LocalDateTime.of(Integer.parseInt(year), month, day, hour, minutes);


        if (scaleLocation==null) {
             flight = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival), hoursDurationScale, minutesDurationScale);
        } else {
             flight = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival));
        }
        plane.addFlight(flight); 
        return flight;

    }
    
}
