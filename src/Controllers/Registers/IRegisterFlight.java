/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Registers;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IRegisterFlight {
    
        Response registerFlight(String id, String plane, String departureLocation, String arrivalLocation, 
                String year, String month, String day, String hour,String minute, 
                String hoursDurationArrival, String minutesDurationArrival,
                String scaleId, String hoursDurationScale, String minutesDurationScale);

}
