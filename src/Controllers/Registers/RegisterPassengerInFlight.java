/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Interfaces.ISearchStorage;
import Controllers.Validators.IValidatorPassengerToFlight;
import Models.Flight;
import Models.Passenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterPassengerInFlight implements IRegisterPassengerInFlight{
    
   private final ISearchStorage searchStorage;
   private final IValidatorPassengerToFlight vptf;
   

    public RegisterPassengerInFlight(ISearchStorage searchStorage,IValidatorPassengerToFlight vptf) {
        this.searchStorage = searchStorage;
        this.vptf = vptf;
    }
   
    @Override
    public Response RegisterPassengerInFlight(String passengerId, String flightId){
        
        Response response = vptf.validatePassenger(passengerId,flightId);
        

        if (response.getStatus()!= Status.OK){
            return response;
        }
        
        Passenger p = searchStorage.getPassenger(Long.parseLong(passengerId));
        Flight f = searchStorage.getFlight(flightId); 
        
        p.addFlight(f);
        f.addPassenger(p);
        
        return response;
        
    }
    
    
    
}
