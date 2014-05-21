/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier.data.model;

import java.util.LinkedList;

/**
 *
 * @author azochniak
 */
abstract public class Observable extends LinkedList<Listener> {

    public void callAllListeners() {
        for (Listener listener : this) {
            listener.call();
        }
    }
    
}
