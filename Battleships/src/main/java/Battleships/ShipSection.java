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
public class ShipSection {

    private int x;
    private int y;
    private boolean intact;
    private int shipId;

    public ShipSection(int shipId, int x, int y) {
        this.x = x;
        this.y = y;
        this.intact = true;
        this.shipId = shipId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIntact() {
        return intact;
    }

    public void hit() {
        intact = false;
    }

    public int getShipId() {
        return shipId;
    }

}
