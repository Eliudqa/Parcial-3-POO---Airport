/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import Controllers.ControllerFlights;
import Controllers.Creators.FlightCreator;
import Controllers.Creators.IFlightCreator;
import Controllers.Creators.ILocationCreator;
import Controllers.Creators.IPassengerCreator;
import Controllers.Creators.IPlaneCreator;
import Controllers.Creators.LocationCreator;
import Controllers.Creators.PassengerCreator;
import Controllers.Creators.PlaneCreator;
import Controllers.GeneratorTime;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Controllers.MainController;
import Controllers.Interfaces.IControllerFlights;
import Controllers.Registers.RegisterFacade;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPlane;

/**
 *
 * @author samit
 */
public class AppConfig {
     public MainController createMainController() {
        IGeneratorTime generatorTime = new GeneratorTime();
        
        RegisterFlight registerFlight = createRegisterFlight();
        RegisterPassenger registerPassenger = createRegisterPassenger();
        RegisterPlane registerPlane = createRegisterPlane();
        RegisterLocation registerLocation = createRegisterLocation();
        

        
        IRegister registerFacade = new RegisterFacade(
            registerPassenger,
            registerPlane,
            registerLocation,
            registerFlight
        );        
        IControllerFlights ICFlights = new ControllerFlights();
        
        return new MainController(generatorTime, registerFacade, ICFlights);
    }
     
    public RegisterFlight createRegisterFlight() {
        // Primero creas el FlightCreator
        IFlightCreator flightCreator = new FlightCreator();

        // Lo inyectas al RegisterFlight
        return new RegisterFlight(flightCreator);

    }
    
    
    public RegisterPassenger createRegisterPassenger() {
        // Primero creas el PassengerCreator
        IPassengerCreator passengerCreator = new PassengerCreator();

        // Lo inyectas al RegisterPassenger
        return new RegisterPassenger(passengerCreator);

    }
    
    public RegisterLocation createRegisterLocation() {
        // Primero creas el LocationCreator
        ILocationCreator locationCreator = new LocationCreator();

        // Lo inyectas al RegisterFlight
        return new RegisterLocation(locationCreator);

    }
    
    
    public RegisterPlane createRegisterPlane() {
        // Primero creas el PlaneCreator
        IPlaneCreator planeCreator = new PlaneCreator();

        // Lo inyectas al RegisterPlane
        return new RegisterPlane(planeCreator);

    }
}
