/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.util.*;

/**
 * Contains all the Ships of current game and provides methods that retrieve
 * ships or information about ships.
 *
 * @author strohm
 */
public class Shipyard {

    private List<Ship> lineShips;
    private List<Ship> lShips;
    private List<Ship> uShips;

    /**
     * Constructs a new shipyard creating lists for each ship type: line,
     * L-shape and U-shape ships
     */
    public Shipyard() {

        this.lineShips = new ArrayList<>();
        this.lShips = new ArrayList<>();
        this.uShips = new ArrayList<>();

    }

    /**
     * Goes through all ships in shipyard and returns true if all ships are
     * sunken.
     *
     * @return true if all ships are sunken.
     */
    public boolean areAllSunken() {
        for (Ship ship : lineShips) {
            if (ship.isSunken() == false) {
                return false;
            }
        }
        for (Ship ship : lShips) {
            if (ship.isSunken() == false) {
                return false;
            }
        }
        for (Ship ship : uShips) {
            if (ship.isSunken() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return amount of line ships that are not sunken.
     */
    public int getLine() {
        int i = 0;
        for (Ship ship : lineShips) {
            if (!ship.isSunken()) {
                i++;
            }
        }
        return i;
    }

    /**
     *
     * @return amount of L-shaped ships that are not sunken.
     */
    public int getlShape() {
        int i = 0;
        for (Ship ship : lShips) {
            if (!ship.isSunken()) {
                i++;
            }
        }
        return i;
    }

    /**
     *
     * @return amount of U-shaped ships that are not sunken.
     */
    public int getuShape() {
        int i = 0;
        for (Ship ship : uShips) {
            if (!ship.isSunken()) {
                i++;
            }
        }
        return i;
    }

    /**
     * Creates a new Ship and adds it to the corresponding list of
     * ships according to it's form.
     * @param shipId id of ship being built.
     * @param x coordinate x of ships head which is to be built.
     * @param y coordinate y of ships head which is to be built.
     * @param form ships designated form.
     */
    public void buildShip(int shipId, int x, int y, String form) {
        if (form.equals("line")) {
            lineShips.add(new Ship(shipId, form, x, y));
        } else if (form.equals("lShip")) {
            lShips.add(new Ship(shipId, form, x, y));
        } else {
            uShips.add(new Ship(shipId, form, x, y));

        }

    }
    /**
     * Method searches ship through all the ship lists for one that matches the
     * shipId by the given parameter.
     * @param shipId id of ship which is being searched.
     * @return Ship with the corresponding id to the parameter shipId.
     */
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
