/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;

import java.util.*;

/**
 *
 * @author strohm
 */
public class Shipyard {

    private List<Ship> lineShips;
    private List<Ship> lShips;
    private List<Ship> uShips;

    public Shipyard() {

        this.lineShips = new ArrayList<>();
        this.lShips = new ArrayList<>();
        this.uShips = new ArrayList<>();

    }

    public boolean areAllSunken() {
        for (Ship ship : lineShips) {
            if (ship.isSunken() == false) {
                return false;
            }
        }
        return true;
    }

    public int getLine() {
        int i = 0;
        for (Ship ship : lineShips) {
            if (ship.isSunken()) {

            } else {
                i++;
            }
        }
        return i;
    }

    public int getlShape() {
        int i = 0;
        for (Ship ship : lShips) {
            if (ship.isSunken()) {

            } else {
                i++;
            }
        }
        return i;
    }

    public int getuShape() {
        int i = 0;
        for (Ship ship : uShips) {
            if (ship.isSunken()) {

            } else {
                i++;
            }
        }
        return i;
    }

    public void buildShip(int shipId, int x, int y, String form) {
        if (form.equals("line")) {
            lineShips.add(new Ship(shipId, form, x, y));
        } else if (form.equals("lShip")) {
            lShips.add(new Ship(shipId, form, x, y));
        } else {
            uShips.add(new Ship(shipId, form, x, y));

        }

    }

    public Ship getShip(int shipId) {
        for (Ship ship : lineShips) {
            if (ship.getId() == shipId) {
                return ship;
            }
        }
        for (Ship ship : lShips) {
            if (ship.getId() == shipId) {
                return ship;
            }
        }
        for (Ship ship : uShips) {
            if (ship.getId() == shipId) {
                return ship;
            }

        }
        return null;
    }
}
