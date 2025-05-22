/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.ILocationCreator;
import Controllers.DataSavers.ISaverLocations;
import Controllers.Validators.IValidatorLocation;
import Models.Location;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterLocation implements IRegisterLocation {
    
    private final ILocationCreator locationCreator;
    private final IValidatorLocation vl;
    private final ISaverLocations sl;
    
    // Inyección por constructor
    public RegisterLocation(ILocationCreator locationCreator, IValidatorLocation vl, ISaverLocations sl) {
        this.locationCreator = locationCreator;
        this.vl=vl;
        this.sl=sl;
    }  



    
    
    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        Response response = vl.validateLocation(id, name, city, country, latitude, longitude);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        Location location = locationCreator.createLocation(id, name, city, country, latitude, longitude);
        sl.addLocation(location);
        return response;
    }

}
