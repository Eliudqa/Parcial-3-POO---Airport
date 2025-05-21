/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;

/**
 *
 * @author samit
 */
public interface IRegister {
    Response registerPassenger();
    Response registerPlane();
    Response registerLocation();
    Response registerFlight();
    
}
