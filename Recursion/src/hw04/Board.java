/**
 * Explantion: https://calstatela.instructuremedia.com/embed/ee9b8fb4-0535-42cd-937c-3742af0ab03f
 * 
 * This class is designed to set up a board for the hexagon tiles and use 
 * recursion to find the adjacent tile/position for all possible solutions. 
 * 
 * @author Brian Tang, 400478452, CS 2013 35920 - 07
 */
package hw04;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
public class Board {
    public static void main(String[] args) {
        /**Creating the object*/
        Board board = new Board();
        /**String file name input location*/
        String fName = "src/test_files/tileset2.txt";
        try {
            Hexagon[] tiles = board.getTiles(fName);
            /**Finds the solution (stored)*/
            Set<String> solutions = board.findSolution(tiles);
            /**Checks if there's any solution and prints them out as specified.*/
            if (solutions.isEmpty()) {
                System.out.println("no solution");
            } else {
                if (solutions.size() == 1) {
                    System.out.println("one solution");
                } else {
                    System.out.println("more than one solution");
                }
                int i = 0;           
                /**Prints out the solution in a specific format.*/
                for (String str : solutions) {
                    System.out.println("Solution #" + ++i + "---------------------------------------\n" + str
                                        + "---------------------------------------------------\n");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry, we can't read your file.");
        }
    }
    /**
     * This method is designed to read the data from the given file input and 
     * creates an array then returns the whole data.
     * 
     * @param fileName               The file input stated in the main method.                  
     * @return                       The tiles [i] used as the pos in the array. 
     * @throws FileNotFoundException The exception when the file name is not valid.
     */
    private Hexagon[] getTiles(String fileName) throws FileNotFoundException {
        // Creates a scanner to read a file.
        Scanner inFile = new Scanner(new File(fileName));
        // Creates the Hexagon array
        Hexagon[] tiles = new Hexagon[7];
        // The loop reads the file and expands the tiles array.
        for (int i = 0; ((i < tiles.length) && (inFile.hasNextLine())); i++) {
            // Reads the files line by line
            String line = inFile.nextLine().trim();
            // Using a string data splits the line by a space.
            String[] data = line.split("\\s+");
            // Gathers the tile number.
            int tileNum = Integer.parseInt(String.valueOf(data[1].charAt(0)));
            // Creates an Hexagon object that will be assigned to the tiles array
            // at position [i].
            tiles[i] = new Hexagon(tileNum, data[2].replaceAll(",", ""));
        }
        inFile.close();
        return tiles;
    }
    /**
     * This method is designed to look for all possible solution for the given 
     * hexagon tiles that are adjacent segments from any two tiles with the same
     * color.
     * 
     * @param tiles The parameter array from Hexagon class (original).
     * @return      The solution stored in a set.        
     */
    private Set<String> findSolution(Hexagon[] tiles) {
        // Creates a hash set to store the solutions.
        Set<String> solutionSet = new HashSet<String>();
        // Uses a for loop to check for solutions by placing a Hexagon array in 
        // the center at position zero.
        for (int i = 0; i < tiles.length; i++) {
            // Creates the Hexagon arrays seven times.
            Hexagon[] solutionBoard = new Hexagon[7];
            // Sets the variable "i" at position zero with the Hexagon at the center
            solutionBoard[0] = tiles[i];
            // Set tile i at position zero
            tiles[i].setPositionNumber(0);
            // Sums up all solution found to variable "solutionSet"
            solutionSet.addAll(findSolution(tiles, solutionBoard, 1));
            // Resets back tile i to -1
            tiles[i].setPositionNumber(-1);
        }
        return solutionSet;
    }
    /**
     * This method is designed to find all solutions recursively for the given 
     * tiles.
     * 
     * @param tiles         The array of the original tiles.
     * @param solutionBoard The array that contains the adjacent segments (color).
     * @param boardPos      The integer of the correct position found.
     * @return              The solutions stored in the HashSet.
     */
    private Set<String> findSolution(Hexagon[] tiles, Hexagon[] solutionBoard, int boardPos) {
        // Creates a HashSet to store the solutions
        Set<String> solutionSet = new HashSet<String>();
        // Checks the board if there's any positions to take over.
        if (boardPos < solutionBoard.length) {
            // Finds an unassigned Hexagon tile array on the board.
            for (int i = 0; i < tiles.length; i++) {
                // Finds the Hexagons that are not used.
                if (tiles[i].getPositionNumber() == -1) {
                    // Places the hexagon at "i" board position on the board.
                    solutionBoard[boardPos] = tiles[i];
                    // Creates a save point of the hexagon object.
                    tiles[i].setPositionNumber(boardPos);
                    // Checks if the placement is compatible
                    if (checkSolution(solutionBoard)) {
                        // If yes, continues to place the upcoming hexagon
                        solutionSet.addAll(findSolution(tiles, solutionBoard, boardPos + 1));
                    }
                    // The for loop starts to rotate the hexagon to boardPos.
                    for (int j = 0; j < 5; j++) {
                        // Rotates the hexagon.
                        tiles[i].rotate();
                        // Checks if the placement is compatible
                        if (checkSolution(solutionBoard)) {
                            solutionSet.addAll(findSolution(tiles, solutionBoard, boardPos + 1));
                        }
                    }
                    // Resets the hexagon back to the original position.
                    tiles[i].rotate();
                    // Takes out the hexagon from the position
                    solutionBoard[boardPos] = null;
                    tiles[i].setPositionNumber(-1);
                }
            }
        } else {
            if (checkSolution(solutionBoard)) {
                // Creates a string for each variable.
                String str1 = "SA", str2 = "SB", str3 = "SC", str4 = "SD", str5 = "SE", str6 = "SF";
                // Creates a string builder class to append the associated label
                // for the output format.
                StringBuilder sBuilder = new StringBuilder();
                sBuilder.append(String.format("%25s %4s %4s %4s %4s %4s\n", str1, str2, str3, str4, str5, str6));
                // The for loop will append the tiles.
                for (Hexagon hexa : solutionBoard) {
                    sBuilder.append(hexa.toString() + "\n");
                }
                // This if statement sees of the string is empty
                // then it saves the solution to the set.
                if (!sBuilder.toString().trim().equals("")) {
                    solutionSet.add(sBuilder.toString());
                }
            }
        }
        return solutionSet;
    }
    /**
     * This method is designed to check all placement on the solution board
     * if it is valid.
     * 
     * @param solutionBoard The array used to check solutions
     * @return              The output if it's valid, returns true, vise versa.     
     */
    private boolean checkSolution(Hexagon[] solutionBoard) {
        for (int i = 0; i<= 5; i++) {
            // The if statement is used to compare the center hexagon.
            if (solutionBoard[i + 1] != null && solutionBoard[0].getSegment(i) != solutionBoard[i + 1].getSegment((i + 3) % 6)) {
                return false;
            } 
            // This other if statement campares the hexagon other than the middle
            // to each other.
            else if (solutionBoard[i + 1] != null && solutionBoard[((i + 1) % 6) + 1] != null 
                        && solutionBoard[i + 1].getSegment((i + 2) % 6) 
                        != solutionBoard[((i + 1) % 6) + 1].getSegment((i + 5) % 6)) {
                return false;
            }
        }
        return true;
    }
}
