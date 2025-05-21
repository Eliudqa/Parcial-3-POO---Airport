/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Flight;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class ControllerFlights {

    public static void delay(Flight flight, int hours, int minutes) {
        flight.setDepartureDate(flight.getDepartureDate().plusHours(hours).plusMinutes(minutes));
    }

    public static LocalDateTime calculateArrivalDate(Flight flight) {
        return flight.getDepartureDate().plusHours(flight.getHoursDurationScale()).plusHours(flight.getHoursDurationArrival()).plusMinutes(flight.getMinutesDurationScale()).plusMinutes(flight.getMinutesDurationArrival());
    }

}
