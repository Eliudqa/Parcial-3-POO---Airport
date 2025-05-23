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
import Controllers.Facades.GetStorageFacade;
import Controllers.Facades.RefresherFacade;
import Controllers.GeneratorTime;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Controllers.MainController;
import Controllers.Interfaces.IControllerFlights;
import Controllers.Interfaces.ISearchStorage;
import Controllers.Facades.RegisterFacade;
import Controllers.Interfaces.IRefresher;
import Controllers.Interfaces.IUpdateInfo;
import Controllers.Interfaces.Storage.IStorageGet;
import Controllers.Interfaces.Storage.IStorageGetFlights;
import Controllers.Interfaces.Storage.IStorageGetLocations;
import Controllers.Interfaces.Storage.IStorageGetPassengers;
import Controllers.Interfaces.Storage.IStorageGetPlanes;
import Controllers.Refreshers.FlightsAvailableRefresher;
import Controllers.Refreshers.FlightsRefreshers;
import Controllers.Interfaces.Refreshers.IFlightsAvailableRefresher;
import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import Controllers.Interfaces.Refreshers.ILocationAvailableRefresher;
import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import Controllers.Interfaces.Refreshers.IPassengersRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesAvailableRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesRefreshers;
import Controllers.Interfaces.Refreshers.IRefreshMyFlights;
import Controllers.Interfaces.Refreshers.IUserRefresher;
import Controllers.Refreshers.LocationAvailableRefresher;
import Controllers.Refreshers.LocationsRefreshers;
import Controllers.Refreshers.PassengersRefresher;
import Controllers.Refreshers.PlanesAvailableRefreshers;
import Controllers.Refreshers.PlanesRefreshers;
import Controllers.Refreshers.RefreshMyFlights;
import Controllers.Refreshers.UserRefresher;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPlane;
import Controllers.SearchStorage;
import Controllers.UpdateInfo;
import Controllers.Validators.IValidatorFlight;
import Controllers.Validators.IValidatorLocation;
import Controllers.Validators.IValidatorPassenger;
import Controllers.Validators.IValidatorPassengerUpdate;
import Controllers.Validators.IValidatorPlane;
import Controllers.Validators.ValidatorFlight;
import Controllers.Validators.ValidatorLocation;
import Controllers.Validators.ValidatorPassenger;
import Controllers.Validators.ValidatorPassengerUpdate;
import Controllers.Validators.ValidatorPlane;
import Models.Storage.DataLoader;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import Models.Storage.PassengersStorage;
import Models.Storage.PlanesStorage;

/**
 *
 * @author samit
 */
public class AppConfig {
    private final IStorageGet ISG = createStorageGet();
    private final ISearchStorage searchStorage = createSearchStorage();


    public MainController createMainController() {
        IGeneratorTime generatorTime = new GeneratorTime();
        IValidatorPassengerUpdate vf = new ValidatorPassengerUpdate();
        IUpdateInfo IUF = new UpdateInfo(vf,searchStorage);
        
        RegisterFlight registerFlight = createRegisterFlight();
        RegisterPassenger registerPassenger = createRegisterPassenger();
        RegisterPlane registerPlane = createRegisterPlane();
        RegisterLocation registerLocation = createRegisterLocation();

        IRefresher refresher = createRefresher();

        IRegister registerFacade = new RegisterFacade(
                registerPassenger,
                registerPlane,
                registerLocation,
                registerFlight
        );
        
        IControllerFlights ICFlights = new ControllerFlights();

        return new MainController(generatorTime, registerFacade, ICFlights, refresher, ISG, IUF);
    }

    public RegisterFlight createRegisterFlight() {
        // Primero creas el FlightCreator
        IFlightCreator flightCreator = new FlightCreator();

        IValidatorFlight vf = new ValidatorFlight(searchStorage);
        ISaverFlights sf = new SaverFlights();

        // Lo inyectas al RegisterFlight
        return new RegisterFlight(flightCreator, vf, searchStorage, sf);

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
        return new RegisterPlane(planeCreator, vp, sp);

    }

    public DataLoader createDataLoader() {
        return new DataLoader(createSearchStorage());
    }

    public ISearchStorage createSearchStorage() {
        IStorageGet ISG = createStorageGet();
        return new SearchStorage(ISG);
    }
          
     public IRefresher createRefresher() {
         
    IPlanesRefreshers planeRefresher = new PlanesRefreshers(ISG);
    IFlightsRefresher flightRefresher = new FlightsRefreshers(ISG);
    IPassengersRefreshers passengerRefresher = new PassengersRefresher(ISG);
    ILocationsRefreshers locationRefresher = new LocationsRefreshers(ISG);
    IUserRefresher userRefresher = new UserRefresher(ISG);
    IFlightsAvailableRefresher availableFlightsRefresher = new FlightsAvailableRefresher(ISG);
    IRefreshMyFlights myFlightsRefresher = new RefreshMyFlights(searchStorage);
    IPlanesAvailableRefreshers availablePlanesRefresher = new PlanesAvailableRefreshers(ISG);
    ILocationAvailableRefresher availableLocationsRefresher = new LocationAvailableRefresher(ISG);

   

    return new RefresherFacade(
        planeRefresher,
        flightRefresher,
        passengerRefresher,
        locationRefresher,
       userRefresher,
       availableFlightsRefresher,
       myFlightsRefresher,
       availablePlanesRefresher,
       availableLocationsRefresher
    );
}

    public IStorageGet createStorageGet(){
        IStorageGetPlanes isgpl = PlanesStorage.getInstance();
        IStorageGetFlights isgf=  FlightsStorage.getInstance();
        IStorageGetLocations isgl=  LocationsStorage.getInstance();
        IStorageGetPassengers isgpa=  PassengersStorage.getInstance();
        return new GetStorageFacade(isgpl, isgf, isgl, isgpa);
    }


}
