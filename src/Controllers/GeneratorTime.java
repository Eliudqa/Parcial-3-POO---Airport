/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.IGeneratorTime;
import java.util.ArrayList;
import static java.util.Calendar.MONTH;

/**
 *
 * @author Admin
 */
public class GeneratorTime implements IGeneratorTime{
    
    @Override
    public ArrayList<String> generateMonths() {
        ArrayList<String> months = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            months.add(""+i);
        }
        return months;
    }
    
    @Override
    public ArrayList<String> generateDays() {
        ArrayList<String> days = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            days.add(""+i);
        }
        return days;
    }
    
    @Override
    public ArrayList<String> generateHours() {
        ArrayList<String> hours = new ArrayList<>();
        for (int i = 1; i < 24; i++) {
            hours.add(""+i);
        }
        return hours;
    }
    
    @Override
    public ArrayList<String> generateMinutes() {
        ArrayList<String> minutes = new ArrayList<>();
        for (int i = 1; i < 60; i++) {
            minutes.add(""+i);
        }
        return minutes;
    }
    
    
}
