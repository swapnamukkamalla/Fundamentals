
/************************************************************************ 
*  Project 3 for IT501 													*
*  Finding Dollar One Words 											*
*  Programmer: Group2													*
*  Last modified: May 2, 2019											*
*  Purpose: This program reads the article from Dollaronewords.txt file,*
*  	        get the positions (a=1.b=2,c=3.......y=25,z=26 of each		*
*           alphabet in the word,Sums the position of all alphabets and *
*           displays the words with sum equal to 100, Which means       *
*           (100 pennies = one Dollar)	   								*
*************************************************************************/
import java.io.*;
import java.util.ArrayList;

public class DollarOneWords {

	public static void main(String[] args) throws IOException {

//Variable declarations
		int number = 0;
		String line;
		ArrayList<String> dollaronewords = new ArrayList<String>();

//Article is stored in Dollaronewords.txt file 
//Reading the article from the file using the buffered reader
		BufferedReader bufread = new BufferedReader(new FileReader(new File("Dollaronewordsarticle.txt")));

//Read each line from the file
		while ((line = bufread.readLine()) != null) {
			if (!(line.equals(""))) {

				// words in each line are stored into array by using the space delimiter
				// \\s+ is the space delimiter in java
				String[] wordList = line.split("\\s+");

				// All words in each line loop
				for (int i = 0; i < wordList.length; i++) {
					String word = wordList[i].toLowerCase();
					int total = 0;
					// All the alphabets in each word loop
					for (int j = 0; j < word.length(); j++) {
						// Considering each character in the word
						char c = word.charAt(j);
						if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
							// Calculating the position of each alphabet
							int lettervalue = (int) c - 'a' + 1;
							total = total + lettervalue;
							if (j == word.length() - 1) {
								// If the total is equal to 100
								// Add it to array list dollar one words for display purpose
								if (total == 100) {
									dollaronewords.add(word);
									number = number + 1;
								}
							}
						}

					}
				}
			}
		}
//Displaying the Dollar one words in the article stored in Array list one by one using loop
		int size = dollaronewords.size();
		System.out.println("Identified " + dollaronewords.size() + " dollar one words... They are ::::");
		for (int i = 0; i < size; i++) {
			System.out.println(dollaronewords.get(i));
		}
	}
}
