/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.controller;

import com.jproxifier.data.model.DownloadItem;
import java.util.ArrayList;

/**
 *
 * @author Piotr
 */
public class DownloadDataBase {
    
    static boolean isCreated = false;
    static DownloadDataBase instance = null;
    private ArrayList<DownloadItem> ret = new  ArrayList();

    public static DownloadDataBase getInstance() {
        if(instance==null)
            instance = new DownloadDataBase(1);
        return instance;
    }

    public DownloadDataBase() {
        throw new RuntimeException("DownloadDataBase can be created only once. Call to it using DownloadDataBase.getInstance()");
    }
    
    private DownloadDataBase(int i) {
        DownloadItem item = new DownloadItem(true, "some_legal_program.zip2", "http://rapidshare.com/dwr", "Apr 17, 2014 12:12:12", 50*1024, 102*1024, true, false);
        
        ret.add(item);
        isCreated=true;
    }
    
    ArrayList<DownloadItem> GetDownload() {
        return ret;
    }
}
