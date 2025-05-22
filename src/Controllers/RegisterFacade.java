/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;


import Controllers.Interfaces.*;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPlane;
import core.controllers.utils.Response;


// Esta clase es la que se encarga de controlar las interfaces y que se llamen a los metodos correspondientes  
// de Register
// Se usa para no violar el principio OCP
public class RegisterFacade implements IRegisterPassenger, IRegisterPlane, IRegisterLocation, IRegisterFlight, IRegister {

    private final RegisterPassenger registerPassenger;
    private final RegisterPlane registerPlane;
    private final RegisterLocation registerLocation;
    private final RegisterFlight registerFlight;

    public RegisterFacade(
        RegisterPassenger registerPassenger,
        RegisterPlane registerPlane,
        RegisterLocation registerLocation,
        RegisterFlight registerFlight
    ) {
        this.registerPassenger = registerPassenger;
        this.registerPlane = registerPlane;
        this.registerLocation = registerLocation;
        this.registerFlight = registerFlight;
    }

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country) {
        return registerPassenger.registerPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
    }

    @Override
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline) {
        return registerPlane.registerPlane(id, brand, model, maxCapacity, airline);
    }

    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        return registerLocation.registerLocation(id, name, city, country, latitude, longitude);
    }

    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
        return registerFlight.registerFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);
    }
}
