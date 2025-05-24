/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Sorts;

import Models.Flight;
import Models.Location;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author HOLA
 */
public class SortFlights implements ISortFlights {
    
    @Override
    public ArrayList<Flight> sortFlights(ArrayList<Flight> flights){
       flights.sort(Comparator.comparing(Flight::getDepartureDate));
       return flights;
    }
}
