/**
 * Explanation: 
 * 
 * This class is designed for the user to practice using Java generics to make
 * cusotm arrays of sorts using the corresponding methods. 
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw03;

public class MyArray <E extends Comparable<E>> {
    //No other data fields necessary.
    private E[] data;

    public MyArray (int size) {
        this.data = (E[]) (new Comparable[size]);
    }

    //This constructor can accept an array or a comma-separated list of values.
    public MyArray (E ... elements) {
        this.data = (E[]) (new Comparable[elements.length]);
        //Make a deep copy to prevent shared references.
        System.arraycopy(elements, 0, this.data, 0, elements.length);
    }
    
    //Add other methods.
    /**
     * This method will take in and return back the given index.
     * 
     * @param index  The Integer value stored in a array to be returned .       
     * @return       The index value given stored in data array.
     */
    public E get(int index) {
        return data[index];
    }

    /**
     * This method creates a new arary containing elements from start to end
     * then return it.
     * I created a new array containing the elements from start to end 
     * inclusive.   Then create a new "MyArray" containing the elements and
     * returns it.
     * 
     * @param start  The integer for the start of an array.   
     * @param end    The integer for the end of an array.
     * @return       The created new MyArray that has elements stored. 
     */
    public MyArray<E> get(int start, int end) {
        E[] startToEnd = (E[]) (new Comparable[end - start + 1]);

        for (int i = start, j = 0; i <= end; i++, j++) {
            startToEnd[j] = data[i];
        }
        return new MyArray(startToEnd);
    }

    /**
     * This method updates the element from index to value data. 
     * 
     * @param index  The index value of the data array.
     * @param value  The value of the data array.
     */
    public void put(int index, E value) {
        data[index] = value;
    }

    /**
     * This method is designed to return the maximum element in the array when
     * setting the first element of the array to findMax.   Then it will use a 
     * for loop to find out the maximum element of the data, then returns.
     * 
     * @return  The max element in the array.
     */
    public E max() {
        E findMax = data[0];
        for (int i = 0; i < data.length; i++) {
            if (findMax.compareTo(data[i]) < 0) {
                findMax = data[i];
            }
        }
        return findMax;
    }

    /**
     * This method is designed to return the minimum element in the array when
     * setting the first element of the array to findMin.   Then it will use a 
     * for loop to find out the minimum element of the data, then returns.
     * 
     * @return  The min element in the array.
     */
    public E min() {
        E findMin = data[0];
        for (int i = 0; i < data.length; i++) {
            if (findMin.compareTo(data[i]) > 0) {
                findMin = data[i];
            }
        }
        return findMin;
    }
    
    /**
     * This method is designed to reverse the elements in the data.
     */
    public void reverse() {
        /** */
        for (int i = 0; i < (data.length / 2); i++) {
            /**This will swap the elements from the front and to the end. */
            E toReverse = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = toReverse;
        }
    }

    /**
     * This method is designed to shuffle an array by swapping the elements at 
     * random indices to get the shuffled amount. 
     * Shuffle 1 and 2 will be the ones generating two random indices, then 
     * swapping elements at shuffle 1 and 2.
     */
    public void shuffle() {
        for (int i = 0; i < data.length; i++) {
            /**Generates the two indices randomly to shuffle. */
            int shuffle1 = (int) (Math.random() * data.length);
            int shuffle2 = (int) (Math.random() * data.length);
            /**Then it swaps the two elements integer at shuffle1 and shuffle2. */
            E toShuffle = data[shuffle1];
            data[shuffle1] = data[shuffle2];
            data[shuffle2] = toShuffle;
        }
    }

    /**
     * This method is designed to shift all the elements to the right for 
     * the given "shiftDistance".
     * 
     * @param shiftDistance
     */
    public void rightShift(int shiftDistance) {
        /**Loops the "shiftDistance" to the right data for the amount of
         * "shiftDistance".
        */
        for (int i = 0; i < shiftDistance; i++) {
            /**Stores the last value. */
            E temp = data[data.length - 1];
            /**Shift to the right by one space. */
            for (int j = data.length - 1; j > 0; j--) {
                data[j] = data[j - 1];
            }
            /**Gets the first value in the front. */
            data[0] = temp;
        }
    }

    /**
     * This method returns the number of elements in the data array
     * 
     * @return  The data array size of the element.
     */
    public int size() {
        return data.length;
    }

    /**
     * This method is designed to sort the data elements using a algorithm called
     * bubble sort.
     */
    public void sort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    E temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swap = true;
                }
            }
        }
    }

    /**
     * This method is designed to return true if the "MyArray" is equal to
     * "castArray" by creating an object array type then casting the object to
     * "MyArray".   Then it uses a for loop to check if both "MyArray" are equal. 
     */ 
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyArray<?>) {
            /**Cast the object to MyArray. */
            MyArray<?> castArray = ((MyArray<?>) obj);
            /**Checks if length of both MyArray are equal. */
            if (data.length == castArray.data.length) {
                /**Overrides the loop of the data elements. */
                for (int i = 0; i < data.length; i++) {
                    /**If both objects of the data type are the same. */
                    if (data[i].getClass().equals(castArray.data[i].getClass())) {
                        /**If both array of the elements are not equal. */
                        if (data[i].compareTo((E)castArray.data[i]) != 0) {
                            return false;
                        }
                    } else {
                        /**If the data type is not equal. */
                        return false;
                    }
                }
                /**When all elements of the data is equal. */
                return true;
            }
        }
        /**If the object is not "MyArray". */
        return false;
    }

    /**
     * This method is designed to update the elements starting from start to end.
     * 
     * @param start     The beginning of the array.
     * @param end       The end of the array.
     * @param elements  The elements stored in the array.
     */
    public void put(int start, int end, E ... elements) {
        System.arraycopy(elements, 0, this.data, start, end - start + 1);
    }

    /**
     * This method is designed to shift all the elements to the left for 
     * the given "shiftDistance".
     * 
     * @param shiftDistance
     */
    public void leftShift(int shiftDistance) {
        /**Loops the "shiftDistance" to the left data for the amount of
         * "shiftDistance".
        */
        for (int i = 0; i < shiftDistance; i++) {
            /**Stores the first value. */
            E temp = data[0];
            /**Shift to the left by one space. */
            for (int j = 0; j < data.length - 1; j++) {
                data[j] = data[j + 1];
            }
            /**Gets the first value at the end. */
            data[data.length - 1] = temp;
        }
    }

    /**This method is designed to display each value of the array on one line
     * separating each value with a comma and a space that will print a String
     * representation of the array.
     */
    @Override
    public String toString() {
        String str = "";
        /**For loop will separate the value by a comma. */
        for (int i = 0; i < data.length - 1; i++) {
            str = str + data[i] + ", ";
        }
        str = str + data[data.length - 1];
        return str;
    }
}