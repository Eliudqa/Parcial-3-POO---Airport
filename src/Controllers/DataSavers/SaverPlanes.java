/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.DataSavers;

import Models.Plane;
import Models.Storage.PlanesStorage;

/**
 *
 * @author samit
 */
public abstract class SaverPlanes {
    public static void addPlane(Plane plane){
        PlanesStorage.getInstance().addPlane(plane);
    }
}
