/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Interfaces.IRegisterFlight;
import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public class RegisterFlight implements IRegisterFlight {

    @Override
    public Response registerFlight(String id, String plane, String departureLocation, String arrivalLocation, String year, int month, int day, int hour, int minute, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
System.out.println("Por hacer");
        return null;    }
    
}
