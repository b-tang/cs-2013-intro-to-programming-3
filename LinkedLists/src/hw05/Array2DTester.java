/**
 * Explantion: 
 * 
 * This class is designed to test the functianality of the variety of methods in
 * the "Array2D" class that the data structures works.
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw05;

public class Array2DTester{
    public static void main(String[] args) throws IndexOutOfBoundsException {
        // Array Test
		Integer[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		Array2D<Integer> array2DObject = new Array2D<Integer> (arr);

		Integer[] arrAddFirstRow = {13, 14, 15};
		array2DObject.addFirstRow(arrAddFirstRow);

		array2DObject.get(0, 0);
		array2DObject.get(0, 1);
		array2DObject.get(0, 2);

		array2DObject.get(0, 0);
		array2DObject.get(1, 0);
		array2DObject.get(2, 0);
		array2DObject.get(3, 0);
    }
}
