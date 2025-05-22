/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Interfaces.IRegisterPlane;
import Controllers.Validators.ValidatorPlane;
import Models.Plane;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterPlane implements IRegisterPlane {

    @Override
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline) {
        Response response = ValidatorPlane.validatePlane(id, brand, model, maxCapacity, airline);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        Plane plane = new Plane(id, brand, model, Integer.parseInt(maxCapacity), airline);
        //Llamada al metodo que mete al storage
        return response;

    }
}
