/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Interfaces;

import core.controllers.utils.Response;

/**
 *
 * @author HOLA
 */
public interface IUpdateInfo {
    public Response updatePassenger(String id, String firstName, String lastName,
            String year, String month, String day,
            String phoneCode, String phone, String country);
}
