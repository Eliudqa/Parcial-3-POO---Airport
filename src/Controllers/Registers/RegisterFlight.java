/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Registers;

import Controllers.Interfaces.IRegisterFlight;
import Controllers.Validators.ValidatorFlight;
import Models.Flight;
import Models.Location;
import Models.Plane;
import Models.Storage.LocationsStorage;
import Models.Storage.PlanesStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.LocalDateTime;

/**
 *
 * @author HOLA
 */
public class RegisterFlight implements IRegisterFlight {

    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
        Response response = ValidatorFlight.validateFlight(id, planeId, departureLocationId, arrivalLocationId, year, month, day, hour, minutes, hoursDurationArrival, minutesDurationArrival, scaleId, hoursDurationScale, minutesDurationScale);

        if (response.getStatus() != Status.OK) {
            return response;
        }
        Plane plane = null;
        Flight flight;
        Location departureLocation = null, scaleLocation = null, arrivalLocation = null;
        
        for(Location location : LocationsStorage.getInstance().getLocations()){
            if(departureLocationId.equals(location.getAirportId())){
                departureLocation = location;
            }
            if(arrivalLocationId.equals(location.getAirportId())){
                arrivalLocation = location;
            }
            if(scaleId.equals(location.getAirportId())){
                scaleLocation = location;
            }
        }
        
        for(Plane p : PlanesStorage.getInstance().getPlanes()){
            if(planeId.equals(p.getId())){
                plane = p;
            }
        }
        
        LocalDateTime departureDate = LocalDateTime.of(Integer.parseInt(year), month, day, hour, minutes);
        if(scaleId.equals("")){
            flight = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival), hoursDurationScale, minutesDurationScale);
        }else{
            flight = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival));
        }
        
        plane.addFlight(flight);
        //Flight flight = response;
        //Llamada al metodo que mete al storage
        return response;

    }
}
