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
public interface IRegister {

    Response registerPlane(String id, String brand, String model, String maxCapacity, String airline);
    Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country);
    Response registerLocation(String id, String name,String  city,String  country, String latitude, String longitude);
    Response registerFlight(String id, String plane, String departureLocation, String arrivalLocation, String year, int month, int day, int hour,int minute, int hoursDurationArrival, int minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale);
    
}
