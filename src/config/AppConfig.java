/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import Controllers.GeneratorTime;
import Controllers.Interfaces.IGeneratorTime;
import Controllers.Interfaces.IRegister;
import Controllers.MainController;
import Controllers.PassangerController;
import Controllers.Register;

/**
 *
 * @author samit
 */
public class AppConfig {
     public MainController createMainController() {
        IGeneratorTime generatorTime = new GeneratorTime();  
        IRegister register = new Register();
        return new MainController(generatorTime, register);
    }
}
