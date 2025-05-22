/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import Models.Flight;
import java.time.LocalDateTime;

/**
 *
 * @author samit
 */
public interface IControllerFlights {
    void delay(Flight flight, int hours, int minutes);
    public LocalDateTime calculateArrivalDate(Flight flight);

}
