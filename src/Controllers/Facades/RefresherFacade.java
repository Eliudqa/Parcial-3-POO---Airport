/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;

import Controllers.Interfaces.IRefresher;
import Controllers.Refreshers.IFlightsAvailableRefresher;
import Controllers.Refreshers.IFlightsRefresher;
import Controllers.Refreshers.ILocationsRefreshers;
import Controllers.Refreshers.IPassengersRefreshers;
import Controllers.Refreshers.IPlanesRefreshers;
import Controllers.Refreshers.IRefreshMyFlights;
import Controllers.Refreshers.IUserRefresher;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class RefresherFacade implements IRefresher {

    private final IPlanesRefreshers planeRefresher;
    private final ILocationsRefreshers locationRefresher;
    private final IFlightsRefresher flightRefresher;
    private final IPassengersRefreshers passengerRefresher;
    private final IUserRefresher userRefresher;
    private final IFlightsAvailableRefresher availableFlightsRefresher;
    private final IRefreshMyFlights myFlightsRefresher;
    

    public RefresherFacade(
            IPlanesRefreshers planeRefresher,
            IFlightsRefresher flightRefresher,
            IPassengersRefreshers passengerRefresher,
            ILocationsRefreshers locationRefresher,
            IUserRefresher userRefresher,
            IFlightsAvailableRefresher availableFlightsRefresher,
            IRefreshMyFlights myFlightsRefresher
    ) {
        this.planeRefresher = planeRefresher;
        this.flightRefresher = flightRefresher;
        this.passengerRefresher = passengerRefresher;
        this.locationRefresher = locationRefresher;
        this.userRefresher = userRefresher;
        this.availableFlightsRefresher = availableFlightsRefresher;
        this.myFlightsRefresher = myFlightsRefresher;
    }

    @Override
    public Response refreshPlanes() {
        return planeRefresher.refreshPlanes();
    }

    @Override
    public Response refreshFlights() {
        return flightRefresher.refreshFlights();
    }

    @Override
    public Response refreshPassengers() {
        return passengerRefresher.refreshPassengers();
    }

    @Override
    public Response refreshLocations() {
        return locationRefresher.refreshLocations();
    }

    @Override
    public ArrayList<String> refreshUser() {
        return userRefresher.refreshUser();

    }

    @Override
    public ArrayList<String> refreshAvailableFlights() {
        return availableFlightsRefresher.refreshAvailableFlights();
    }
    
    @Override
    public Response getMyFlightsRows(Long passengerId){
        return myFlightsRefresher.getMyFlightsRows(passengerId);
    }
}
