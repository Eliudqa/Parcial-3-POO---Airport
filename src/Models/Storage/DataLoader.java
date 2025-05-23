/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Controllers.Interfaces.ISearchStorage;
import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HOLA
 */

// Clase que se encarga de cargar los datos del Json, crear los objetos y añadirlos a los storage correspondientes
public class DataLoader {
    
    private final ISearchStorage searchStorage;
    
    public DataLoader(ISearchStorage searchStorage){
        this.searchStorage = searchStorage;
    }

    public ArrayList<Passenger> LoadPassengers(String path) throws IOException {
        ArrayList<Passenger> passengers = new ArrayList<>();
        String content = Files.readString(Paths.get(path));
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject o = array.getJSONObject(i);

            passengers.add(new Passenger(
                    o.getLong("id"),
                    o.getString("firstname"),
                    o.getString("lastname"),
                    LocalDate.parse(o.getString("birthDate")),
                    o.getInt("countryPhoneCode"),
                    o.getLong("phone"),
                    o.getString("country")
            ));

        }

        return passengers;

    }

    public ArrayList<Location> LoadLocations(String path) throws IOException {
        ArrayList<Location> locations = new ArrayList<>();
        String content = Files.readString(Paths.get(path));
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject o = array.getJSONObject(i);

            locations.add(new Location(
                    o.getString("airportId"),
                    o.getString("airportName"),
                    o.getString("airportCity"),
                    o.getString("airportCountry"),
                    o.getDouble("airportLatitude"),
                    o.getDouble("airportLongitude")
            ));

        }

        return locations;

    }

    public ArrayList<Plane> LoadPlanes(String path) throws IOException {
        ArrayList<Plane> planes = new ArrayList<>();
        String content = Files.readString(Paths.get(path));
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject o = array.getJSONObject(i);

            planes.add(new Plane(
                    o.getString("id"),
                    o.getString("brand"),
                    o.getString("model"),
                    o.getInt("maxCapacity"),
                    o.getString("airline")
            ));
           

        }

        return planes;

    }

    public ArrayList<Flight> LoadFlights(String path) throws IOException {
        ArrayList<Flight> flights = new ArrayList<>();
        String content = Files.readString(Paths.get(path));
        JSONArray array = new JSONArray(content);
        for (int i = 0; i < array.length(); i++) {
            JSONObject o = array.getJSONObject(i);

            String id = o.getString("id");
            String planeId = o.getString("plane");
            String departureId = o.getString("departureLocation");
            String arrivalId = o.getString("arrivalLocation");
            String scaleId = o.optString("scaleLocation", null);
            LocalDateTime departureDate = LocalDateTime.parse(o.getString("departureDate"));
            int hoursArrival = o.getInt("hoursDurationArrival");
            int minutesArrival = o.getInt("minutesDurationArrival");
            int hoursScale = o.optInt("hoursDurationScale", 0);
            int minutesScale = o.optInt("minutesDurationScale", 0);

            Plane plane = searchStorage.getPlane(planeId);
            Location departure = searchStorage.getLocation(departureId);
            Location arrival = searchStorage.getLocation(arrivalId);

            if (scaleId != null) {
                Location scale = searchStorage.getLocation(scaleId);
                flights.add(new Flight(
                        id, plane, departure,
                        scale, arrival, departureDate, hoursArrival,
                        minutesArrival, hoursScale, minutesScale));
            } else {
                flights.add(new Flight(
                        id, plane, departure,
                        arrival, departureDate, hoursArrival,
                        minutesArrival
                ));
                
            }
            plane.addFlight(flights.get(i));
        }
        
        return flights;

    }
}
