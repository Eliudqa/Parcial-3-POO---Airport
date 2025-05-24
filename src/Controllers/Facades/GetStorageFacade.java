/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;

import Controllers.Interfaces.Storage.IStorageGet;
import Controllers.Interfaces.Storage.IStorageGetFlights;
import Controllers.Interfaces.Storage.IStorageGetLocations;
import Controllers.Interfaces.Storage.IStorageGetPassengers;
import Controllers.Interfaces.Storage.IStorageGetPlanes;
import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public class GetStorageFacade implements IStorageGet {

    private final IStorageGetPlanes isgpl;
    private final IStorageGetFlights isgf;
    private final IStorageGetLocations isgl;
    private final IStorageGetPassengers isgpa;

    public GetStorageFacade(IStorageGetPlanes isgpl, IStorageGetFlights isgf, IStorageGetLocations isgl, IStorageGetPassengers isgpa) {
        this.isgpl = isgpl;
        this.isgf = isgf;
        this.isgl = isgl;
        this.isgpa = isgpa;
    }

    @Override
    public ArrayList<Plane> getPlanes() {
        return isgpl.getPlanes();
    }

    @Override
    public ArrayList<Location> getLocations() {
        return isgl.getLocations();
    }

    @Override
    public ArrayList<Passenger> getPassengers() {
        return isgpa.getPassengers();
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return isgf.getFlights();
    }

    @Override
    public ArrayList<Plane> getCopyPlanes() {
        return isgpl.getCopyPlanes();
    }

    @Override
    public ArrayList<Location> getCopyLocations() {
        return isgl.getCopyLocations();

    }

    @Override
    public ArrayList<Passenger> getCopyPassengers() {
        return isgpa.getCopyPassengers();

    }

    @Override
    public ArrayList<Flight> getCopyFlights() {
        return isgf.getCopyFlights();

    }
}
