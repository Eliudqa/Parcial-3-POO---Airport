/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IRegisterPlane {
    
Response registerPlane(String id, String brand, String model, String maxCapacity, String airline);

}
