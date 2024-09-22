/**
 * This class is design to use different types to print arrays and a generic 
 * sorting method for the various arrays.
 * 
 * @author Brian Tang, 400478452, CS 2013 - 08 (Activity) ET A309
 */
import java.util.Comparator;
public class printArray {
    public static void main(String[] args) {
        printArray(new String[] {"Hello!", "my", "name", "is", "Brian Tang!"});
        printArray(new Integer[] {1, 2, 3, 4, 5});
        printArray(new Double[] {1.5, 2.5, 3.5, 4.5, 5.5});
    }

    /**
     * This method can generate various arrays with different types in a single 
     * method.
     * 
     * @param <T>   Sets an array data field in the parameter.
     * @param arr   Creates an array data field.
     */
    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * This is a generic method that is made to sort simple arrays.
     * 
     * @param <T>   Sets an array data field in the parameter.
     * @param arr   Creates an array data field.
     * @param comp  Compares two java objects.
     */
    public static <T> void sortArray(T[] arr, Comparator <? super T> comp) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (comp.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }   
    }
}

