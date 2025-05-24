/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.IFlightCreator;
import Controllers.DataSavers.ISaverFlights;
import Controllers.Interfaces.ISearchStorage;
import Controllers.SearchStorage;
import Controllers.Validators.IValidatorFlight;
import Models.Flight;
import Models.Location;
import Models.Plane;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author HOLA
 */
public class RegisterFlight implements IRegisterFlight {

    private final IFlightCreator flightCreator;
    private final IValidatorFlight vf;
    private final ISearchStorage searchStorage;
    private final ISaverFlights sf;

    // Inyección por constructor
    public RegisterFlight(IFlightCreator flightCreator, IValidatorFlight validatorFlight, ISearchStorage searchStorage, ISaverFlights sf) {
        this.flightCreator = flightCreator;
        this.vf = validatorFlight;
        this.searchStorage = searchStorage;
        this.sf = sf;
    }

    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year,
            String month, String day, String hour, String minutes, String hoursDurationArrival,
            String minutesDurationArrival, String scaleId,
            String hoursDurationScale, String minutesDurationScale) {

        // Se le manda al validador la informacion del avion
        Response response = vf.validateFlight(id, planeId, departureLocationId,
                arrivalLocationId, year, month, day, hour, minutes,
                hoursDurationArrival, minutesDurationArrival,
                scaleId, hoursDurationScale, minutesDurationScale);

        // No se sigue con el proceso de registro si alguna validacion falló
        if (response.getStatus() != Status.OK) {
            return response;
        }

        // Se hacen las busquedas correspondientes
        Location departureLocation = searchStorage.getLocation(departureLocationId),
                scaleLocation = searchStorage.getLocation(scaleId),
                arrivalLocation = searchStorage.getLocation(arrivalLocationId);
        Plane plane = searchStorage.getPlane(planeId);

        // Se llama la clase creadora de objetos de tipo Flight
        Flight flight = flightCreator.CreateFlight(id, plane, departureLocation, arrivalLocation, year, month, day, hour,
                minutes, hoursDurationArrival, minutesDurationArrival,
                scaleLocation, hoursDurationScale, minutesDurationScale);

        sf.addFlight(flight);
        return response;

    }

}
