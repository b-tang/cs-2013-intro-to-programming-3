/**
 * This class is deisgned for the purpose of testing MyArray class functionality 
 * of Java generics methods.
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw03;

public class MyArrayTesting {
    public static void main (String[] args) {
        MyArray<Character> cArray = new MyArray<>('B', 'r', 'o', 'z', 't', 'y');
        MyArray<Integer> iArray = new MyArray<>(9, 24, 1, 31, 720, 327);
        MyArray<String> sArray = new MyArray<>("Youtube", "Twitch", "Netflix", "Apex", "Steam", "Valorant");
        
        System.out.println("Hello! Welcome to my Generic Class.");
        System.out.println("These are my various arrays: ");
        System.out.println(cArray);
        System.out.println(iArray);
        System.out.println(sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("GET, PUT and SIZE methods.");
        System.out.println("The element at index 5 for character is: " + cArray.get(5));
        System.out.println("The element at index 5 is a three digit number: " + iArray.get(5));
        System.out.println("The element at index 5 is my favorite game: " + sArray.get(5));
        System.out.println("The indexes from 0 - 2 is the three letters of my nickname: " + cArray.get(0, 2));
        System.out.println("The indexes from 0 - 2 is my birthday: " + iArray.get(0, 2));
        System.out.println("The indexes from 0 - 2 are my favorite entertainment sites: " + sArray.get(0, 2));

        System.out.println("-------------------------------------------------");

        System.out.print("Replacing my nickname letter o to a number 0: "); 
        cArray.put(2, '0');
        System.out.println(cArray);
        System.out.print("Replacing number 1 with 7: "); 
        iArray.put(2, 7);
        System.out.println(iArray);
        System.out.print("Replacing netflix to: "); 
        sArray.put(2, "Logitech");
        System.out.println(sArray);
        System.out.print("Replacing my first four letters of Broz with Karu: "); 
        cArray.put(0, 3, new Character[] {'K', 'a', 'r', 'u'});
        System.out.println(cArray);
        System.out.print("Replacing my first four letters of integer array: "); 
        iArray.put(0, 3, new Integer[] {6, 18, 22, 30});
        System.out.println(iArray);
        System.out.print("Replacing my Steam with Higround: "); 
        sArray.put(4, 4, new String[] {"Higround"});
        System.out.println(sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("The size of the character array is: " + cArray.size());
        System.out.println(cArray);
        System.out.println("The size of the integer array is: " + iArray.size());
        System.out.println(iArray);
        System.out.println("The size of the string array is: " + sArray.size());
        System.out.println(sArray);


        System.out.print("\n");
        System.out.println("\nEQUALS, REVERSE, SHUFFLE, and SORT methods");
        System.out.println("Character Array = Character Array: " + cArray.equals(cArray));
        System.out.println("Character Array = Integer Array: " + cArray.equals(iArray));
        System.out.println("Integer Array = String Array: " + iArray.equals(sArray));
        
        System.out.println("-------------------------------------------------");

        System.out.println("Before character array reverse: " + cArray);
        cArray.reverse();
        System.out.println("Reverse character array: "+cArray);
        System.out.println("Before integer array reverse: " + iArray);
        iArray.reverse();
        System.out.println("Reverse integer array: "+iArray);
        System.out.println("Before string array reverse: " + sArray);
        sArray.reverse();
        System.out.println("Reverse string array: "+sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("Before character array shuffle: " + cArray);
        cArray.shuffle();
        System.out.println("Shuffled character array: "+ cArray);
        System.out.println("Before integer array shuffle: " + iArray);
        iArray.shuffle();
        System.out.println("Shuffled integer array: "+iArray);
        System.out.println("Before string array shuffle: " + sArray);
        sArray.shuffle();
        System.out.println("Shuffled string array: "+sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("Before character array sort: " + cArray);
        cArray.sort();
        System.out.println("Sorted character array: " + cArray);
        System.out.println("Before integer array sort: " + iArray);
        iArray.sort();
        System.out.println("Sorted integer array: " + iArray);
        System.out.println("Before string array sort: " + sArray);
        sArray.sort();
        System.out.println("Sorted string array: " + sArray);


        System.out.print("\n");
        System.out.println("\nMAX and MIN Methods.");
        System.out.println("The maximum element of the character array is: " + cArray.max());
        System.out.println(cArray);
        System.out.println("The maximum element of the integer array is: " + iArray.max());
        System.out.println(iArray);
        System.out.println("The maximum element of the string array is: " + sArray.max());
        System.out.println(sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("The minimum element of the character array is: " + cArray.min());
        System.out.println(cArray);
        System.out.println("The minimum element of the integer array is: " + iArray.min());
        System.out.println(iArray);
        System.out.println("The minimum element of the string array is: " + sArray.min());
        System.out.println(sArray);


        System.out.print("\n");
        System.out.println("\nLEFT and RIGHT shift methods.");
        System.out.println("Before character left shift: " + cArray);
        cArray.leftShift(2);
        System.out.println("After character left shift 2 times: " + cArray);
        System.out.println("Before integer left shift: " + iArray);
        iArray.leftShift(2);
        System.out.println("After integer left shift 2 times: " + iArray);
        System.out.println("Before string left shift: " + sArray);
        sArray.leftShift(2);
        System.out.println("After string left shift 2 times: " + sArray);

        System.out.println("-------------------------------------------------");

        System.out.println("Before character right shift: " + cArray);
        cArray.rightShift(2);
        System.out.println("After character right shift 2 times: " + cArray);
        System.out.println("Before integer right shift: " + iArray);
        iArray.rightShift(2);
        System.out.println("After integer right shift 2 times: " + iArray);
        System.out.println("Before string right shift: " + sArray);
        sArray.rightShift(2);
        System.out.println("After string right shift 2 times: " + sArray);
    }
}
