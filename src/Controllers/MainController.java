/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Models.Flight;
import core.controllers.utils.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public class MainController {

    private final IGeneratorTime timeGenerator;
    private final IRegister register;
    private final IControllerFlights ICFlights;

    public MainController(IGeneratorTime timeGenerator, IRegister register, IControllerFlights ICFlights) {
        this.timeGenerator = timeGenerator;
        this.register = register;
        this.ICFlights = ICFlights;
    }

//Metodos de timeGenerator
    public ArrayList<String> generateMonths() {
        return timeGenerator.generateMonths();
    }

    public ArrayList<String> generateDays() {
        return timeGenerator.generateDays();
    }

    public ArrayList<String> generateMinutes() {
        return timeGenerator.generateMinutes();
    }

    public ArrayList<String> generateHours() {
        return timeGenerator.generateHours();
    }

//Metodos de register
    public Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country) {
        return register.registerPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
    }
    
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline){
        return register.registerPlane( id,  brand,  model,  maxCapacity,  airline);
    }

    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude){
        return register.registerLocation(id, name, city, country, latitude, longitude);
    } 
    
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale){
        return register.registerFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);
    }
//De forma temporal depende de controllerflights, 
//Se debe de poner una interfaz aqui    

    public void delayFlight(Flight flight, int hours, int minutes) {
        ICFlights.delay(flight, hours, minutes);
    }
//De forma temporal tambien llama directo a la clase    

    public LocalDateTime calculateArrivalDate(Flight flight) {
        return ControllerFlights.calculateArrivalDate(flight);
    }
}
