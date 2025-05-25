/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddFlight;
import Controllers.Interfaces.Storage.IStorageGetFlights;
import Models.Flight;
import ObserverPattern.IObserver;
import core.controllers.utils.Response;
import java.util.ArrayList;
import ObserverPattern.IObservableAddStorage;
import ObserverPattern.IObservableNotifyStorage;

/**
 *
 * @author HOLA
 */
public class FlightsStorage implements IStorageAddFlight, IStorageGetFlights, IObservableAddStorage, IObservableNotifyStorage {
    
    // Singleton
    private static FlightsStorage instance;
    
    //ArrayList
    private ArrayList<Flight> flights;
    private final ArrayList<IObserver> observers = new ArrayList<>();

    
    
    private FlightsStorage() {
        flights = new ArrayList<>();
    }

    public static FlightsStorage getInstance() {
        if (instance == null) {
            instance = new FlightsStorage();
        }
        return instance;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
        notifyObservers(new Response("Flights loaded succesfully", 200, flights));

    }

    @Override
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
    
    @Override
    public void addFlight(Flight flight){
        this.flights.add(flight);
        notifyObservers(new Response("Flights loaded succesfully", 200, flights));

    }

    @Override
    public ArrayList<Flight> getCopyFlights() {
        return new ArrayList<>(this.flights);
    }
     
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    
    @Override
    public void notifyObservers(Response response) {
        for (IObserver observer : observers) {
            observer.update(response);
        }
    }

  
    
    
}
