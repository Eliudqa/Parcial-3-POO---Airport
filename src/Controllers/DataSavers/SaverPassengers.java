/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.DataSavers;

import Models.Passenger;
import Models.Storage.PassengersStorage;

/**
 *
 * @author samit
 */
public abstract class SaverPassengers {
    public static void addPassenger(Passenger passenger){
        PassengersStorage.getInstance().addPassenger(passenger);
    }
}
