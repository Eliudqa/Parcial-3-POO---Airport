/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import ObserverPattern.IObservableAddStorage;
import ObserverPattern.IObservableNotifyStorage;
import ObserverPattern.IObserver;
import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class Plane implements IObservableAddStorage, IObservableNotifyStorage{

    private final String id;
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private ArrayList<Flight> flights;
    
    private final ArrayList<IObserver> observers = new ArrayList<>();

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
        notifyObservers();
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public int getNumFlights() {
        return flights.size();
    }

    public Plane copy() {
        Plane copied = new Plane(id, brand, model, maxCapacity, airline);

        // Copiar vuelos también 
        for (Flight f : this.flights) {
            copied.addFlight(f);
        }

        return copied;

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
