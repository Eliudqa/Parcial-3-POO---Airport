/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Validators;

import core.controllers.utils.Response;

/**
 *
 * @author samit
 */
public interface IValidatorLocation {
    public Response validateLocation(String id, String name, String city, String country, String latitude, String longitude);
}
