/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.Storage.IStorageAddPlane;
import Controllers.Interfaces.Storage.IStorageGetPlanes;
import Models.Plane;
import ObserverPattern.IObservableAddStorage;
import ObserverPattern.IObservableNotifyStorage;
import ObserverPattern.IObserver;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PlanesStorage implements IStorageAddPlane, IStorageGetPlanes , IObservableAddStorage, IObservableNotifyStorage{
    
    
    // Singleton
    private static PlanesStorage instance;
    
    // ArrayList
    private ArrayList<Plane> planes;
    private final ArrayList<IObserver> observers = new ArrayList<>();
    
    
    private PlanesStorage() {
        planes = new ArrayList<>();
    }

    public static PlanesStorage getInstance() {
        if (instance == null) {
            instance = new PlanesStorage();
        }
        return instance;
    }
    
   
    @Override
    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
        notifyObservers();
    }
    
    @Override
    public void addPlane(Plane plane){
        this.planes.add(plane);
        notifyObservers();
    }

    @Override
    public ArrayList<Plane> getCopyPlanes() {
      return new ArrayList<>(this.planes);   
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
