/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IRegisterPassenger {
        Response registerPassenger(String id, String firstName, String lastName, String year, int month, int day, String phoneCode, String phone, String country);

}
