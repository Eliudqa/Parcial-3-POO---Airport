/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Models.Storage.DataLoader;
import Models.Storage.FlightsStorage;
import Models.Storage.LocationsStorage;
import Models.Storage.PassengersStorage;
import Models.Storage.PlanesStorage;
import java.io.IOException;

/**
 *
 * @author HOLA
 */
public class Main {
    public static void main(String[] args) throws IOException {       
        
        PassengersStorage passengersStorage = PassengersStorage.getInstance();
        LocationsStorage locationsStorage = LocationsStorage.getInstance();
        PlanesStorage planesStorage = PlanesStorage.getInstance();
        FlightsStorage flightsStorage = FlightsStorage.getInstance();
        
        passengersStorage.setPassengers(DataLoader.LoadPassengers("src/json/passengers.json"));
        locationsStorage.setLocations(DataLoader.LoadLocations("src/json/locations.json"));
        planesStorage.setPlanes(DataLoader.LoadPlanes("src/json/planes.json"));
        flightsStorage.setFlights(DataLoader.LoadFlights("src/json/flights.json"));
        System.out.println("Pasajeros cargados: " + passengersStorage.getPassengers().size());

        
        
}
}
