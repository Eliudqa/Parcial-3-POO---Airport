/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Sorts;

import Models.Flight;
import Models.Passenger;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author HOLA
 */
public class SortPassengers implements ISortPassengers {
    
    @Override
    public ArrayList<Passenger> sortPassengers(ArrayList<Passenger> passengers){
 
       passengers.sort(Comparator.comparing(Passenger::getId));
       return passengers;
    }

  
    
}
