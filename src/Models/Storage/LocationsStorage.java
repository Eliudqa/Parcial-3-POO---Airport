/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Location;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationsStorage {

    // Singleton
    private static LocationsStorage instance;

    private ArrayList<Location> locations;

    private LocationsStorage() {
        locations = new ArrayList<>();
    }

    public static LocationsStorage getInstance() {
        if (instance == null) {
            instance = new LocationsStorage();
        }
        return instance;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }


}
