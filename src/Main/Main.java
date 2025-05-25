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
import View.AirportFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import config.AppConfig;
import java.io.IOException;
import javax.swing.UIManager;

/**
 *
 * @author HOLA
 */
public class Main {

    public static void main(String[] args) throws IOException {
        AppConfig config = new AppConfig();
        DataLoader dataLoader = config.createDataLoader();

        PassengersStorage passengersStorage = PassengersStorage.getInstance();
        LocationsStorage locationsStorage = LocationsStorage.getInstance();
        PlanesStorage planesStorage = PlanesStorage.getInstance();
        FlightsStorage flightsStorage = FlightsStorage.getInstance();

        // Establece el LookAndFeel (FlatDarkLaf)
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // Crear y mostrar el formulario en el hilo adecuado
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AirportFrame().setVisible(true); // Aquí se inicializa el JFrame
            }
        });

        
        // Hacemos esto porque primero se ejecuta el main antes que la vista, en donde se inicializa appconfig para crear los observer
        try {
            Thread.sleep(500); // medio segundo}
            passengersStorage.setPassengers(dataLoader.LoadPassengers("src/json/passengers.json"));
            locationsStorage.setLocations(dataLoader.LoadLocations("src/json/locations.json"));
            planesStorage.setPlanes(dataLoader.LoadPlanes("src/json/planes.json"));
            flightsStorage.setFlights(dataLoader.LoadFlights("src/json/flights.json"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
