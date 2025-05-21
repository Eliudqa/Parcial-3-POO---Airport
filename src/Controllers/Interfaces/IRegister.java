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
    Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country);
    Response registerPlane();
    Response registerLocation();
    Response registerFlight();
    
}
