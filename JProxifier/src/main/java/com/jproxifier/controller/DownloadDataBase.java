/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.controller;

import com.jproxifier.data.model.DownloadItem;
import com.jproxifier.data.model.Listener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Piotr
 */
public class DownloadDataBase implements Runnable {
    
    static boolean isCreated = false;
    static DownloadDataBase instance = null;
    private ArrayList<DownloadItem> ret = new  ArrayList();

    public ArrayList<DownloadItem> getRet() {
        return ret;
    }

    public void setRet(ArrayList<DownloadItem> ret) {
        this.ret = ret;
    }

    public static DownloadDataBase getInstance() {
        if(instance==null)
            instance = new DownloadDataBase(1);
        return instance;
    }

    public DownloadDataBase() {
        throw new RuntimeException("DownloadDataBase can be created only once. Call to it using DownloadDataBase.getInstance()");
    }
    
    private DownloadDataBase(int i) {
        DownloadItem item = new DownloadItem(true, "some_legal_program.zip2", "http://rapidshare.com/dwr", "Apr 17, 2014 12:12:12", 50*1024, 102*1024, 7);
        ret.add(item);
        item = new DownloadItem(true, "foto.jpg", "http://rapidshare.com/dwr", "Apr 17, 2014 12:12:13", 20*1024, 201*1024, 9);
        ret.add(item);
        isCreated=true;
    }
    
    ArrayList<DownloadItem> GetDownload() {
        return ret;
    }

    void addGlobalListener(Listener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void run() {
        while(true) {
            try {
                //This kind of generating data probably results in races! Using synchronized required in future.
                Thread.sleep(1000);
                System.out.println("executing");
                ArrayList<DownloadItem> ret = getInstance().ret;
                DownloadItem item = ret.get(new java.util.Random().nextInt(ret.size()));
                item.setDownloaded(new java.util.Random().nextInt(item.getFileSize()));
            } catch (Throwable ex) {
//                Logger.getLogger(DownloadDataBase.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(DownloadDataBase.class.getName()).log(Level.SEVERE, null, "exception, probaly no items");
            }
        }
    }
}
