/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.DataSavers;

import Models.Flight;
import Models.Storage.FlightsStorage;

/**
 *
 * @author samit
 */
public class SaverFlights implements ISaverFlights{
    
    @Override
    public void addFlight(Flight flight){
        FlightsStorage.getInstance().addFlight(flight);
    }
}
