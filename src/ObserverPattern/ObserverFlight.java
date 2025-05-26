/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPattern;

import Controllers.Interfaces.Refreshers.IFlightsRefresher;
import core.controllers.utils.Response;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOLA
 */
public class ObserverFlight implements IObserver {
    
    private final IFlightsRefresher refresher;
    private final DefaultTableModel table;

    public ObserverFlight(IFlightsRefresher refresher, DefaultTableModel table) {
        this.refresher = refresher;
        this.table = table;
    }

    @Override
    public void update(Response trigger) {
        
        Response response = refresher.refreshFlights();
        table.setRowCount(0);
        if (response.getObject() != null) {
            for (Object[] row : (ArrayList<Object[]>) response.getObject()) {
                table.addRow(row);
            }
        }
    }
}

