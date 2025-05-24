/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author samit
 */
public class ValidatorDelayFlight implements IValidatorDelayFlight {

    @Override
    public Response validateDelayedTime(String hour, String minute) {
        int hourInt, minuteInt;
        try {
            hourInt = Integer.parseInt(hour);
        } catch (NumberFormatException e) {
            return new Response("Please, select an hour", Status.BAD_REQUEST);
        }
        
        try {
            minuteInt = Integer.parseInt(minute);
        } catch (NumberFormatException e) {
            return new Response("Please, select an minute", Status.BAD_REQUEST);
        }
        
        if(hourInt == 0||minuteInt ==0){
            return new Response("Time delayed cannot be 00:00", Status.BAD_REQUEST);
        }
        return new Response("Flight succesfully delayed", Status.OK);
    }
}
