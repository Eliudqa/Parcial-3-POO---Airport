/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author samit
 */
public interface IGeneratorTime {

    ArrayList<String> generateMonths();

    ArrayList<String> generateDays();

    ArrayList<String> generateMinutes();

    ArrayList<String> generateHours();
}
