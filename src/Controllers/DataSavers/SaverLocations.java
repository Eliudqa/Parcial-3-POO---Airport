/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.DataSavers;

import Models.Location;
import Models.Storage.LocationsStorage;

/**
 *
 * @author samit
 */
public abstract class SaverLocations {
    public static void addLocation(Location location){
        LocationsStorage.getInstance().addLocation(location);
    }
}
