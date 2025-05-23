/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Controllers.Interfaces.Refreshers.IUserRefresher;
import Controllers.Interfaces.Storage.IStorageGet;
import Models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class UserRefresher implements IUserRefresher {

    private final IStorageGet ISG;

    public UserRefresher(IStorageGet ISG) {
        this.ISG = ISG;
    }

    @Override
    public ArrayList<String> refreshUser() {
        ArrayList<Passenger> passengers = ISG.getPassengers();
        ArrayList<String> ids = new ArrayList<>();

        for (Passenger p : passengers) {
            Passenger copy = p.copy(); // copia independiente

            ids.add(copy.getId() + "");
        }

        return ids;

    }
}
