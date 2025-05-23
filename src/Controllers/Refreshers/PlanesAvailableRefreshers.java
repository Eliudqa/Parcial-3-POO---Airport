/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IPlanesAvailableRefreshers;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Plane;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PlanesAvailableRefreshers implements IPlanesAvailableRefreshers {
    
    private final IStorageGet ISG;

    public PlanesAvailableRefreshers(IStorageGet ISG) {
        this.ISG = ISG;
    }
    
    @Override
    public ArrayList<String> refreshAvailablePlanes(){
        ArrayList<Plane> planes = ISG.getPlanes();
        ArrayList<String> ids = new ArrayList<>();

        
        for (Plane p : planes) {
             Plane copy = p.copy(); // copia independiente

            ids.add(copy.getId()+"");
        }
        
        return ids;
        
      } 
}
