/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Controllers.Interfaces.ISearchStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author samit
 */
//Es abstracta para no violar DIP y que las clases que utilicen sus metodos no dependan de una clase concreta
public class ValidatorPassenger implements IValidatorPassenger {

    private final ISearchStorage searchStorage;

    public ValidatorPassenger(ISearchStorage searchStorage) {
        this.searchStorage = searchStorage;
    }

    @Override
    public Response validatePassenger(String id, String firstName, String lastName, String year, String month, String day, String phoneCode, String phone, String country) {
        try {
            long idInt, phoneInt;
            LocalDate BD;
            int phoneCodeInt, yearInt, monthInt, dayInt;

            if (id.equals("")) {
                return new Response("Id must be not empty", Status.BAD_REQUEST);
            }
            try {
                //Se verifica que el id sea valido
                idInt = Integer.parseInt(id);
                if (idInt < 0) {
                    return new Response("Id must be positive", Status.BAD_REQUEST);
                } else if (idInt > Math.pow(10, 16) - 1) {
                    return new Response("Id must have at most 15 digits", Status.BAD_REQUEST);
                }

                //Se verifica que el id no exista
                if (searchStorage.getPassenger(idInt) != null) {
                    return new Response("There is already a passenger with that id", Status.CONFLICT);
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

            //Se verifica el año
            if (year.equals("")) {
                return new Response("Year must be not empty", Status.BAD_REQUEST);
            }
            try {
                //Primero se verifica que el año sea positivo, despues se verifica que se pueda comvertir la fecha
                yearInt = Integer.parseInt(year);
                if (yearInt < 0) {
                    return new Response("Year must be positive", Status.BAD_REQUEST);
                }

                //Se verifica que se haya selecionado un mes
                try {
                    monthInt = Integer.parseInt(month);
                } catch (NumberFormatException ex) {
                    return new Response("No month has been selected", Status.BAD_REQUEST);
                }
                //Se verifica que se haya selecionado un día
                try {
                    dayInt = Integer.parseInt(day);
                } catch (NumberFormatException ex) {
                    return new Response("No day has been selected", Status.BAD_REQUEST);
                }

                //(No se especifica que error hay en la fecha, solo que es invalida)
                try {
                    BD = LocalDate.of(yearInt, monthInt, dayInt);
                } catch (DateTimeException e) {
                    return new Response("Enter a valid date", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Year must be numeric", Status.BAD_REQUEST);
            }

            //Se verifica el codigo telefonico
            if (phoneCode.equals("")) {
                return new Response("Phone code must be not empty", Status.BAD_REQUEST);
            }
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
            if (phone.equals("")) {
                return new Response("Phone must be not empty", Status.BAD_REQUEST);
            }
            try {
                phoneInt = Long.parseLong(phone);
                if (phoneInt < 0) {
                    return new Response("Phone must be positive", Status.BAD_REQUEST);
                } else if (phoneInt > Math.pow(10, 12) - 1) {
                    return new Response("Phone must have at most 11 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }

            //Pasó todas las pruebas
            return new Response("Passenger registered successfully", Status.OK);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
