/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Creators;

import Models.Flight;
import Models.Location;
import Models.Plane;

/**
 *
 * @author HOLA
 */
public interface IFlightCreator {
    public Flight CreateFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation, String year,
            int month, int day, int hour, int minutes, String hoursDurationArrival,
            String minutesDurationArrival, Location scaleLocation,
            int hoursDurationScale, int minutesDurationScale);
}
