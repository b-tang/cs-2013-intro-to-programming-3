/**
 * Explantion: 
 * 
 * This class is designed to be a generic class that implements protected data
 * fields and a constructor for the item, row, and column variables.
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw05;

public class Array2DNode<E extends Comparable<E>> {
    protected E item;
    protected Array2DNode<E> nextRow, nextCol;
    public Array2DNode(E item) {
        this.item = item;
        this.nextRow = this.nextCol = null;
    }
    @Override
    public String toString() {
        return this.item.toString();
    }


    // private E item;
    // protected Array2DNode<E> nextRow, nextCol;
    // public E getItem() {
    //     return item;
    // }
    // public void setItem(E item) {
    //     item = item;
    // }
    // public Array2DNode(E item) {
    //     item = item;
    //     nextRow = nextCol = null;
    // }
}
