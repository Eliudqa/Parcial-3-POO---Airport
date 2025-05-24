/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Sorts;

import Models.Location;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author HOLA
 */
public class SortLocations implements ISortLocations {
    
    @Override
    public ArrayList<Location> sortLocations(ArrayList<Location> locations){
       locations.sort(Comparator.comparing(Location::getAirportId));
       return locations;
    }
}
