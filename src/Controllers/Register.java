/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IRegister;
import Models.Passenger;
import Models.Storage.PassengersStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author samit
 */

//Clase encargada de registrar/crear los objetos en las pestañas de registration
public class Register implements IRegister {

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country) {
        try {
            long idInt, phoneInt;
            LocalDate BD;
            int phoneCodeInt, yearInt;
            
            try {
                //Se verifica que el id sea valido
                idInt = Integer.parseInt(id);
                if (idInt < 0) {
                    return new Response("Id must be positive", Status.BAD_REQUEST);
                } else if (idInt > Math.pow(10, 16) - 1) {
                    return new Response("Id must have at most 15 digits", Status.BAD_REQUEST);
                }

                for (Passenger passenger : PassengersStorage.getInstance().getPassengers()) {
                    if (idInt == passenger.getId()) {
                        return new Response("There is already a passenger with that id", Status.CONFLICT);
                    }
                }

            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }

            
            //Se verifica que los cambos de los nombres no esten vacios
            if (firstName.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }

            if (lastName.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }

            try {
                
                //Primero se verifica que el año sea positivo, despues se verifica que se pueda comvertir la fecha
                yearInt = Integer.parseInt(year);
                if (yearInt < 0) {
                    return new Response("Year must be positive", Status.BAD_REQUEST);
                }
                //(No se especifica que error hay en la fecha, solo que es invalida)
                try {
                    BD = LocalDate.of(yearInt, month, day);
                } catch (DateTimeException e) {
                    return new Response("Enter a valid date", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Year must be numeric", Status.BAD_REQUEST);
            }

            
            //Se verifica el codigo telefonico
            try {
                phoneCodeInt = Integer.parseInt(phoneCode);
                if (phoneCodeInt < 0) {
                    return new Response("Phone Code must be positive", Status.BAD_REQUEST);
                } else if (phoneCodeInt > 999) {
                    return new Response("Phone code must have at most 3 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone Code must be numeric", Status.BAD_REQUEST);
            }
            
            
            //Se verifica que el numero sea valido
            try {
                phoneInt = Integer.parseInt(phone);
                if (phoneInt < 0) {
                    return new Response("Phone must be positive", Status.BAD_REQUEST);
                } else if (phoneInt > Math.pow(10, 12) - 1) {
                    return new Response("Phone must have at most 3 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            
            
            //Se puede proceder a crear el objeto sin problema
            Passenger passenger = new Passenger(idInt, firstName, lastName, BD, phoneCodeInt, phoneInt, country);
            //PassengerStorage.addPassenger(passenger)
            return new Response("Passenger registered successfully", Status.CREATED);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response registerPlane() {
        
    }

    @Override
    public Response registerLocation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response registerFlight() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
