/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Creators;

import Models.Plane;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author HOLA
 */
public  class PlaneCreator implements IPlaneCreator {
    
    
    @Override
    public  Plane createPlane(String id, String brand, String model, String maxCapacity, String airline){
      
        return new Plane(id, brand, model, Integer.parseInt(maxCapacity), airline);
        
    }
}
