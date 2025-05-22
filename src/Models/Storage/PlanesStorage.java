/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Flight;
import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PlanesStorage {
    
    
    // Singleton
    private static PlanesStorage instance;
    
    // ArrayList
    private ArrayList<Plane> planes;
    
    
    private PlanesStorage() {
        planes = new ArrayList<>();
    }

    public static PlanesStorage getInstance() {
        if (instance == null) {
            instance = new PlanesStorage();
        }
        return instance;
    }
    
    
    // Devuelve la lista entera de aviones
    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }
    
    
    public void addPlane(Plane plane){
        this.planes.add(plane);
    }
    
    
    
}
