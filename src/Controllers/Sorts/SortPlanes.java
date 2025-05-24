/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Sorts;

import Models.Plane;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author HOLA
 */
public class SortPlanes implements ISortPlanes {
    
    @Override
    public ArrayList<Plane> sortPlanes(ArrayList<Plane> planes){
       planes.sort(Comparator.comparing(Plane::getId));
       return planes;
        
    }
}
