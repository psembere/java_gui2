/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.source;

import com.jproxifier.data.models.DownloadItem;
import com.jproxifier.data.models.PluginItem;
import java.util.ArrayList;

/**
 *
 * @author Piotr
 */
public class PluginData {
        ArrayList<PluginItem> GetPlugins() {
        
        ArrayList<PluginItem> ret = new  ArrayList();
        
        PluginItem item = new PluginItem();
        item.pluginName="Proxy functionality";
        item.version="1.0";
        item.lastUpdated="today(Apr 22)";
        item.website= "-";
        item.autoUpdate="yes";
        item.enabled="-";
        item.warnings="";
        item.ram ="";
        item.cpu="";               
        ret.add(item);    
        
        item = new PluginItem();
        item.pluginName="Sequencial dowloading files means next party";
        item.version="1.0";
        item.lastUpdated="9 days ago";
        item.website= "-";
        item.autoUpdate="yes";
        item.enabled="";
        item.warnings="incompatible with 1 plugin";
        item.ram ="";
        item.cpu="";               
        ret.add(item);  
        
        item = new PluginItem();
        item.pluginName="Speed charts";
        item.version="1.0";
        item.lastUpdated="year ago";
        item.website= "-";
        item.autoUpdate="yes";
        item.enabled="yes";
        item.warnings="incompatible with 1 plugin";
        item.ram ="";
        item.cpu="";               
        ret.add(item);
        
        item = new PluginItem();
        item.pluginName="Undoable settings";
        item.version="1.0";
        item.lastUpdated="today";
        item.website= "-";
        item.autoUpdate="yes";
        item.enabled="yes";
        item.warnings="incompatible with 1 plugin";
        item.ram ="1MB";
        item.cpu="1%";               
        ret.add(item);
        
            
        return ret;
    } 
}
