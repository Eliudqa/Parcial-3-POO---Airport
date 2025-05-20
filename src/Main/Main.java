/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Models.Storage.DataLoader;
import Models.Storage.Storage;
import java.io.IOException;

/**
 *
 * @author HOLA
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        Storage storage = Storage.getInstance();
        
        storage.setPassengers(DataLoader.LoadPassengers("src/json/passengers.json"));
        storage.setLocations(DataLoader.LoadLocations("src/json/locations.json"));
        storage.setPlanes(DataLoader.LoadPlanes("src/json/planes.json"));
        storage.setFlights(DataLoader.LoadFlights("src/json/flights.json"));
        
        
        
                
    }
}
