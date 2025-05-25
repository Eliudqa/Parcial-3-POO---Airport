/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddLocation;
import Controllers.Interfaces.Storage.IStorageGetLocations;
import Models.Location;
import ObserverPattern.IObservableAddStorage;
import ObserverPattern.IObservableNotifyStorage;
import ObserverPattern.IObserver;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class LocationsStorage implements IStorageAddLocation, IStorageGetLocations, IObservableAddStorage, IObservableNotifyStorage {

    // Singleton
    private static LocationsStorage instance;

    private ArrayList<Location> locations;
    private final ArrayList<IObserver> observers = new ArrayList<>();

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
        notifyObservers();

    }

    @Override
    public ArrayList<Location> getLocations() {
        return locations;
    }

    @Override
    public void addLocation(Location location) {
        this.locations.add(location);
        notifyObservers();

    }

    @Override
    public ArrayList<Location> getCopyLocations() {
        return new ArrayList<>(this.locations);
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

}
