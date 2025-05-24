/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IPlanesRefreshers;
import Controllers.Interfaces.Storage.IStorageGet;
import Controllers.Sorts.ISortPlanes;
import Models.Plane;
import core.controllers.utils.Response;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class PlanesRefreshers implements IPlanesRefreshers {

    private final IStorageGet ISG;
    private final ISortPlanes ISP;

    public PlanesRefreshers(IStorageGet ISG,ISortPlanes ISP) {
        this.ISG = ISG;
        this.ISP = ISP;
    }

    @Override
    public Response refreshPlanes() {
        ArrayList<Plane> planes = ISG.getCopyPlanes();

        if (planes.isEmpty()) {
            return new Response("No airplanes registered", 404);
        }
        
        ISP.sortPlanes(planes);
        ArrayList<Object[]> rows = new ArrayList<>();
        for (Plane p : planes) {
            Plane copy = p.copy(); // copia independiente

            rows.add(new Object[]{
                copy.getId(),
                copy.getBrand(),
                copy.getModel(),
                copy.getMaxCapacity(),
                copy.getAirline(),
                copy.getNumFlights()
            });
        }

        return new Response("Planes loaded succesfully", 200, rows);
    }
}
