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
public interface IValidatorDelayFlight {
    public Response validateDelayedTime(String hour, String minute);
}
