/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.controller;

import com.jproxifier.data.model.DownloadItem;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;
import static sun.security.krb5.internal.Krb5.DEBUG;

/**
 *
 * @author Piotr
 */
public class DownloadTableModel extends AbstractTableModel {

        
    private String[] columnNames = {"Download", "Filename", "URL link", "Date added",
    "downloaded", "file size", "nice9", "nice1"};
    private ArrayList<DownloadItem> dat= (new DownloadDataBase().GetDownload());
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dat.size();
    }

    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DownloadItem rec = dat.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return rec.isDownload;
            case 1:
                return rec.filename;
            case 2: 
                return rec.URLlink;
            case 3:               
                return rec.dateAdded;
            case 4:
                return rec.downloaded;
            case 5:
                return rec.fileSize;
            case 6:
                JRadioButton n9=new JRadioButton();
                n9.setSelected(rec.nice9);
                //n9.setSelected();
                //n9.set
                return n9;
            case 7:
                JRadioButton n1=new JRadioButton();
                n1.setSelected(rec.nice1);
                return n1;
            default:
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        }          
    }
    public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            return true;
        }
   public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
            DownloadItem item = dat.get(row);
            if(col==0) {
                item.isDownload= (Boolean) value;
            }
            if(col==7) {
                JRadioButton b= (JRadioButton)value;
                if(b.isSelected()) {
                    item.nice1=false;
                    //System.out.println("sssa1");
                }
                else {
                    item.nice1=true;
                     item.n1.setSelected(true);
                     //System.out.println("sssa");
                }
               
            }
            dat.set(row, item);
          
            fireTableCellUpdated(row, col);
 
            if (DEBUG) {
                System.out.println("New value of data:");
        //        printDebugData();
            }
        }
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    @Override public String getColumnName(int col) {
        return columnNames[col];
    
    }
    
}
