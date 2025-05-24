/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Controllers.Registers.IRegisterFlight;
import Controllers.Registers.IRegisterLocation;
import Controllers.Registers.IRegisterPlane;
import Controllers.Registers.IRegisterPassenger;
import Controllers.Registers.IRegisterPassengerInFlight;

/**
 *
 * @author samit
 */

// Interfaz compuesta que contiene las interfaces independientes
public interface IRegister extends IRegisterPassenger, 
        IRegisterPlane, 
        IRegisterLocation, 
        IRegisterFlight,
        IRegisterPassengerInFlight { 
    
}
