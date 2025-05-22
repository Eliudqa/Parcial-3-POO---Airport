/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.ILocationCreator;
import Controllers.Interfaces.IRegisterLocation;
import Controllers.Validators.IValidatorLocation;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterLocation implements IRegisterLocation {
    
    private final ILocationCreator locationCreator;
    private final IValidatorLocation vl;
    
    // Inyección por constructor
    public RegisterLocation(ILocationCreator locationCreator, IValidatorLocation vl) {
        this.locationCreator = locationCreator;
        this.vl=vl;
    }  



    
    
    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        Response response = vl.validateLocation(id, name, city, country, latitude, longitude);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        locationCreator.createLocation(id, name, city, country, latitude, longitude);
        //Llamada al metodo que mete al storage
        return response;
    }

}
