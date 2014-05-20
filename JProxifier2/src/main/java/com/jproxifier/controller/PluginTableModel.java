/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.controller;

import com.jproxifier.data.model.DownloadItem;
import com.jproxifier.data.model.PluginItem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Piotr
 */
public class PluginTableModel extends AbstractTableModel {

        
    private String[] columnNames = {"Plugin name", "Version", "Last updated", 
        "website",  "auto-enabled", "enabled", "warnings", "ram", "cpu%"};
    private ArrayList<PluginItem> dat= (new PluginData().GetPlugins());
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dat.size();
    }

    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        PluginItem rec = dat.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return rec.pluginName;
            case 1:
                return rec.version;
            case 2: 
                return rec.lastUpdated;
            case 3:               
                return rec.website;
            case 4:
                return rec.autoUpdate;
            case 5:
                return rec.enabled;
            case 6:
                return rec.warnings;
            case 7:
                return rec.ram;
            case 8:
                return rec.cpu;
            default:
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        }          
    }
    @Override public String getColumnName(int col) {
        return columnNames[col];
    
    }
    
}
