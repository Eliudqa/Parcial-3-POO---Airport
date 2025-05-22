/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Models.Flight;
import Models.Location;
import Models.Plane;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import Models.Storage.PlanesStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public class ValidatorFlight {

    public static Response validateFlight(String id, String planeId, String departureLocationId
            , String arrivalLocationId, String year, int month, int day, int hour, int minutes,
            String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
        try {
            //Se verifica que nada este vacio
            if (id.equals("")) {
                return new Response("Plane must be not empty", Status.BAD_REQUEST);
            }
            if (planeId.equals("")) {
                return new Response("Plane must be not empty", Status.BAD_REQUEST);
            }
            if (departureLocationId.equals("")) {
                return new Response("Departure location must be not empty", Status.BAD_REQUEST);
            }
            if (arrivalLocationId.equals("")) {
                return new Response("Arrival location must be not empty", Status.BAD_REQUEST);
            }
            if (year.equals("")) {
                return new Response("Departure date must be not empty", Status.BAD_REQUEST);
            }
            if (hoursDurationArrival.equals("")) {
                return new Response("Hours duration arrival must be not empty", Status.BAD_REQUEST);
            }
            if (minutesDurationArrival.equals("")) {
                return new Response("Minutes duration arrival must be not empty", Status.BAD_REQUEST);
            }

            //Se verifica que el tiempo de vuelo sea mayor a 00:00
            if(Integer.parseInt(hoursDurationArrival)==0&&Integer.parseInt(minutesDurationArrival)==0){
                return new Response("Flight time must be more than 00:00", Status.BAD_REQUEST);
            }
            //Se verifica que el id sea valido
            if (id.length() != 6) {
                return new Response("Flight id date must have 6 characters", Status.BAD_REQUEST);
            }

            for (int i = 0; i < 6; i++) {
                char c = id.charAt(i);
                if (i < 3) {
                    if (!Character.isLetter(c)) {
                        return new Response("The character " + i + " must be a letter", Status.BAD_REQUEST);
                    } else if (!Character.isUpperCase(c)) {
                        return new Response("The character " + i + " must be capitalized", Status.BAD_REQUEST);
                    }
                } else {
                    if (!Character.isDigit(c)) {
                        return new Response("The character " + i + " must be a number", Status.BAD_REQUEST);
                    }
                }
            }

            for (Flight flight : FlightsStorage.getInstance().getFlights()) {
                if (flight.getId().equals(id)) {
                    return new Response("There is already a flight with that id", Status.CONFLICT);
                }
            }

            //Se verifica que el id del avion este bien escrito
            // Verificamos que los dos primeros caracteres sean mayúsculas
            if (!Character.isUpperCase(planeId.charAt(0))) {
                return new Response("The first character of plane id must be capital", Status.BAD_REQUEST);
            }
            if (!Character.isUpperCase(planeId.charAt(1))) {
                return new Response("The second character of plane id must be capital", Status.BAD_REQUEST);
            }

            // Verificamos que los caracteres de la posición 3 a 7 sean dígitos
            for (int i = 2; i < 7; i++) { // i debe ir de 2 a 6
                if (!(planeId.charAt(i) >= '0' && planeId.charAt(i) <= '9')) {
                    return new Response("The character at position " + (i + 1) + " must be a digit", Status.BAD_REQUEST);
                }
            }

            int i = 0;
            //Se busca el avion
            boolean found = false;
            Plane plane = null;
            ArrayList<Plane> planes = PlanesStorage.getInstance().getPlanes();
            while (i < planes.size() && !found) {
                if (planes.get(i).equals(planeId)) {
                    found = true;
                    plane = planes.get(i);
                } else {
                    i++;
                }
            }
            if (!found) {
                return new Response("There is no plane with that id", Status.NOT_FOUND);
            }

            //Se busca el lugar de salida
            //Se verifica que el id sí este hecho por 3 caracteres
            if (departureLocationId.length() != 3) {
                return new Response("Id must be 3 digits long", Status.BAD_REQUEST);
            } else {
                //Se revisa que el id sí sea valido
                for (char c : departureLocationId.toCharArray()) {
                    if (!Character.isLetter(c)) {
                        return new Response("All characters of departure location id must be a letter", Status.BAD_REQUEST);
                    } else if (!Character.isUpperCase(c)) {
                        return new Response("All characters of departure location id must be capitalized", Status.BAD_REQUEST);
                    }
                }
            }

            i = 0;
            Location departureLocation = null;
            found = false;
            ArrayList<Location> locations = LocationsStorage.getInstance().getLocations();
            while (i < locations.size() && !found) {
                if (locations.get(i).equals(departureLocationId)) {
                    found = true;
                    departureLocation = locations.get(i);
                } else {
                    i++;
                }
            }

            if (!found) {
                return new Response("In departure, there is no location with that id", Status.NOT_FOUND);
            }

            //Se busca el lugar de llegada
            //Se verifica que el id sí este hecho por 3 caracteres
            if (arrivalLocationId.length() != 3) {
                return new Response("Id must be 3 digits long", Status.BAD_REQUEST);
            } else {
                //Se revisa que el id sí sea valido
                for (char c : arrivalLocationId.toCharArray()) {
                    if (!Character.isLetter(c)) {
                        return new Response("All characters of arrival location id must be a letter", Status.BAD_REQUEST);
                    } else if (!Character.isUpperCase(c)) {
                        return new Response("All characters of arrival location id must be capitalized", Status.BAD_REQUEST);
                    }
                }
            }

            i = 0;
            Location arrivalLocation = null;
            found = false;
            while (i < locations.size() && !found) {
                if (locations.get(i).equals(arrivalLocationId)) {
                    found = true;
                    arrivalLocation = locations.get(i);
                } else {
                    i++;
                }
            }
            if (!found) {
                return new Response("In arrival, there is no location with that id", Status.NOT_FOUND);
            }

            //Se verifica que el año sea valido
            int yearInt;
            try {
                yearInt = Integer.parseInt(year);
            } catch (NumberFormatException e) {
                return new Response("Year must be a number", Status.BAD_REQUEST);
            }

            LocalDateTime departureDate;
            try {
                departureDate = LocalDateTime.of(yearInt, month, day, hour, minutes);
            } catch (DateTimeException e) {
                return new Response("Enter a valid date and hour", Status.BAD_REQUEST);
            }

            //En caso de escala
            Flight flight;
            if (!scaleId.equals("")) {
                i = 0;
                Location scaleLocation = null;
                found = false;
                while (i < locations.size() && !found) {
                    if (locations.get(i).equals(arrivalLocationId)) {
                        found = true;
                        scaleLocation = locations.get(i);
                    } else {
                        i++;
                    }
                }

                if (!found) {
                    return new Response("In scale, there is no location with that id", Status.NOT_FOUND);
                }

                          //   flight = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival), hoursDurationScale, minutesDurationScale);

            //Se crea el vuelo sin escala 
            } else {
                            // flight = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival));
            }
                             //plane.addFlight(flight);
            //Se registra el vuelo
            return new Response("Flight registered succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
