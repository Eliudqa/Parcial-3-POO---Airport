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
public interface IRegisterLocation {
    Response registerLocation(String id, String name,String  city,String  country, String latitude, String longitude);

}
