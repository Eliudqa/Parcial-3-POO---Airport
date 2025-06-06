/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Controllers.Interfaces.ISearchStorage;
import Models.Flight;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author samit
 */
public class ValidatorDelayFlight implements IValidatorDelayFlight {

    private final ISearchStorage ISS;

    public ValidatorDelayFlight(ISearchStorage ISS) {
        this.ISS = ISS;
    }
    
    
    
    @Override
    public Response validateDelayedTime(String id,String hour, String minute) {
        int hourInt, minuteInt;
        
        
        if(ISS.getFlight(id) == null){
            return new Response("Please, select a flight", Status.BAD_REQUEST);
        }
        
        try {
            hourInt = Integer.parseInt(hour);
        } catch (NumberFormatException e) {
            return new Response("Please, select an hour", Status.BAD_REQUEST);
        }
        
        try {
            minuteInt = Integer.parseInt(minute);
        } catch (NumberFormatException e) {
            return new Response("Please, select a minute", Status.BAD_REQUEST);
        }
        
        if(hourInt == 0&&minuteInt ==0){
            return new Response("Time delayed cannot be 00:00", Status.BAD_REQUEST);
        }
        return new Response("Flight succesfully delayed", Status.OK);
    }
}
