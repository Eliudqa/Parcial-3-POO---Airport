/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Creators.IFlightCreator;
import Controllers.Interfaces.IRegisterFlight;
import Controllers.SearchStorage;
import Controllers.Validators.IValidatorFlight;
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
    
    // Inyección por constructor
    public RegisterFlight(IFlightCreator flightCreator, IValidatorFlight validatorFlight) {
        this.flightCreator = flightCreator;
        this.vf=validatorFlight;
    }  

  
    
    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year,
            int month, int day, int hour, int minutes, String hoursDurationArrival,
            String minutesDurationArrival, String scaleId,
            int hoursDurationScale, int minutesDurationScale) {

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
        Location departureLocation = SearchStorage.getLocation(departureLocationId),
                scaleLocation = SearchStorage.getLocation(scaleId),
                arrivalLocation = SearchStorage.getLocation(arrivalLocationId);
        Plane plane = SearchStorage.getPlane(planeId);
        
        // Se llama la clase creadora de objetos de tipo Flight
        flightCreator.CreateFlight(id, plane, departureLocation, arrivalLocation, year, month, day, hour, 
                minutes, hoursDurationArrival, minutesDurationArrival, 
                scaleLocation, hoursDurationScale, minutesDurationScale);
        
        //Llamada al metodo que mete al storage
        return response;

    }

   
}
