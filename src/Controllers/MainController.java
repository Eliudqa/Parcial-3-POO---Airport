/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRefresher;
import Controllers.Interfaces.IRegister;
import Controllers.Interfaces.IShowResponse;
import Controllers.Interfaces.IUpdateInfo;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import core.controllers.utils.Response;
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
    private final IStorageGet ISG;
    private final IUpdateInfo IUF;
    private final IShowResponse ISR;
    


   // Esto se hace asi para cumplir con OCP y no modificar los atributos ya existentes, sino que añadir metodos para cumplir con el principio
   
    public MainController(IGeneratorTime timeGenerator, IRegister register, 
            IControllerFlights ICFlights,IRefresher refresher, IStorageGet ISG,
            IUpdateInfo IUF, IShowResponse ISR) {
        
        this.timeGenerator = timeGenerator;
        this.registerFacade = register;
        this.ICFlights = ICFlights;
        this.refresher = refresher;
        this.ISG=ISG;
        this.IUF=IUF;
        this.ISR=ISR;
        

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
    public Response registerPassenger(String id, String firstName, String lastName, String year, String month, String day, String phoneCode, String phone, String country) {
        return registerFacade.registerPassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
    }
    
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline){
        return registerFacade.registerPlane( id,  brand,  model,  maxCapacity,  airline);
    }

    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude){
        return registerFacade.registerLocation(id, name, city, country, latitude, longitude);
    } 
    
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId,
            String year, String month, String day, String hour, String minutes, 
            String hoursDurationArrival, String minutesDurationArrival, 
            String scaleId, String hoursDurationScale, String minutesDurationScale){
        return registerFacade.registerFlight(id, planeId, departureLocationId, arrivalLocationId, 
                year, month, day, hour, minutes, 
                hoursDurationArrival, minutesDurationArrival, 
                scaleId, hoursDurationScale, minutesDurationScale);
    }

    public Response delayFlight(String flight, String hours, String minutes) {
        return ICFlights.delay(flight, hours, minutes);
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

    public ArrayList<String> refreshAvailablePlanes(){
        return refresher.refreshAvailablePlanes();
    }
    
    public ArrayList<String> refreshAvailableLocations(){
        return refresher.refreshAvailableLocations();
    }
    
    //Metodos Getters
    public Response getMyFlightsRows(String passengerId){
        return refresher.getMyFlightsRows(passengerId);
    }
    
    
    public ArrayList<Plane> getPlanes() {
        return ISG.getPlanes();
    }

    
    public ArrayList<Location> getLocations() {
        return ISG.getLocations();
    }

    
    public ArrayList<Passenger> getPassengers() {
        return ISG.getPassengers();
    }

    
    public ArrayList<Flight> getFlights() {
        return ISG.getFlights();
    }
    
    
    //Metodo updater    
    public Response updatePassenger(String id, String firstName, String lastName,
            String year, String month, String day,
            String phoneCode, String phone, String country){
        
        return IUF.updatePassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);
    }
    

    public Response RegisterPassengerInFlight(String passengerId, String flightId){
        return registerFacade.RegisterPassengerInFlight(passengerId, flightId);
    }

    //Metodo show
    public void showMessage(Response response){
        ISR.showResponse(response);
    }
    
}
