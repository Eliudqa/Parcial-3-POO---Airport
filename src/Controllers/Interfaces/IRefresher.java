/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Controllers.Refreshers.ILocationsRefreshers;
import Controllers.Refreshers.IFlightsRefresher;
import Controllers.Refreshers.IPlanesRefreshers;
import Controllers.Refreshers.IPassengersRefreshers;



/**
 *
 * @author HOLA
 */
public interface IRefresher extends IFlightsRefresher, IPlanesRefreshers, ILocationsRefreshers, IPassengersRefreshers {
    
}
