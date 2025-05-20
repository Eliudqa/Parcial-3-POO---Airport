/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Storage;

import Models.Flight;
import Models.Location;
import Models.Passenger;
import Models.Plane;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HOLA
 */
public abstract class DataLoader {

    public static ArrayList<Passenger> LoadPassengers(String path) throws IOException {
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

    public static ArrayList<Location> LoadLocations(String path) throws IOException {
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

    public static ArrayList<Plane> LoadPlanes(String path) throws IOException {
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

    public static ArrayList<Flight> LoadFlights(String path) throws IOException {
        ArrayList<Flight> flights = new ArrayList<>();
        String content = Files.readString(Paths.get(path));
        JSONArray array = new JSONArray(content);
        for (int i = 0; i < array.length(); i++) {
            JSONObject o = array.getJSONObject(i);

            String id = o.getString("id");
            String planeId = o.getString("planeId");
            String departureId = o.getString("departure");
            String arrivalId = o.getString("arrival");
            String scaleId = o.optString("scale", null);
            String departureDateStr = o.getString("departureDate");
            int hoursArrival = o.getInt("hoursDurationArrival");
            int minutesArrival = o.getInt("minutesDurationArrival");
            int hoursScale = o.optInt("hoursDurationScale", 0);
            int minutesScale = o.optInt("minutesDurationScale", 0);            

        }

        
        
        
        
        
        
    }
}
