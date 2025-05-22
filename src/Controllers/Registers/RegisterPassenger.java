/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.IPassengerCreator;
import Controllers.DataSavers.ISaverPassengers;
import Controllers.Interfaces.IRegisterPassenger;
import Controllers.Validators.IValidatorPassenger;
import Models.Passenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterPassenger implements IRegisterPassenger {
    
    private final IPassengerCreator passengerCreator;
    private final IValidatorPassenger vp;
    private final ISaverPassengers sp;
    
    // Inyección por constructor
    public RegisterPassenger(IPassengerCreator passengerCreator, IValidatorPassenger vp, ISaverPassengers sp) {
        this.passengerCreator = passengerCreator;
        this.vp = vp;
        this.sp=sp;
    } 

     
    
    @Override
    public Response registerPassenger(String id, String firstName, String lastName, 
            String year, int month, int day, 
            String phoneCode, String phone, String country) {

        Response response = vp.validatePassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        Passenger passenger = passengerCreator.createPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
        sp.addPassenger(passenger);
        return response;
    }
}
