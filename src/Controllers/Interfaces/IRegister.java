/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Models.Location;
import Models.Plane;
import core.controllers.utils.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author samit
 */

// Interfaz compuesta que contiene las interfaces independientes
public interface IRegister extends IRegisterPassenger, IRegisterPlane, IRegisterLocation, IRegisterFlight  { 
    
}
