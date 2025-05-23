/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Creators;

import Models.Passenger;
import java.time.LocalDate;

/**
 *
 * @author HOLA
 */
public class PassengerCreator implements IPassengerCreator {
    
    @Override
    public Passenger createPassenger(String id, String firstName, String lastName,
            String year, String month, String day,
            String phoneCode, String phone, String country) { 
        
            Long idInt = Long.parseLong(id);
            LocalDate BD = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            
        return new Passenger(Integer.parseInt(id), firstName, lastName, BD, Integer.parseInt(phoneCode), Integer.parseInt(phone), country);

    }
}
