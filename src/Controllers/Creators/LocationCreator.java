/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Creators;

import Models.Location;

/**
 *
 * @author HOLA
 */
public abstract class LocationCreator {
    
    
    public static Location createLocation(String id, String name, String city, String country, String latitude, String longitude){
        return new Location(id, name, city, country, Double.parseDouble(latitude), Double.parseDouble(longitude));
    }
}
