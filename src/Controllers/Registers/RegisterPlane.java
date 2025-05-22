/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.IPlaneCreator;
import Controllers.Interfaces.IRegisterPlane;
import Controllers.Validators.IValidatorPlane;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterPlane implements IRegisterPlane {
    
    private final IPlaneCreator planeCreator;
    private IValidatorPlane vp;
    
    // Inyección por constructor
    public RegisterPlane(IPlaneCreator planeCreator, IValidatorPlane vp) {
        this.planeCreator = planeCreator;
        this.vp = vp;
    } 

   
    
    @Override
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline) {
        Response response = vp.validatePlane(id, brand, model, maxCapacity, airline);

        if (response.getStatus() != Status.OK) {
            return response;
        }
        
        planeCreator.createPlane(id, brand, model, maxCapacity, airline);
        //Llamada al metodo que mete al storage
        return response;

    }
}
