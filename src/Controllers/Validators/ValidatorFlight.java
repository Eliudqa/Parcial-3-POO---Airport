/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Validators;

import Controllers.Interfaces.ISearchStorage;
import Models.Flight;
import Models.Location;
import Models.Plane;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.DateTimeException;
import java.time.LocalDateTime;

/**
 *
 * @author samit
 */
//Es abstracta para no violar DIP y que las clases que utilicen sus metodos no dependan de una clase concreta
public class ValidatorFlight implements IValidatorFlight {

    private final ISearchStorage searchStorage;

    public ValidatorFlight(ISearchStorage searchStorage) {
        this.searchStorage = searchStorage;
    }

    @Override
    public Response validateFlight(String id, String planeId, String departureLocationId, String arrivalLocationId,
            String year, String month, String day, String hour, String minutes,
            String hoursDurationArrival, String minutesDurationArrival,
            String scaleId, String hoursDurationScale, String minutesDurationScale) {
        try {
            //Se verifica que nada este vacio
            if (id.equals("")) {
                return new Response("Id must be not empty", Status.BAD_REQUEST);
            }
            if (planeId.equals("Plane")) {
                return new Response("Plane must be not empty", Status.BAD_REQUEST);
            }
            if (departureLocationId.equals("Location")) {
                return new Response("Departure location must be not empty", Status.BAD_REQUEST);
            }
            if (arrivalLocationId.equals("Location")) {
                return new Response("Arrival location must be not empty", Status.BAD_REQUEST);
            }
            if (hoursDurationArrival.equals("Hour")) {
                return new Response("Hours duration arrival must be not empty", Status.BAD_REQUEST);
            }
            if (minutesDurationArrival.equals("Minute")) {
                return new Response("Minutes duration arrival must be not empty", Status.BAD_REQUEST);
            }

            //Se verifica que el tiempo de vuelo sea mayor a 00:00
            if (Integer.parseInt(hoursDurationArrival) == 0 && Integer.parseInt(minutesDurationArrival) == 0) {
                return new Response("Flight time must be more than 00:00", Status.BAD_REQUEST);
            }
            //Se verifica que el id sea valido
            if (id.length() != 6) {
                return new Response("Flight id must have 6 characters", Status.BAD_REQUEST);
            }

            for (int i = 0; i < 6; i++) {
                char c = id.charAt(i);
                if (i < 3) {
                    if (!Character.isLetter(c)) {
                        return new Response("The character " + (i + 1) + " of id must be a letter", Status.BAD_REQUEST);
                    } else if (!Character.isUpperCase(c)) {
                        return new Response("The character " + (i + 1) + " of id must be capitalized", Status.BAD_REQUEST);
                    }
                } else {
                    if (!Character.isDigit(c)) {
                        return new Response("The character " + (i + 1) + " of id must be a number", Status.BAD_REQUEST);
                    }
                }
            }

            //Se verifica que el id no exista
            if (searchStorage.getFlight(id) != null) {
                return new Response("There is already a flight with that id", Status.CONFLICT);
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

            // CAMBIAR USANDO EL SEARCHSTORAGE
            int i = 0;
            //Se busca el avion
            boolean found = false;
            Plane plane = searchStorage.getPlane(planeId);
            if (plane == null) {
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

            Location departureLocation = searchStorage.getLocation(departureLocationId);

            if (departureLocation == null) {
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

            //BUSQUEDA AQUI TAMBIEN
            Location arrivalLocation = searchStorage.getLocation(arrivalLocationId);
            if (arrivalLocation == null) {
                return new Response("In arrival, there is no location with that id", Status.NOT_FOUND);
            }

            if (arrivalLocation.equals(departureLocation)) {
                return new Response("Arrival location and departure location cannot be the same", Status.BAD_REQUEST);
            }

            //Se verifica que el año sea valido
            int yearInt, monthInt, dayInt, hourInt, minuteInt;
            if (year.equals("")) {
                return new Response("Year must be not empty", Status.BAD_REQUEST);
            }
            if (month.equals("Month")) {
                return new Response("Month must be not empty", Status.BAD_REQUEST);
            }
            if (day.equals("Day")) {
                return new Response("Day must be not empty", Status.BAD_REQUEST);
            }
            try {
                yearInt = Integer.parseInt(year);
            } catch (NumberFormatException e) {
                return new Response("Year must be a number", Status.BAD_REQUEST);
            }
            try {
                monthInt = Integer.parseInt(month);
            } catch (NumberFormatException e) {
                return new Response("Please, select a month", Status.BAD_REQUEST);
            }
            try {
                dayInt = Integer.parseInt(day);
            } catch (NumberFormatException e) {
                return new Response("Please, select a day", Status.BAD_REQUEST);
            }
            try {
                hourInt = Integer.parseInt(hour);
            } catch (NumberFormatException e) {
                return new Response("Please, select an hour", Status.BAD_REQUEST);
            }
            try {
                minuteInt = Integer.parseInt(minutes);
            } catch (NumberFormatException e) {
                return new Response("Please, select a minute", Status.BAD_REQUEST);
            }

            LocalDateTime departureDate;
            try {
                departureDate = LocalDateTime.of(yearInt, monthInt, dayInt, hourInt, minuteInt);
            } catch (DateTimeException e) {
                return new Response("Enter a valid date and hour", Status.BAD_REQUEST);
            }

            //En caso de escala
            Flight flight;
            if (!scaleId.equals("Location")) {
                Location scaleLocation = searchStorage.getLocation(scaleId);

                if (scaleLocation == null) {
                    return new Response("In scale, there is no location with that id", Status.NOT_FOUND);
                }

                if (arrivalLocation.equals(scaleLocation)) {
                    return new Response("Arrival location and scale location cannot be the same", Status.BAD_REQUEST);
                }

                if (scaleLocation.equals(departureLocation)) {
                    return new Response("Scale location and departure location cannot be the same", Status.BAD_REQUEST);
                }

                if (hoursDurationScale.equals("Hour")) {
                    return new Response("If the flight has a scale, please select an hour, otherwise, deselect location", Status.BAD_REQUEST);
                }

                if (minutesDurationScale.equals("Minute")) {
                    return new Response("If the flight has a scale, please select a minute, otherwise, deselect location", Status.BAD_REQUEST);
                }

            }
            // Se envia la respuesta
            return new Response("Flight registered succesfully", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
