
package battleships;

/**
 * Representation of a section of a Ship.
 * ShipSection belongs to one ship and holds a state of being hit or not.
 * @author strohm
 */
public class ShipSection {

    private int x;
    private int y;
    private boolean intact;
    private int shipId;
/**
 * Constructor constructs a ShipSection that is intact and corresponds
 * to a certain Ship.
 * @param shipId id of the Ship which this ShipSection is part of. 
 * @param x coordinate x of ShipSections location.
 * @param y coordinate y of ShipSections location.
 */
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

    public int getShipId() {
        return shipId;
    }
/**
 * 
 * @return boolean true or false depending on has the ShipSection
 * been hit or not. 
 */
    public boolean isIntact() {
        return intact;
    }
/**
 * Changes boolean intact into false, which represents that the ShipSection
 * has been hit. 
 */
    public void hit() {
        intact = false;
    }

}
