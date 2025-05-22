/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Validators.ValidatorPassenger;
import Controllers.Validators.ValidatorPlane;
import Controllers.Validators.ValidatorLocation;
import Controllers.Interfaces.IRegister;
import Controllers.Validators.ValidatorFlight;
import Models.Flight;
import Models.Location;

import Models.Plane;
import Models.Storage.PlanesStorage;
import Models.Passenger;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
//Clase encargada de registrar/crear los objetos en las pestañas de registration
public class Register implements IRegister {

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

    @Override
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline) {
        Response response = ValidatorPlane.validatePlane(id, brand, model, maxCapacity, airline);

        if (response.getStatus() != Status.OK) {
            return response;
        }
        
        Plane plane = new Plane(id, brand, model, Integer.parseInt(maxCapacity), airline);
        //Llamada al metodo que mete al storage
        return response;
    }

    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        Response response = ValidatorLocation.validateLocation(id, name, city, country, latitude, longitude);
        
        if (response.getStatus() != Status.OK) {
            return response;
        }
        
        Location plane = new Location(id, name, city, country, Double.parseDouble(latitude), Double.parseDouble(longitude));
        //Llamada al metodo que mete al storage
        return response;
    }

    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
        Response response = ValidatorFlight.validateFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);
        
        if (response.getStatus() != Status.OK) {
            return response;
        }
        
        //Flight flight = response;
        //Llamada al metodo que mete al storage
        return response;
    }

}
