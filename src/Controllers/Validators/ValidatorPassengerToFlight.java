/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Controllers.Interfaces.ISearchStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class ValidatorPassengerToFlight implements IValidatorPassengerToFlight {
private final ISearchStorage searchStorage;
   

    public ValidatorPassengerToFlight(ISearchStorage searchStorage) {
        this.searchStorage = searchStorage;
    }
    
    @Override
    public Response validatePassenger(String passengerId, String flightId) {

        try {

            if (passengerId.equals("")) {
                return new Response("The passenger id must not be empty, please select an user", Status.BAD_REQUEST);
            }

            if (flightId.equals("Flight")) {
                return new Response("The flight id must not be empty, please select a flight", Status.BAD_REQUEST);
            }           
            

            if (searchStorage.getFlight(flightId)== null){
                return new Response("The flight does not exist", Status.BAD_REQUEST);
            }
            
            return new Response("Passenger succesfully added to flight ", Status.OK); 
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);

        }

    }
}
