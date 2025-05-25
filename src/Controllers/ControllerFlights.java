/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.ISearchStorage;
import Controllers.Validators.IValidatorDelayFlight;
import Models.Flight;
import ObserverPattern.IObservableNotifyStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author Admin
 */
public class ControllerFlights implements IControllerFlights {

    private final IValidatorDelayFlight IVDF;
    private final ISearchStorage ISS;
    private final IObservableNotifyStorage notifier;


    public ControllerFlights(IValidatorDelayFlight IVDF, ISearchStorage ISS,IObservableNotifyStorage notifier) {
        this.IVDF = IVDF;
        this.ISS = ISS;
        this.notifier = notifier;
    }



    @Override
    public Response delay(String flightId, String hours, String minutes) {
        Response response = IVDF.validateDelayedTime(flightId, hours, minutes);

        Flight flight = ISS.getFlight(flightId);
        
        
        if (response.getStatus()==Status.OK) {
            flight.setDepartureDate(flight.getDepartureDate().
                    plusHours(Integer.parseInt(hours)).
                    plusMinutes(Integer.parseInt(minutes)));
                    notifier.notifyObservers();

        }
        return response;
    }

}
