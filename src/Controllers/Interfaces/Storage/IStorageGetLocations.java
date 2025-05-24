/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces.Storage;

import Models.Location;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public interface IStorageGetLocations {
    ArrayList<Location> getLocations();
    ArrayList<Location> getCopyLocations();

}
