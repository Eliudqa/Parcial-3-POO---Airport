/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IRegister;
import Models.Flight;
import Models.Location;

import Models.Plane;
import Models.Storage.PlanesStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import Models.Passenger;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import Models.Storage.PassengersStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
//Clase encargada de registrar/crear los objetos en las pestañas de registration
public class Register implements IRegister {

    @Override
    public Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country) {
        try {
            long idInt, phoneInt;
            LocalDate BD;
            int phoneCodeInt, yearInt;

            if (id.equals("")) {
                return new Response("Id must be not empty", Status.BAD_REQUEST);
            }
            try {
                //Se verifica que el id sea valido
                idInt = Integer.parseInt(id);
                if (idInt < 0) {
                    return new Response("Id must be positive", Status.BAD_REQUEST);
                } else if (idInt > Math.pow(10, 16) - 1) {
                    return new Response("Id must have at most 15 digits", Status.BAD_REQUEST);
                }

                for (Passenger passenger : PassengersStorage.getInstance().getPassengers()) {
                    if (idInt == passenger.getId()) {
                        return new Response("There is already a passenger with that id", Status.CONFLICT);
                    }
                }

            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }

            //Se verifica que los cambos de los nombres no esten vacios
            if (firstName.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }

            if (lastName.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }

            //Se verifica el año
            if (year.equals("")) {
                return new Response("Year must be not empty", Status.BAD_REQUEST);
            }
            try {

                //Primero se verifica que el año sea positivo, despues se verifica que se pueda comvertir la fecha
                yearInt = Integer.parseInt(year);
                if (yearInt < 0) {
                    return new Response("Year must be positive", Status.BAD_REQUEST);
                }
                //(No se especifica que error hay en la fecha, solo que es invalida)
                try {
                    BD = LocalDate.of(yearInt, month, day);
                } catch (DateTimeException e) {
                    return new Response("Enter a valid date", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Year must be numeric", Status.BAD_REQUEST);
            }

            //Se verifica el codigo telefonico
            if (phoneCode.equals("")) {
                return new Response("Phone code must be not empty", Status.BAD_REQUEST);
            }
            try {
                phoneCodeInt = Integer.parseInt(phoneCode);
                if (phoneCodeInt < 0) {
                    return new Response("Phone Code must be positive", Status.BAD_REQUEST);
                } else if (phoneCodeInt > 999) {
                    return new Response("Phone code must have at most 3 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone Code must be numeric", Status.BAD_REQUEST);
            }

            //Se verifica que el numero sea valido
            if (phone.equals("")) {
                return new Response("Phone must be not empty", Status.BAD_REQUEST);
            }
            try {
                phoneInt = Integer.parseInt(phone);
                if (phoneInt < 0) {
                    return new Response("Phone must be positive", Status.BAD_REQUEST);
                } else if (phoneInt > Math.pow(10, 12) - 1) {
                    return new Response("Phone must have at most 3 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }

            //Se puede proceder a crear el objeto sin problema
            Passenger passenger = new Passenger(idInt, firstName, lastName, BD, phoneCodeInt, phoneInt, country);
            //PassengerStorage.addPassenger(passenger)
            return new Response("Passenger registered successfully", Status.CREATED);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response registerPlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            int maxCapacityInt;

            for (Plane plane : PlanesStorage.getInstance().getPlanes()) {
                if (plane.getId().equals(id)) {
                    return new Response("Id already exist", Status.CONFLICT);
                }
            }

            if (id.equals("")) {
                return new Response("Id must not be empty", Status.BAD_REQUEST);
            }

            if (id.length() != 7) {
                return new Response("Id must have 7 characters", Status.BAD_REQUEST);
            }

            // Verificamos que los dos primeros caracteres sean mayúsculas
            if (!Character.isUpperCase(id.charAt(0))) {
                return new Response("The first character of Id must be capital", Status.BAD_REQUEST);
            }
            if (!Character.isUpperCase(id.charAt(1))) {
                return new Response("The second character of Id must be capital", Status.BAD_REQUEST);
            }

            // Verificamos que los caracteres de la posición 3 a 7 sean dígitos
            for (int i = 2; i < 7; i++) { // i debe ir de 2 a 6
                if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
                    return new Response("The character at position " + (i + 1) + " must be a digit", Status.BAD_REQUEST);
                }
            }

            try {
                maxCapacityInt = Integer.parseInt(maxCapacity);
            } catch (NumberFormatException e) {
                return new Response("maxCapacity must be a number", Status.BAD_REQUEST);
            }

            if (maxCapacityInt <= 0) {
                return new Response("maxCapacity must be a positive number", Status.BAD_REQUEST);
            }

            if (brand.equals("")) {
                return new Response("Brand must be not empty", Status.BAD_REQUEST);
            }

            if (model.equals("")) {
                return new Response("Model must be not empty", Status.BAD_REQUEST);
            }

            if (maxCapacity.equals("")) {
                return new Response("maxCapacity must be not empty", Status.BAD_REQUEST);
            }
            if (airline.equals("")) {
                return new Response("Airline must be not empty", Status.BAD_REQUEST);
            }
            Plane plane = new Plane(id, brand, model, maxCapacityInt, airline);
            // planes.add(plane) Falta por añadir
            return new Response("Plane registered succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response registerLocation(String id, String name, String city, String country, String latitude, String longitude) {
        try {

            //Se verifica que no este vacio
            if (id.equals("")) {
                return new Response("Id must be not empty", Status.BAD_REQUEST);
            }
            //Se verifica que el id sí este hecho por 3 caracteres
            if (id.length() != 3) {
                return new Response("Id must be 3 digits long", Status.BAD_REQUEST);
            } else {

                //Se revisa que el id sí sea valido
                for (char c : id.toCharArray()) {
                    if (!Character.isLetter(c)) {
                        return new Response("All characters must be a letter", Status.BAD_REQUEST);
                    } else if (!Character.isUpperCase(c)) {
                        return new Response("All characters must be capitalized", Status.BAD_REQUEST);
                    }
                }
            }

            //Se verifica que el id no exista
            for (Location location : LocationsStorage.getInstance().getLocations()) {
                if (location.getAirportId().equals(id)) {
                    return new Response("There is already a location with that id", Status.CONFLICT);
                }
            }

            //Se verifica que el nombre, pais y la ciudad no esten vacias
            if (name.equals("")) {
                return new Response("Name must be not empty", Status.BAD_REQUEST);
            }
            if (city.equals("")) {
                return new Response("City must be not empty", Status.BAD_REQUEST);
            }
            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }

            int noDec = 0;
            double noLat;
            //Se verifica la latitud
            if (latitude.equals("")) {
                return new Response("Latitude must be not empty", Status.BAD_REQUEST);
            }
            try {
                noLat = Double.parseDouble(latitude);
            } catch (NumberFormatException e) {
                return new Response("Latitude must be a number", Status.BAD_REQUEST);
            }

            if (latitude.contains(".")) {
                noDec = latitude.length() - latitude.indexOf('.') - 1;
            }
            if (noDec > 4) {
                return new Response("Latitude must have at most 4 decimals", Status.BAD_REQUEST);
            }

            if (noLat < -90 || noLat > 90) {
                return new Response("Latitude must be between -90 and 90", Status.BAD_REQUEST);
            }

            double noLong;
            noDec = 0;
            //Se verifica la longitude
            if (longitude.equals("")) {
                return new Response("Longitude must be not empty", Status.BAD_REQUEST);
            }
            try {
                noLong = Double.parseDouble(longitude);
            } catch (NumberFormatException e) {
                return new Response("Longitude must be a number", Status.BAD_REQUEST);
            }

            if (longitude.contains(".")) {
                noDec = longitude.length() - longitude.indexOf('.') - 1;
            }
            if (noDec > 4) {
                return new Response("Longitude must have at most 4 decimals", Status.BAD_REQUEST);
            }

            if (noLong < -180 || noLong > 180) {
                return new Response("Longitude must be between -180 and 180", Status.BAD_REQUEST);
            }

            Location location = new Location(id, name, city, country, noLat, noLong);
            return new Response("Location registered succesfully", Status.CREATED);
            //Falta añadir

        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response registerFlight(String id, String planeId, String departureLocationId, String arrivalLocationId, String year, int month, int day, int hour, int minutes, String hoursDurationArrival, String minutesDurationArrival, String scaleId, int hoursDurationScale, int minutesDurationScale) {
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
                return new Response("There is no plane with that id", Status.BAD_REQUEST);
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
            try{
                departureDate = LocalDateTime.of(yearInt, month, day, hour, minutes);
            }catch (DateTimeException e) {
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
                
                flight = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival), hoursDurationScale, minutesDurationScale);
                
            //Se crea el vuelo sin escala 
            }else{
                flight = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, Integer.parseInt(hoursDurationArrival), Integer.parseInt(minutesDurationArrival))  ;
            }
            plane.addFlight(flight);
            //Se registra el vuelo
            return new Response("Flight registered succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
