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
import Controllers.Registers.RegisterFacade;
import Controllers.Registers.RegisterFlight;
import Controllers.Registers.RegisterLocation;
import Controllers.Registers.RegisterPassenger;
import Controllers.Registers.RegisterPlane;
import static jdk.jfr.FlightRecorder.register;

/**
 *
 * @author samit
 */
public class AppConfig {
     public MainController createMainController() {
        IGeneratorTime generatorTime = new GeneratorTime();  
        IRegister registerFacade = new RegisterFacade(
            new RegisterPassenger(),
            new RegisterPlane(),
            new RegisterLocation(),
            new RegisterFlight()
        );        IControllerFlights ICFlights = new ControllerFlights();
        return new MainController(generatorTime, registerFacade, ICFlights);
    }
}
