/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import Controllers.ControllerFlights;
import Controllers.GeneratorTime;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Controllers.MainController;
import Controllers.Interfaces.IControllerFlights;
import Controllers.Register;

/**
 *
 * @author samit
 */
public class AppConfig {
     public MainController createMainController() {
        IGeneratorTime generatorTime = new GeneratorTime();  
        IRegister register = new Register();
        IControllerFlights ICFlights = new ControllerFlights();
        return new MainController(generatorTime, register, ICFlights);
    }
}
