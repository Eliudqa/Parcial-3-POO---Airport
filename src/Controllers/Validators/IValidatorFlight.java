/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Validators;

import core.controllers.utils.Response;

/**
 *
 * @author samit
 */
public interface IValidatorFlight {
    public Response validateFlight(String id, String planeId, String departureLocationId
            , String arrivalLocationId, String year, int month, int day, int hour, int minutes,
            String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale);
}
