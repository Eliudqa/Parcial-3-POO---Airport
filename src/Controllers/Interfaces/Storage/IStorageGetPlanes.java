/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces.Storage;

import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public interface IStorageGetPlanes {
    ArrayList<Plane> getPlanes();
    ArrayList<Plane> getCopyPlanes();

}
