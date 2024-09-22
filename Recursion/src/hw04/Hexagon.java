/**
 * This class is designed to create an Hexagon contructor and a rotating method
 * for the tile board. 
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw04;

public class Hexagon {
    /**The private instance varibles*/
    private int tileNum, positionNum;
    private char[] segment;
    /**
     * This method is designed to be a parameterized constructor as the main
     * Hexagon class.
     * 
     * @param tileNum   The variable respesented as the tile number.
     * @param strColor  The variable string that contains colors of the hexagon.
     */
    public Hexagon(int tileNum, String strColor) {
        // Sets the tile numbers
        this.tileNum = tileNum;
        // Set to -1 because it won't be placed on the board in the beginning.
        this.positionNum = -1;
        // Sets the color to the segments
        this.segment = strColor.toCharArray();
    }
    /**This method is designed to rotate the segments of the hexagon clockwise.*/
    public void rotate() {
        // Gets the color of north west segment.
        char northWest = segment[segment.length - 1];
        // Moves all segements on one side to the right (clockwise).
        for (int i = segment.length - 1; i > 0; i--) {
            segment[i] = segment[i - 1];
        }
        // Sets the color of north west on the north segment.
        segment[0] = northWest;
    }
    /**Getters and Setters*/
    public int getTileNumber() {
        return tileNum;
    }
    public int getPositionNumber() {
        return positionNum;
    }
    public void setPositionNumber(int positionNum) {
        this.positionNum = positionNum;
    }
    public char getSegment(int index) {
        return segment[index];
    }
    /**This method is designed to return the string output of the Hexagon.*/
    @Override
    public String toString() {
        // The variable that stores the color of each segment.
        StringBuffer strSegment = new StringBuffer();
        // This loop append the color to each segment to segment string.
        for (int i = 0; i < segment.length; i++) {
            strSegment.append(String.format("%5s", segment[i]));
        }
        return "Position " + (positionNum + 1) + ": Tile #" + tileNum + ":   " + strSegment.toString().trim();
    }
}