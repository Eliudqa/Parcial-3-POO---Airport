/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface ISearchStorage {

    public Plane getPlane(String idPlane);

    public Location getLocation(String AirportId);

    public Passenger getPassenger(Long passengerId);

    public Flight getFlight(String flightId);


}
