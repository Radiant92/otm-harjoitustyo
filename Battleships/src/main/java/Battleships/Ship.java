/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;

/**
 *
 * @author strohm
 */
public class Ship{
    private boolean sunken;
    private int size;
    private String form;
    
    public Ship(int size, String form){
        this.sunken = false;
        this.size = size;
        this.form = form;
    }

    public boolean isSunken() {
        return sunken;
    }

    public int getSize() {
        return size;
    }
    public String getForm(){
        return form;
    }
}
