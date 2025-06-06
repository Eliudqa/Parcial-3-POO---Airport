/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Validators;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IValidatorPassengerUpdate {
    public Response validatePassenger(String id, String firstName, String lastName, 
            String year, String month, String day,
            String phoneCode, String phone, String country);
}
