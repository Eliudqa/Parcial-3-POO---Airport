/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRefresher;
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
    private final IRegister registerFacade;
    private final IControllerFlights ICFlights;
    private final IRefresher refresher;


    public MainController(IGeneratorTime timeGenerator, IRegister register, IControllerFlights ICFlights,IRefresher refresher) {
        this.timeGenerator = timeGenerator;
        this.registerFacade = register;
        this.ICFlights = ICFlights;
        this.refresher = refresher;

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
        return registerFacade.registerPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
    }
    
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline){
        return registerFacade.registerPlane( id,  brand,  model,  maxCapacity,  airline);
    }

    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude){
        return registerFacade.registerLocation(id, name, city, country, latitude, longitude);
    } 
    
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale){
        return registerFacade.registerFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);
    }

    public void delayFlight(Flight flight, int hours, int minutes) {
        ICFlights.delay(flight, hours, minutes);
    }    
    
    // Metodos de refresh
    public Response refreshPlanes() {
        return refresher.refreshPlanes();
    }    

    
    public Response refreshFlights() {
        return refresher.refreshFlights();
    }

    
    public Response refreshPassengers() {
        return refresher.refreshPassengers();
    }

    public Response refreshLocations() {
        return refresher.refreshLocations();
    }
    
    public ArrayList<String> refreshUser(){
      return refresher.refreshUser();
    }

    public ArrayList<String> refreshAvailableFlights(){
      return refresher.refreshAvailableFlights();
    }

    
}
