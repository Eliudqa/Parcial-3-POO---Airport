/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Models.Location;
import Models.Storage.LocationsStorage;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author samit
 */
public class ValidatorLocation {
    public static Response validateLocation(String id, String name, String city, String country, String latitude, String longitude){
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

            //Location location = new Location(id, name, city, country, noLat, noLong);
            return new Response("Location registered succesfully", Status.OK);
            //Falta añadir

        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
