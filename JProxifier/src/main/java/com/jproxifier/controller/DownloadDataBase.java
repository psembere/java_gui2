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
        DownloadItem item = new DownloadItem();
        item.isDownload=true;
        item.filename="some_legal_program.zip2";
        item.URLlink="http://rapidshare.com/dwr";
        item.dateAdded="Apr 17 2014 12:12 ";
        item.downloaded=50*1024;
        item.fileSize=102*1024;
        item.nice9=true;
        item.nice1=false;
        ret.add(item);
        item = new DownloadItem();
        item.isDownload=true;
        item.filename="foto.jpg";
        item.URLlink="http://rapidshare.com/dwr";
        item.dateAdded="Apr 17 2014 12:12 ";
        item.downloaded=20*1024;
        item.fileSize=102*1024;
        item.nice9=true;
        item.nice1=false;
        ret.add(item);
        isCreated=true;
    }
    
    ArrayList<DownloadItem> GetDownload() {
        return ret;
    }
}
