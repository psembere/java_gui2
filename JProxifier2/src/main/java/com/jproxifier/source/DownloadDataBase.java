/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.source;

import com.jproxifier.data.models.DownloadItem;
import java.util.ArrayList;

/**
 *
 * @author Piotr
 */
public class DownloadDataBase {
    
    ArrayList<DownloadItem> GetDownload() {
        
        ArrayList<DownloadItem> ret = new  ArrayList();
        
        DownloadItem item = new DownloadItem();
        item.isDownload="true";
        item.filename="some_legal_program.zip";
        item.URLlink="http://rapidshare.com/dwr";
        item.dateAdded="Apr 17 2014 12:12 ";
        item.downloaded="50MB";
        item.fileSize="102MB";
        item.nice9="yes";
        item.nice1="no";
        
        
        ret.add(item);       
        return ret;
    } 
}
