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
import Controllers.Validators.IValidatorFlight;
import Controllers.Validators.IValidatorLocation;
import Controllers.Validators.IValidatorPassenger;
import Controllers.Validators.IValidatorPlane;
import Controllers.Validators.ValidatorFlight;
import Controllers.Validators.ValidatorLocation;
import Controllers.Validators.ValidatorPassenger;
import Controllers.Validators.ValidatorPlane;
import Models.Storage.DataLoader;

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
        
        IValidatorFlight vf = new ValidatorFlight();

        // Lo inyectas al RegisterFlight
        return new RegisterFlight(flightCreator, vf);

    }
    
    
    public RegisterPassenger createRegisterPassenger() {
        // Primero creas el PassengerCreator
        IPassengerCreator passengerCreator = new PassengerCreator();
        IValidatorPassenger vp = new ValidatorPassenger();

        // Lo inyectas al RegisterPassenger
        return new RegisterPassenger(passengerCreator, vp);

    }
    
    public RegisterLocation createRegisterLocation() {
        // Primero creas el LocationCreator
        ILocationCreator locationCreator = new LocationCreator();
        IValidatorLocation vl = new ValidatorLocation();

        // Lo inyectas al RegisterFlight
        return new RegisterLocation(locationCreator, vl);

    }
    
    
    public RegisterPlane createRegisterPlane() {
        // Primero creas el PlaneCreator
        IPlaneCreator planeCreator = new PlaneCreator();
        IValidatorPlane vp = new ValidatorPlane();

        // Lo inyectas al RegisterPlane
        return new RegisterPlane(planeCreator,vp );

    }
    
    public DataLoader createDataLoader() {
        return new DataLoader(createSearchStorage());
    }

}
