/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.controller;

import com.jproxifier.data.model.DownloadItem;
import com.jproxifier.data.model.Listener;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Piotr
 */
public class DownloadTableModel extends AbstractTableModel {

    boolean DEBUG = true;
    private String[] columnNames = {"Download", "Filename", "URL link", "Date added",
    "downloaded MB", "file size MB", "nice1", "nice9"};
    private ArrayList<DownloadItem> dat = null;

    public DownloadTableModel() {
        new Thread(DownloadDataBase.getInstance()).start();
        updateData();
    }
    
    final public void updateData() {
        dat = (DownloadDataBase.getInstance().GetDownload());
        for (int i = 0; i < dat.size(); i++) {
            
            DownloadItem item = dat.get(i);
            item.add(new Listener() {
                Integer r;

                public Listener setR(Integer r) {
                    this.r = r;
                    return this;
                }
                
                @Override
                public void call() {
                    fireTableRowsUpdated(r, r);
                }
                
            }.setR(i));
        }
 
    }

    public ArrayList<DownloadItem> getData() {
        return dat;
    }
    
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
                return rec.getDownload();
            case 1:
                return rec.filename;
            case 2: 
                return rec.URLlink;
            case 3:               
                return rec.dateAdded;
            case 4:
                return Integer.toString(rec.downloaded/1024)+" MB";
            case 5:
                return Integer.toString(rec.fileSize/1024)+" MB";
            case 6:
                JRadioButton n1=new JRadioButton();
                n1.setSelected(rec.getPriority()<9);
                return n1;
            case 7:
                JRadioButton n9=new JRadioButton();
                n9.setSelected(rec.getPriority()>=9);
                return n9;
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
                item.setDownload((Boolean) value);
            }
            else if(col==6) {
                JRadioButton b= (JRadioButton)value;
                item.priority=1;
            }
            else if(col==7) {
                JRadioButton b= (JRadioButton)value;
                item.priority=9;
            }

            dat.set(row, item);
          
            fireTableRowsUpdated(row, row);
 
            if (DEBUG) {
                System.out.println("New value of data:"+ item);
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
