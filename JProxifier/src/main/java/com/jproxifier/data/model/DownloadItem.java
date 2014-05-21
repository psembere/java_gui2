/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.data.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JRadioButton;

/**
 *
 * @author Piotr
 */
@lombok.Getter //this makes automatically getters and others! 
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class DownloadItem extends Observable {
    public Boolean download;
    public String filename;
    public String URLlink;
    public String dateAdded;
    //downloaded [bytes]
    public Integer downloaded;
    //total file size in [bytes]
    public Integer fileSize;
    public Integer priority;

    public void setPriority(Integer priority) {
        callAllListeners();
        this.priority = priority;
    }
    
    public int getProgress() {
        callAllListeners();
        return downloaded*100/fileSize;
    }

    public void setDownload(Boolean isDownload) {
        callAllListeners();
        this.download = isDownload;
    }

    public void setFilename(String filename) {
        callAllListeners();
        this.filename = filename;
    }

    public void setURLlink(String URLlink) {
        callAllListeners();
        this.URLlink = URLlink;
    }

    public void setDateAdded(String dateAdded) {
        callAllListeners();
        this.dateAdded = dateAdded;
    }

    public void setDownloaded(Integer downloaded) {
        callAllListeners();
        this.downloaded = downloaded;
    }

    public void setFileSize(Integer fileSize) {
        callAllListeners();
        this.fileSize = fileSize;
    }
    
    
}
