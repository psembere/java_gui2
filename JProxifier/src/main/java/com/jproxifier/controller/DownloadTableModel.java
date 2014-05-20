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

/**
 *
 * @author Piotr
 */
public class DownloadTableModel extends AbstractTableModel {

    boolean DEBUG = true;
    private String[] columnNames = {"Download", "Filename", "URL link", "Date added",
    "downloaded MB", "file size MB", "nice9", "nice1"};
    private ArrayList<DownloadItem> dat = (DownloadDataBase.getInstance().GetDownload());

    public ArrayList<DownloadItem> getData() {
        return dat;
    }
    
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dat.size();
    }

    public DownloadItem getRowAt(int index) {
        return dat.get(index);
    
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
                return Integer.toString(rec.downloaded/1024)+" MB";
            case 5:
                return Integer.toString(rec.fileSize/1024)+" MB";
            case 6:
                JRadioButton n9=new JRadioButton();
                n9.setSelected(rec.nice9);
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
                    item.nice9=true;
                    //item.no
                    
                }
                else {
                    item.nice1=true;
                    item.nice9=false;
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
