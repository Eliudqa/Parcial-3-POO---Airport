/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.LocationCreator;
import Controllers.Interfaces.IRegisterLocation;
import Controllers.Validators.IValidatorLocation;
import Controllers.Validators.ValidatorLocation;
import Models.Location;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterLocation implements IRegisterLocation {

    private IValidatorLocation vl= new ValidatorLocation();
    
    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        Response response = vl.validateLocation(id, name, city, country, latitude, longitude);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        LocationCreator.createLocation(id, name, city, country, latitude, longitude);
        //Llamada al metodo que mete al storage
        return response;
    }

}
