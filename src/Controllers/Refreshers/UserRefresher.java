/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Refreshers;

import Models.Passenger;
import Models.Storage.PassengersStorage;
import java.util.ArrayList;

/**
 *
 * @author HOLA
 */
public class UserRefresher implements IUserRefresher {
    
    @Override
    public ArrayList<String> refreshUser(){
        ArrayList<Passenger> passengers = PassengersStorage.getInstance().getPassengers();
        ArrayList<String> ids = new ArrayList<>();

        
        for (Passenger p : passengers) {
            ids.add(p.getId()+"");
        }
        
        return ids;
        
      } 
}
