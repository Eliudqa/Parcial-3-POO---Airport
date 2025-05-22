/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IRegisterFlight {
    
        Response registerFlight(String id, String plane, String departureLocation, String arrivalLocation, String year, int month, int day, int hour,int minute, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale);

}
