/**
 * Explantion: 
 * 
 * This class is designed to be a generic class that will implement an variety
 * of assorted methods. 
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 * @param <E>
 */
package hw05;

public class Array2D<E extends Comparable<E>> {
	/**Private Data Fields.*/

	/**Number of rows and columns.*/
    private int rowSize, colSize;
	/**
	 * Protected head refers to the node position at 0, 0 in the array.
	 * Both row and col tail refers to the beginning of the last row or column.
	 */
	protected Array2DNode<E> head;
    private Array2DNode<E> rowTail, colTail;

	//--------------------------------------------------------------------------

	/**Constructors.*/

	/**This is a default constructor that will start the row and column size
	 * at zero. It will set teh head and tail as null.
	 */
    public Array2D() {
        this.rowSize = this.colSize = 0;
        this.head = this.rowTail = this.colTail = null;
    }
	/**
	 * This is a second contructor for the class which will take a normal 2D
	 * array as an argument. 
	 * 
	 * @param values	The numbers of an array that will be taken in.
	 */
    public Array2D(E[][] values) {
        this.rowSize = values.length;
		this.colSize = values[0].length;
		Array2DNode<E>[] rowHead = new Array2DNode[rowSize];
		// Put columns in a array of linked list
		for (int i = 0; i < this.rowSize; i++) {
			rowHead[i] = null;
			for (int j = 0; j < this.colSize; j++) {
				Array2DNode<E> newArr = new Array2DNode<E>(values[i][j]);
				if (rowHead[i] == null) {
					rowHead[i] = newArr;
				} else {
					Array2DNode<E> tempArr = rowHead[i];
					while (tempArr.nextCol != null) {
						tempArr = tempArr.nextCol;
					}
					tempArr.nextCol = newArr;
				}
			}
		}
		for (int i = 0; i < this.rowSize - 1; i++) {
			Array2DNode<E> tempArr1 = rowHead[i], tempArr2 = rowHead[i + 1];
			while (tempArr1 != null && tempArr2 != null) {
				tempArr1.nextRow = tempArr2;
				tempArr1 = tempArr1.nextCol;
				tempArr2 = tempArr2.nextCol;
			}
		}
		this.head = rowHead[0];
		Array2DNode<E> tempRowTail = this.head;
		while (tempRowTail.nextRow != null) {
			tempRowTail = rowTail.nextRow;
		}
		this.rowTail = tempRowTail;

		Array2DNode<E> tempColTail = this.head;
		while (tempColTail.nextCol != null) {
			tempColTail = colTail.nextCol;
		}
		this.colTail = tempColTail;
    }

	//--------------------------------------------------------------------------

	/**Public Functions.*/

	/**
	 * This public method will add new column of nodes.
	 * 
	 * @param values
	 */
    public void addFirstCol(E ... values) {
        Array2DNode<E> currentArr = this.head;
		if (values.length != this.rowSize) {
			throw new IllegalArgumentException("Illegal argument found, out of bounds");
		} else {
			Array2DNode<E> tempArrHead = new Array2DNode<E>(values[0]);
			Array2DNode<E> tempArr = tempArrHead;
			for (int i = 1; i < values.length; i++) {
				Array2DNode<E> temp2 = new Array2DNode<E>(values[i]);
				tempArr.nextRow = temp2;
				tempArr = tempArr.nextRow;
			}
			tempArr = tempArrHead;
			for (int j = 0; j < this.rowSize - 1; j++) {
				tempArr.nextCol = currentArr;
				tempArr = tempArr.nextRow;
				currentArr = currentArr.nextRow;
			}
			this.head = tempArrHead;
			this.colSize++;
		}
    }
	/**
	 * This public method will add new rows of the nodes in teh array that will
	 * be horizontally connected with each other.
	 * 
	 * @param values
	 */
	public void addFirstRow(E ... values) {
		Array2DNode<E> currentArr = this.head;
		if (values.length != this.colSize) {
			throw new IllegalArgumentException("illegal argument found, please try again");
		} else {
			Array2DNode<E> tempArrHead = new Array2DNode<E>(values[0]);
			Array2DNode<E> tempArr = tempArrHead;
			for (int i = 1; i < values.length; i++) {
				Array2DNode<E> temp2 = new Array2DNode<E>(values[i]);
				tempArr.nextCol = temp2;
				tempArr = tempArr.nextCol;
			}
			tempArr = tempArrHead;
			for (int j = 0; j < this.rowSize - 1; j++) {
				tempArr.nextRow = currentArr;
				tempArr = tempArr.nextCol;
				currentArr = currentArr.nextCol;
			}
			this.head = tempArrHead;
			this.rowSize++;
		}
	}
	/**
	 * This public method is designed to add a new column at the of the array 
	 * list.
	 * 
	 * @param values	The values added at the end of the column array list.
	 */
	public void addLastCol(E ... values) {
		Array2DNode<E> currentArr = this.rowTail;
		if (values.length != this.rowSize) {
			throw new IllegalArgumentException("Out of bounds");
		} else {
			Array2DNode<E> tempArrHead = new Array2DNode<E>(values[0]);
			Array2DNode<E> tempArr = tempArrHead;
			for (int i = 1; i < values.length; i++) {
				Array2DNode<E> temp2 = new Array2DNode<E>(values[i]);
				tempArr.nextRow = temp2;
				tempArr = tempArr.nextRow;
			}
			tempArr = tempArrHead;
			for (int j = 0; j < this.rowSize - 1; j++) {
				tempArr.nextCol = currentArr;
				tempArr = tempArr.nextRow;
				currentArr = currentArr.nextRow;
			}
			this.rowTail = tempArrHead;
			this.colSize++;
		}
	}
	/**
	 * This public method will add new row at the of the list.
	 * 
	 * @param values	The values at the end of the row array list.
	 */
	public void addLastRow(E ... values) {
		Array2DNode<E> currentArr = this.colTail;
		if (values.length != this.rowSize) {
			throw new IllegalArgumentException("Out of bounds");
		} else {
			Array2DNode<E> tempHead = new Array2DNode<E>(values[0]);
			Array2DNode<E> temp = tempHead;
			for (int i = 1; i < values.length; i++) {
				Array2DNode<E> temp2 = new Array2DNode<E>(values[i]);
				temp.nextRow = temp2;
				temp = temp.nextCol;
			}
			temp = tempHead;
			for (int j = 0; j < this.rowSize - 1; j++) {
				temp.nextCol = currentArr;
				temp = temp.nextCol;
				currentArr = currentArr.nextCol;
			}
			this.colTail = tempHead;
			this.rowSize++;
		}
	}
	/**
	 * This public method will insert a column of values at the given index.
	 * 
	 * @param index		The index to check if it's within bounds.
	 * @param values	The values to check if it's within bounds.
	 */
	public void insertCol(int index, E ... values) {

	}
	/**
	 * This pubic method wil insert a row of values at the given index.
	 * 
	 * @param index		The index that validates if it's within bounds. 
	 * @param values	The values that validates if it's within bounds. 
	 */
	public void insertRow(int index, E ... values) {

	}
	/**
	 * This public method will not take in any parameters and doesn't return
	 * anything which will remove the first column of nodes in the Array.
	 */
	public void deleteFirstCol() {
		Array2DNode<E> currentArr = this.head;
		Array2DNode<E> head2 = currentArr.nextCol;
		for (int i = 0; i < this.rowSize; i++) {
			Array2DNode<E> tempArr = currentArr.nextRow;
			currentArr = null;
			currentArr = tempArr;
		}
		this.head = head2;
		this.colSize--;
	}
	/**
	 * This public method will not take in any parameters and doesn't return
	 * anything which will remove the first row of nodes in the Array.
	 */
	public void deleteFirstRow() {
		Array2DNode<E> currentArr = this.head;
		Array2DNode<E> head2 = currentArr.nextCol;
		for (int i = 0; i < this.rowSize; i++) {
			Array2DNode<E> tempArr = currentArr.nextCol;
			currentArr = null;
			currentArr = tempArr;
		}
		this.head = head2;
		this.rowSize--;
	}
	/**
	 * This public method will not take in any parameters and doesn't return
	 * anything which will remove the last column of nodes in the Array.
	 */
	public void deleteLastCol() {
		Array2DNode<E> currentArr = this.colTail;
		Array2DNode<E> head2 = currentArr.nextCol;
		for (int i = 0; i < this.rowSize; i++) {
			Array2DNode<E> temp = currentArr.nextRow;
			currentArr = null;
			currentArr = temp;
		}
		this.colTail = head2;
		this.colSize--;
	}
	/**
	 * This public method will not take in any parameters and doesn't return
	 * anything which will remove the last row of nodes in the Array.
	 */
	public void deleteLastRow() {
		Array2DNode<E> currentArr = this.rowTail;
		Array2DNode<E> head2 = currentArr.nextCol;
		for (int i = 0; i < this.rowSize; i++) {
			Array2DNode<E> tempArr = currentArr.nextCol;
			currentArr = null;
			currentArr = tempArr;
		}
		this.rowTail = head2;
		this.rowSize--;
	}
	/**
	 * This public method remove a column of nodes from the array at the given
	 * index.	Also, it doesn't take in any parameters.
	 * 
	 * @param index
	 */
	public void deleteCol(int index) {

	}
	/**
	 * This public method remove a row of nodes from teh array at the given 
	 * index.	Also, it doesn't take in any parameters.
	 * 
	 * @param index
	 */
	public void deleteRow(int index) {
		
	}
	/**
	 * This public method checks to validates the row and column indexes.
	 * 
	 * @param rowIndex	This index checks if row is within bounds.
	 * @param colIndex	This index checks if cloumn is within bounds.
	 * @return			The row and column indexes.	
	 */
	public Array2DNode<E> get(int rowIndex, int colIndex) {
		// Validates
		if (rowIndex > this.rowSize - 1 || colIndex > this.colSize - 1) {
			throw new IndexOutOfBoundsException("Out of bounds");
		} else {
			Array2DNode<E> currentArr = this.head;
			for (int i = 0; i < rowIndex; i++) {
				currentArr = currentArr.nextRow;
			}

			for (int j = 0; j < colIndex; j++) {
				currentArr = currentArr.nextCol;
			}

			System.out.println("rowIndex: " + rowIndex + " colIndex: " + colIndex + " result: " + currentArr);
			return currentArr;
		}
	}
	/**
	 * This public method will validate if the column index are in bounds.
	 * 
	 * @param colIndex
	 */
	public void getCol(int colIndex) {
		// validation check
		if (colIndex > this.colSize - 1) {
			throw new IndexOutOfBoundsException("Out of bounds");
		} else {
			Array2DNode<E> currentArr = this.head;
			for (int m = 0; m < colIndex; m++) {
				currentArr = currentArr.nextCol;
			}
			for (int i = 0; i < this.rowSize; i++) {
				System.out.println(currentArr);
				currentArr = currentArr.nextRow;
			}
		}
	}
	/**
	 * This public method will validate if the row index are in bounds.
	 * 
	 * @param rowIndex
	 */
	public void getRow(int rowIndex) {
		// validation check
		if (rowIndex > this.rowSize - 1) {
			throw new IndexOutOfBoundsException("Out of bounds");
		} else {
			Array2DNode<E> currentArr = this.head;
			for (int m = 0; m < rowIndex; m++) {
				currentArr = currentArr.nextRow;
			}
			for (int i = 0; i < this.colSize; i++) {
				System.out.println(currentArr);
				currentArr = currentArr.nextCol;
			}
		}
	}
	/**
	 * This public method is designed to validates the row and column index if 
	 * they are within bounds.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @param item
	 */
	public void set(int rowIndex, int colIndex, E item) {
		// Validates
		if (rowIndex > this.rowSize - 1 || colIndex > this.colSize - 1) {
			throw new IndexOutOfBoundsException("Out of bounds");
		} else {
			Array2DNode<E> current = this.head;
			for (int i = 0; i < rowIndex; i++) {
				current = current.nextRow;
			}
			for (int m = 0; m < colIndex; m++) {
				current = current.nextCol;
			}
			current.item = item;
		}
	}
	/**
	 * This method is designed to return the number of columns.
	 * 
	 * @return	The number of columns.
	 */
	public int colSize() {
		return this.colSize;
	}
	/**
	 * This method is designed to return the number of rows.
	 * 
	 * @return	The number of rows.
	 */
	public int rowSize() {
		return this.rowSize;
	}
	/**
	 * This toString method is designed to ovveride the method to return a string
	 * representation of my table where it trverses row by row.
	 */
	@Override
	public String toString() {
		return null;
	}
	/**
	 * This public method is a string representation of the table where it's
	 * traversed column by column.
	 */
	public void toStringColByCol() {

	}
}
