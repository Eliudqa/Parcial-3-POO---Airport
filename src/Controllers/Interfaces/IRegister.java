/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;
import java.time.LocalDate;

/**
 *
 * @author samit
 */
public interface IRegister {
    Response registerPassenger(int id, String firstName, String LastName, LocalDate BD, int phoneCode, int phone, String country);
    Response registerPlane();
    Response registerLocation();
    Response registerFlight();
    
}
