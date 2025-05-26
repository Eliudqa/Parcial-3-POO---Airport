/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPattern;

import Controllers.Interfaces.Refreshers.ILocationsRefreshers;
import Controllers.Interfaces.Refreshers.IPlanesRefreshers;
import core.controllers.utils.Response;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samit
 */
public class ObserverPlane  implements IObserver{
    private final IPlanesRefreshers refresher;
    private final DefaultTableModel table;

    public ObserverPlane(IPlanesRefreshers refresher, DefaultTableModel table) {
        this.refresher = refresher;
        this.table = table;
    }

    
    @Override
    public void update() {
        
        Response response = refresher.refreshPlanes();
        
        table.setRowCount(0);
        if (response.getObject() != null) {
            for (Object[] row : (ArrayList<Object[]>) response.getObject()) {
                table.addRow(row);
            }
        }
    }
}
