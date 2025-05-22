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
public interface IValidatorPlane {
    Response validatePlane(String id, String brand, String model, String maxCapacity, String airline) ;
}
