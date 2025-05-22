/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.IPassengerCreator;
import Controllers.Creators.PassengerCreator;
import Controllers.Interfaces.IRegisterPassenger;
import Controllers.Validators.ValidatorPassenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterPassenger implements IRegisterPassenger {
    
    private final IPassengerCreator passengerCreator;
    
    // Inyección por constructor
    public RegisterPassenger(IPassengerCreator passengerCreator) {
        this.passengerCreator = passengerCreator;
    } 

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, 
            String year, int month, int day, 
            String phoneCode, String phone, String country) {

        Response response = ValidatorPassenger.validatePassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        passengerCreator.createPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
        //Llamada al metodo que mete al storage
        return response;
    }
}
