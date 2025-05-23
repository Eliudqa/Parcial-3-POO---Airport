/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Controllers.Interfaces.Refreshers.IFlightsAvailableRefresher;
import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import Controllers.Interfaces.Refreshers.ILocationAvailableRefresher;
import Controllers.Interfaces.Refreshers.IPlanesRefreshers;
import Controllers.Interfaces.Refreshers.IPassengersRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesAvailableRefreshers;
import Controllers.Interfaces.Refreshers.IRefreshMyFlights;
import Controllers.Interfaces.Refreshers.IUserRefresher;



/**
 *
 * @author HOLA
 */
public interface IRefresher extends IFlightsRefresher, 
        IPlanesRefreshers, 
        ILocationsRefreshers, 
        IPassengersRefreshers, 
        IUserRefresher,
        IFlightsAvailableRefresher,
        IRefreshMyFlights,
        IPlanesAvailableRefreshers,
        ILocationAvailableRefresher {
    
}
