/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddLocation;
import Controllers.Interfaces.Storage.IStorageGetLocations;
import Models.Location;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationsStorage implements IStorageAddLocation, IStorageGetLocations{

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

    @Override
    public ArrayList<Location> getLocations() {
        return locations;
    }

    @Override
    public void addLocation(Location location){
        this.locations.add(location);
    }
}
