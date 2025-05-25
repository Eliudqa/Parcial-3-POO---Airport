/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPattern;

/**
 *
 * @author HOLA
 */

import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import core.controllers.utils.Response;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

 public class ObserverLocation implements IObserver {
    
    private final ILocationsRefreshers refresher;
    private final DefaultTableModel table;

    public ObserverLocation(ILocationsRefreshers refresher, DefaultTableModel table) {
        this.refresher = refresher;
        this.table = table;
    }

    @Override
    public void update() {
        
       
        Response response = refresher.refreshLocations();
        table.setRowCount(0);
        if (response.getObject() != null) {
            for (Object[] row : (ArrayList<Object[]>) response.getObject()) {
                table.addRow(row);
            }
        }
    }
}