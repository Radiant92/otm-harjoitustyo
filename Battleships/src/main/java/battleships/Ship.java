/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.util.*;

/**
 *
 * @author strohm
 */
public class Ship {

    private String form;
    private List<ShipSection> sections;
    private int headX;
    private int headY;
    private int id;

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

    public boolean isSunken() {
        for (ShipSection section : sections) {
            if (section.isIntact()) {
                return false;
            }
        }
        return true;
    }

    public List<ShipSection> getSections() {
        return sections;
    }

    public ShipSection getSection(int x, int y) {
        for (ShipSection section : sections) {
            if (section.getX() == x && section.getY() == y) {
                return section;
            }
        }
        return null;
    }

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
