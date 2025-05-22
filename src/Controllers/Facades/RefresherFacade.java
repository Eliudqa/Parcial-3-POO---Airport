/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;

import Controllers.Interfaces.IRefresher;
import Controllers.Refreshers.IFlightsRefresher;
import Controllers.Refreshers.ILocationsRefreshers;
import Controllers.Refreshers.IPassengersRefreshers;
import Controllers.Refreshers.IPlanesRefreshers;
import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public class RefresherFacade implements IRefresher {

    private final IPlanesRefreshers planeRefresher;
    private final ILocationsRefreshers locationRefresher;
    private final IFlightsRefresher flightRefresher;
    private final IPassengersRefreshers passengerRefresher;

    public RefresherFacade(
        IPlanesRefreshers planeRefresher,
        IFlightsRefresher flightRefresher,
        IPassengersRefreshers passengerRefresher,
        ILocationsRefreshers locationRefresher
    ) {
        this.planeRefresher = planeRefresher;
        this.flightRefresher = flightRefresher;
        this.passengerRefresher = passengerRefresher;
        this.locationRefresher = locationRefresher;
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


}
