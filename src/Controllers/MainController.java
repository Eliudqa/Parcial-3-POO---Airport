/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IGeneratorTime;
import java.util.ArrayList;

/**
 *
 * @author samit
 */
public class MainController {

    private final IGeneratorTime timeGenerator;

    public MainController(IGeneratorTime timeGenerator) {
        this.timeGenerator = timeGenerator;
    }

    public  ArrayList<String> generateMonths() {
        return timeGenerator.generateMonths();
    }

    public  ArrayList<String> generateDays() {
        return timeGenerator.generateDays();
    }

    public  ArrayList<String> generateMinutes() {
        return timeGenerator.generateMinutes();
    }

    public  ArrayList<String> generateHours() {
        return timeGenerator.generateHours();
    }
}
