/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;


import Controllers.Registers.IRegisterFlight;
import Controllers.Registers.IRegisterLocation;
import Controllers.Registers.IRegisterPlane;
import Controllers.Registers.IRegisterPassenger;
import Controllers.Interfaces.*;
import Controllers.Registers.IRegisterPassengerInFlight;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPassengerInFlight;
import Controllers.Registers.RegisterPlane;
import core.controllers.utils.Response;


// Esta clase es la que se encarga de controlar las interfaces y que se llamen a los metodos correspondientes  
// de Register
// Se usa para no violar el principio OCP
public class RegisterFacade implements IRegister{

    private final IRegisterPassenger registerPassenger;
    private final IRegisterPlane registerPlane;
    private final IRegisterLocation registerLocation;
    private final IRegisterFlight registerFlight;
    private final IRegisterPassengerInFlight lar;

    

    public RegisterFacade(
        RegisterPassenger registerPassenger,
        RegisterPlane registerPlane,
        RegisterLocation registerLocation,
        RegisterFlight registerFlight,
        RegisterPassengerInFlight lar

    ) {
        this.registerPassenger = registerPassenger;
        this.registerPlane = registerPlane;
        this.registerLocation = registerLocation;
        this.registerFlight = registerFlight;
        this.lar = lar;

    }

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, String year, String month, String day, String phoneCode, String phone, String country) {
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
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId,
            String year, String month, String day, String hour, String minutes,
            String hoursDurationArrival, String minutesDurationArrival, 
            String scaleId, String hoursDurationScale, String minutesDurationScale) {
        return registerFlight.registerFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);
    }
    
    @Override
    public Response RegisterPassengerInFlight(String passengerId, String flightId){
        return lar.RegisterPassengerInFlight(passengerId, flightId);
    }
    
}
