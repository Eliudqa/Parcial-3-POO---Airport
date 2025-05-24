/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IControllerFlights;
import Controllers.Validators.IValidatorDelayFlight;
import Models.Flight;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author Admin
 */
public class ControllerFlights implements IControllerFlights {

    private final IValidatorDelayFlight IVDF;

    public ControllerFlights(IValidatorDelayFlight IVDF) {
        this.IVDF = IVDF;
    }

    @Override
    public Response delay(Flight flight, String hours, String minutes) {
        Response response = IVDF.validateDelayedTime(hours, minutes);

        if (response.getStatus()==Status.OK) {
            flight.setDepartureDate(flight.getDepartureDate().
                    plusHours(Integer.parseInt(hours)).
                    plusMinutes(Integer.parseInt(minutes)));
        }
        return response;
    }

}
