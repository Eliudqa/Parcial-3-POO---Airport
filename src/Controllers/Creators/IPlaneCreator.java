/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Creators;

import Models.Plane;

/**
 *
 * @author HOLA
 */
public interface IPlaneCreator {
        public Plane createPlane(String id, String brand, String model, String maxCapacity, String airline);

}
