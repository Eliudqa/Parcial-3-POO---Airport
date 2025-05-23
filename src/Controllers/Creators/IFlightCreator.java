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
    public Flight CreateFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation,
            String year,  String month, String day, String hour, String minutes,
            String hoursDurationArrival, String minutesDurationArrival,
            Location scaleLocation,  String hoursDurationScale, String minutesDurationScale);
}
