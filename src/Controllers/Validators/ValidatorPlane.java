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
 * @author samit
 */

//Es abstracta para no violar DIP y que las clases que utilicen sus metodos no dependan de una clase concreta
public class ValidatorPlane implements IValidatorPlane {

    private final ISearchStorage searchStorage;
    
    public ValidatorPlane(ISearchStorage searchStorage){
        this.searchStorage = searchStorage;
    }
    
    
    @Override
    public Response validatePlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            int maxCapacityInt;

            if (id.equals("")) {
                return new Response("Id must not be empty", Status.BAD_REQUEST);
            }

            if (id.length() != 7) {
                return new Response("Id must have 7 characters", Status.BAD_REQUEST);
            }
            
            //Se verifica que el id no exista
            if (searchStorage.getPlane(id)!=null) {
                return new Response("There is already a plane with that id", Status.CONFLICT);
            }

            // Verificamos que los dos primeros caracteres sean mayúsculas
            if (!Character.isUpperCase(id.charAt(0))) {
                return new Response("The first character of Id must be capital", Status.BAD_REQUEST);
            }
            if (!Character.isUpperCase(id.charAt(1))) {
                return new Response("The second character of Id must be capital", Status.BAD_REQUEST);
            }

            // Verificamos que los caracteres de la posición 3 a 7 sean dígitos
            for (int i = 2; i < 7; i++) { // i debe ir de 2 a 6
                if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
                    return new Response("The character at position " + (i + 1) + " must be a digit", Status.BAD_REQUEST);
                }
            }

            try {
                maxCapacityInt = Integer.parseInt(maxCapacity);
            } catch (NumberFormatException e) {
                return new Response("maxCapacity must be a number", Status.BAD_REQUEST);
            }

            if (maxCapacityInt <= 0) {
                return new Response("maxCapacity must be a positive number", Status.BAD_REQUEST);
            }

            if (brand.equals("")) {
                return new Response("Brand must be not empty", Status.BAD_REQUEST);
            }

            if (model.equals("")) {
                return new Response("Model must be not empty", Status.BAD_REQUEST);
            }

            if (maxCapacity.equals("")) {
                return new Response("maxCapacity must be not empty", Status.BAD_REQUEST);
            }
            if (airline.equals("")) {
                return new Response("Airline must be not empty", Status.BAD_REQUEST);
            }
            
            
            return new Response("Plane registered succesfully", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
