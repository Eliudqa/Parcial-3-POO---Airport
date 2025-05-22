/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Interfaces.IRegisterPassenger;
import Controllers.Validators.ValidatorPassenger;
import Models.Passenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.LocalDate;

/**
 *
 * @author HOLA
 */
public class RegisterPassenger implements IRegisterPassenger {

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country) {

        Response response = ValidatorPassenger.validatePassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        LocalDate BD = LocalDate.of(Integer.parseInt(year), month, day);

        Passenger passenger = new Passenger(Integer.parseInt(id), firstName, lastName, BD, Integer.parseInt(phoneCode), Integer.parseInt(phone), country);
        //Llamada al metodo que mete al storage
        return response;
    }
}
