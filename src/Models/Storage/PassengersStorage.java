/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddPassenger;
import Controllers.Interfaces.Storage.IStorageGetPassengers;
import Models.Passenger;
import ObserverPattern.IObservableAddStorage;
import ObserverPattern.IObservableNotifyStorage;
import ObserverPattern.IObserver;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PassengersStorage implements IStorageAddPassenger, IStorageGetPassengers, IObservableAddStorage, IObservableNotifyStorage {

    // Singleton
    private static PassengersStorage instance;

    //ArrayList
    private ArrayList<Passenger> passengers;
    private final ArrayList<IObserver> observers = new ArrayList<>();

    private PassengersStorage() {
        passengers = new ArrayList<>();
    }

    public static PassengersStorage getInstance() {
        if (instance == null) {
            instance = new PassengersStorage();
        }
        return instance;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
        notifyObservers();

    }

    @Override
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
        notifyObservers();
    }

    @Override
    public ArrayList<Passenger> getCopyPassengers() {
        return new ArrayList<>(this.passengers);
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
