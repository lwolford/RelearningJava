package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fileFunctions {
	
	//Method for creating a new file if the user requests
	//If a file of the same name is found, it will take
	//You back to the make list method to ask again
	public void createFile(File fileText) throws IOException {
		
		projectFunctions p = new projectFunctions();
		
		try {
			File myFile = fileText;
			if(myFile.createNewFile()) {
				p.sameName = false;
				System.out.println("File Created");
			}
			else {
				p.sameName = true;
				System.out.println("File already exists, let's try again");
				p.makeList();
			}
		}
		catch (IOException e) {
			System.out.println("An error occured, let's try again");
			p.makeList();
		}
		
	}
	
	//This method wipes the notepad clear
	public void clearFile(File fileText) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(fileText);
		pw.close();
		
	}
	
	//This method writes to the text file chosen
	//It will wipe the text file and write the current
	//list to the file
	public void writeFile(File fileText, ArrayList<String> list) throws IOException {
		
		clearFile(fileText);
		
		FileWriter fw = new FileWriter(fileText);
		for(int x = 0; x < list.size(); x++) {
			fw.write(list.get(x));
			fw.write(System.lineSeparator());
		}
		fw.close();
		
	}

}
