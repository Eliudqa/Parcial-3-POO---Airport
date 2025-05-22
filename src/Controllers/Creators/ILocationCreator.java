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
public interface ILocationCreator {
    public Location createLocation(String id, String name, String city, String country, String latitude, String longitude);

}
