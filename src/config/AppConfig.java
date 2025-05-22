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
import Controllers.DataSavers.ISaverFlights;
import Controllers.DataSavers.ISaverLocations;
import Controllers.DataSavers.ISaverPassengers;
import Controllers.DataSavers.ISaverPlanes;
import Controllers.DataSavers.SaverFlights;
import Controllers.DataSavers.SaverLocations;
import Controllers.DataSavers.SaverPassengers;
import Controllers.DataSavers.SaverPlanes;
import Controllers.GeneratorTime;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Controllers.MainController;
import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.ISearchStorage;
import Controllers.Registers.RegisterFacade;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPlane;
import Controllers.SearchStorage;
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
     private final ISearchStorage searchStorage = createSearchStorage();

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
        
        IValidatorFlight vf = new ValidatorFlight(searchStorage);
        ISaverFlights sf = new SaverFlights();

        // Lo inyectas al RegisterFlight
        return new RegisterFlight(flightCreator, vf, searchStorage,sf);

    }
    
    
    public RegisterPassenger createRegisterPassenger() {
        // Primero creas el PassengerCreator
        IPassengerCreator passengerCreator = new PassengerCreator();
        IValidatorPassenger vp = new ValidatorPassenger(searchStorage);
        ISaverPassengers sp = new SaverPassengers();

        // Lo inyectas al RegisterPassenger
        return new RegisterPassenger(passengerCreator, vp, sp);

    }
    
    public RegisterLocation createRegisterLocation() {
        // Primero creas el LocationCreator
        ILocationCreator locationCreator = new LocationCreator();
        IValidatorLocation vl = new ValidatorLocation(searchStorage);
        ISaverLocations sl = new SaverLocations();

        // Lo inyectas al RegisterFlight
        return new RegisterLocation(locationCreator, vl, sl);

    }
    
    
    public RegisterPlane createRegisterPlane() {
        // Primero creas el PlaneCreator
        IPlaneCreator planeCreator = new PlaneCreator();
        IValidatorPlane vp = new ValidatorPlane(searchStorage);
        ISaverPlanes sp = new SaverPlanes();

        // Lo inyectas al RegisterPlane
        return new RegisterPlane(planeCreator,vp, sp );

    }
    
    public DataLoader createDataLoader() {
        return new DataLoader(createSearchStorage());
    }

    
      public ISearchStorage createSearchStorage() {
        return new SearchStorage();
 }
}
