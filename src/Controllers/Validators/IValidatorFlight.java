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
    public Response validateFlight(String id, String planeId, String departureLocationId, String arrivalLocationId,
            String year, String month, String day, String hour, String minutes,
            String hoursDurationArrival, String minutesDurationArrival,
            String scaleId, String hoursDurationScale, String minutesDurationScale);
}
