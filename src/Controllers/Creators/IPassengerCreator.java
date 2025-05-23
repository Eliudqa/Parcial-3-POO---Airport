/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Creators;

import Models.Passenger;

/**
 *
 * @author HOLA
 */
public interface IPassengerCreator {
    public Passenger createPassenger(String id, String firstName, String lastName,
            String year, String  month, String day,
            String phoneCode, String phone, String country);
}
