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
            String year, int month, int day,
            String phoneCode, String phone, String country) { 
        
            LocalDate BD = LocalDate.of(Integer.parseInt(year), month, day);
            
        return new Passenger(Integer.parseInt(id), firstName, lastName, BD, Integer.parseInt(phoneCode), Integer.parseInt(phone), country);

    }
}
