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
public class Shipyard {

    int line;
    int lShape;
    int uShape;

    public Shipyard(int line, int lShape, int uShape) {
        this.line = line;
        this.lShape = lShape;
        this.uShape = uShape;
    }

    public boolean areAllSunken() {
        if (line == 0 && lShape == 0 && uShape == 0) {
            return true;
        }
        return false;
    }

    public int getLine() {
        return line;
    }

    public int getlShape() {
        return lShape;
    }

    public int getuShape() {
        return uShape;
    }

    public void sinkLine() {
        this.line = this.line - 1;
    }

    public void sinkUShape() {
        this.uShape = this.uShape - 1;

    }

    public void sinkLShape() {
        this.lShape = this.lShape - 1;

    }
}
