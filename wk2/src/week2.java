import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class week2 {
	public static void main(String[] args) {
//		problem1();
		problem2();
		
	}
	
	public static void problem1() {
		try {
//			Reading the file
			String filename = "Activity/week2/src/CS2013ActWk2_SampleText2.txt";
			FileInputStream file = new FileInputStream(filename);

			
			String fullData = ""; // Temp string to hold all the data
			ArrayList<String> separatedData = new ArrayList<String>();
			
//			Read each char from the file
    		int data=file.read();
    		while(data!=-1) {
    			if ((char)data != '\n' && (char)data != '\r') {    				
    				fullData += (char)data;
    			}
    			
    			if ((char)data == '\n') {
    				separatedData.add(fullData);
    				fullData = "";
    			}
    			data=file.read();
    		}
//    		For Data at the last line
    		separatedData.add(fullData);
    		
//    		For each string
//    		Getting individual words
    		ArrayList<String[]> listOfWords = new ArrayList<String[]>();
    		int longestString = 0;
    		for (int str=0; str<separatedData.size(); str++) {
    			String[] splitWords = separatedData.get(str).split("\t");
    			if (longestString < splitWords.length) {
    				longestString = splitWords.length;
    			}
    			listOfWords.add(splitWords);
    		}
    		
//    		For each string
//    		Organize words into a new string
    		String resultingString = "";
    		for (int i=0; i<longestString; i++) {
    			for (int array=0; array<listOfWords.size(); array++) {
    				if (i < listOfWords.get(array).length) {
    					resultingString += listOfWords.get(array)[i];
    				}
    				resultingString += "\t";
    			}
    			resultingString += "\n";
    			
    		}
    		
    		file.close();
    		
//    		Write to a new file, make sure to close the stream
    		String newFilename = filename.split(".txt")[0] + " new output.txt";
    		
    		FileOutputStream oS = new FileOutputStream(newFilename);
    		for (int character=0; character<resultingString.length(); character++) {
    			oS.write(resultingString.charAt(character));
    		}
    		oS.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void problem2() {
		try {
			String filename = "Activity/week2/src/CS2013ActWk2_SampleText2.txt";
			FileInputStream file = new FileInputStream(filename);
			
			String newFilename = "Activity/week2/src/CS2013ActWk2_SampleText2.txt";
			FileOutputStream fileOs = new FileOutputStream(newFilename);
			
			int data = file.read();
			while (data!=-1) {
				fileOs.write((char)data);
				data = file.read();
			}
			
			file.close();
			fileOs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}