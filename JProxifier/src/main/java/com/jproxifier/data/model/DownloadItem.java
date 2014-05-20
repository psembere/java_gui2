/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.data.model;

import javax.swing.JRadioButton;

/**
 *
 * @author Piotr
 */
@lombok.Data //this makes automatically getters and others! 
public class DownloadItem {
    public Boolean isDownload;
    public String filename;
    public String URLlink;
    public String dateAdded;
    //downloaded [bytes]
    public Integer downloaded;
    //total file size in [bytes]
    public Integer fileSize;
    public Boolean nice9;
    public Boolean nice1;

    public int getProgress() {
        return downloaded*100/fileSize;
    }

    
    
}
