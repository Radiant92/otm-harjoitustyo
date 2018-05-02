/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.util.*;

/**
 * Class provides creation of Ships and management of ships sections.
 * @author strohm
 */
public class Ship {

    private String form;
    private List<ShipSection> sections;
    private int headX;
    private int headY;
    private int id;

    /**
     * Constructor constructs a Ship with given parameters
     * and calls buildShip() method to form the ship from with shipSections.
     * @param id the ships shipId, which is an individual number assigned
     * to every ship.
     * @param form the form of the ship.
     * @param headX coordinate x of the ships head.
     * @param headY coordinate y of the ships head.
     */
    public Ship(int id, String form, int headX, int headY) {
        this.form = form;
        this.id = id;
        this.sections = new ArrayList<>();
        this.headX = headX;
        this.headY = headY;
        buildShip();
    }

    public int getHeadX() {
        return headX;
    }

    public int getHeadY() {
        return headY;
    }

    public int getId() {
        return id;
    }

    public String getForm() {
        return form;
    }
/**
 * Checks if the ship has a shipSection which has not sunken.
 * @return true if non of the shipSections are intact.
 */
    public boolean isSunken() {
        for (ShipSection section : sections) {
            if (section.isIntact()) {
                return false;
            }
        }
        return true;
    }
/**
 * 
 * @return a list of ShipSection's of the Ship. 
 */
    public List<ShipSection> getSections() {
        return sections;
    }
/**
 * Find a ShipSection that matches coordinates given as parameters.
 * @param x coordinate x of ShipSection.
 * @param y coordinate y of ShipSection.
 * @return found ShipSection or null. 
 */
    public ShipSection getSection(int x, int y) {
        for (ShipSection section : sections) {
            if (section.getX() == x && section.getY() == y) {
                return section;
            }
        }
        return null;
    }
    /**
     * Builds a Ship by creating a list of ShipSections starting from the head
     * and constructed according to the form of the ship.  
     */
    public void buildShip() {
        if (this.form == "line") {
            for (int i = 0; i < 3; i++) {
                sections.add(new ShipSection(id, this.headX, this.headY + i));
            }
        } else if (this.form == "lShip") {
            for (int i = 0; i < 3; i++) {
                sections.add(new ShipSection(id, this.headX, this.headY + i));
            }
            for (int i = 1; i < 3; i++) {
                sections.add(new ShipSection(id, this.headX + i, this.headY + 2));
            }
        } else {
            for (int i = 0; i < 3; i++) {
                sections.add(new ShipSection(id, this.headX, this.headY + i));
                sections.add(new ShipSection(id, this.headX + 2, this.headY + i));
            }
            sections.add(new ShipSection(id, headX + 1, headY + 2));
        }
    }
}
