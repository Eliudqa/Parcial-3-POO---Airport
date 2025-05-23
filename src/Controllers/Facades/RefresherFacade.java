/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;

import Controllers.Interfaces.IRefresher;
import Controllers.Interfaces.Refreshers.IFlightsAvailableRefresher;
import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import Controllers.Interfaces.Refreshers.ILocationAvailableRefresher;
import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import Controllers.Interfaces.Refreshers.IPassengersRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesAvailableRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesRefreshers;
import Controllers.Interfaces.Refreshers.IRefreshMyFlights;
import Controllers.Interfaces.Refreshers.IUserRefresher;
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
    private final IPlanesAvailableRefreshers availablePlanesRefresher;
    private final ILocationAvailableRefresher availableLocationsRefresher;
    

    public RefresherFacade(
            IPlanesRefreshers planeRefresher,
            IFlightsRefresher flightRefresher,
            IPassengersRefreshers passengerRefresher,
            ILocationsRefreshers locationRefresher,
            IUserRefresher userRefresher,
            IFlightsAvailableRefresher availableFlightsRefresher,
            IRefreshMyFlights myFlightsRefresher,
            IPlanesAvailableRefreshers availablePlanesRefresher,
            ILocationAvailableRefresher availableLocationsRefresher
    ) {
        this.planeRefresher = planeRefresher;
        this.flightRefresher = flightRefresher;
        this.passengerRefresher = passengerRefresher;
        this.locationRefresher = locationRefresher;
        this.userRefresher = userRefresher;
        this.availableFlightsRefresher = availableFlightsRefresher;
        this.myFlightsRefresher = myFlightsRefresher;
        this.availablePlanesRefresher = availablePlanesRefresher;
        this.availableLocationsRefresher = availableLocationsRefresher;
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
    
    @Override
    public ArrayList<String> refreshAvailablePlanes(){
        return availablePlanesRefresher.refreshAvailablePlanes();
    }
    
    @Override
    public ArrayList<String> refreshAvailableLocations(){
        return availableLocationsRefresher.refreshAvailableLocations();
    }
}
