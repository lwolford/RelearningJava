package project;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class projectFunctions {
	
	fileFunctions f = new fileFunctions();
	
	//1 is create list, 2 is sort list, 3 is add to list, 4 is edit list
	//5 is delete from list, 6 is search list
	//1, 2, and 3 will never call this function but the values are kept for consistency
	private int intChosenFunction = 0;
	private boolean boolSearch = false;
	private boolean boolEdit = false;
	private boolean boolDelete = false;
	public boolean sameName = false;
	
	private File fileName = null;
	
	private ArrayList<String> projectList = new ArrayList<String>();
	
	public void home() throws IOException {
		
		System.out.println("---------------------------------");
		System.out.print("Current list is: ");
		printList(projectList);
		System.out.println();
		System.out.println("You can sort, add, edit, delete, search, or end");
		String strValue = input("What would you like to do? ");
		if(strValue.contentEquals("add")) add(projectList);
		else if(strValue.contentEquals("sort")) sort(projectList);
		else if(strValue.contentEquals("edit")) {
			edit(projectList);
			boolEdit = false;
		}
		else if(strValue.contentEquals("delete")) {
			delete(projectList);
			boolDelete = false;
		}
		else if(strValue.contentEquals("search")) {
			search(projectList);
			boolSearch = false;
		}
		else if(strValue.contentEquals("end")) {
			System.out.println("Goodbye");
			System.exit(0);
		}
		else {
			System.out.println("Not a valid option");
			userContinue(projectList);
		}
		
	}
	
	//Prints the entirety of the book list
	private void printList(ArrayList<String> list) {
		
		try {
			for(int x = 0; x < list.size()-1; x++) {
				System.out.print(list.get(x) + ", ");
			}
			System.out.print(list.get(list.size()-1));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.print(" ");
		}
		
	}
	
	//Code used for the user to originally make the list
	//They can choose to make a new text file or import a previous file
	public void makeList() throws IOException {
		
		String strValue = input("Do you want to make a new booklist or import your own? ").toLowerCase();
		if(strValue.contentEquals("new")) {
			File fileText = new File(input("What would you like to name the file? Remeber the .txt at the end"));
			boolean boolContinue = true;
			fileName = fileText;
			f.createFile(fileText);
			while(boolContinue && !sameName) {
				String strContinue = input("What book would you like to add? (Enter nothing to stop)");
				if(!strContinue.isEmpty()) {
					projectList.add(strContinue);
				}
				else boolContinue = false;
			}
			f.writeFile(fileText, projectList);
		}
		else if(strValue.contentEquals("import")) {
			fileName = new File(input("What is the name of the file? "));
			try {
				Scanner scan = new Scanner(fileName);
				while (scan.hasNextLine()){
				    projectList.add(scan.nextLine());
				}
				scan.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Can't find file, let's try again");
				makeList();
			}
		}
		else {
			System.out.println("Please type 'new' or 'import'");
			makeList();
		}
		home();
	}
	
	//Method for sorting the book list
	private void sort(ArrayList<String> list) throws IOException {
		
		Collections.sort(list);
		f.writeFile(fileName, list);
		System.out.println("List sorted");
		userContinue(list);
		
	}
	
	//Method for adding a book to the booklist
	private void add(ArrayList<String> list) throws IOException {
		
		list.add(input("What book would you like to add? "));
		f.writeFile(fileName, list);
		System.out.println("Book added to list");
		userContinue(list);
		
	}
	
	//Method for editing a book in the booklist
	private void edit(ArrayList<String> list) throws IOException {
		
		intChosenFunction = 4;
		String strSearch = input("What book's name would you like to edit? ");
		boolean boolFound = searchBook(list, strSearch);
		if(boolFound) {
			String strEdit = input("What would you like to rename the book? ");
			list.set(findBookNumber(list, strSearch), strEdit);
		}
		else {
			bookNotFound(list);
		}
		f.writeFile(fileName, list);
		System.out.println("Book name edited");
		userContinue(list);
		
	}
	
	//Method for deleteing a book from the booklist
	private void delete(ArrayList<String> list) throws IOException {
		
		intChosenFunction = 5;
		String strSearch = input("What book would you like to delete from the list? ");
		boolean boolFound = searchBook(list, strSearch);
		if(boolFound) {
			list.remove(findBookNumber(list, strSearch));
		}
		else {
			bookNotFound(list);
		}
		f.writeFile(fileName, list);
		System.out.println("Book deleted");
		userContinue(list);
		
	}
	
	//Method for searching for a book
	private void search(ArrayList<String> list) throws IOException {
		
		intChosenFunction = 6;
		String strSearch = input("What book are you looking for: ");
		boolean boolFound = searchBook(list, strSearch);
		if(boolFound) System.out.println("Book found at position " + (findBookNumber(list, strSearch)+1));
		else if(!boolFound) bookNotFound(list);
		userContinue(list);
		
	}
	
	//The search book method user in delete, edit, and search book
	//This is the main searching method
	private boolean searchBook(ArrayList<String> list, String strSearch) {
		
		ArrayList<String> searchList = new ArrayList<String>();
		for (String curVal : list){
			  if (curVal.contains(strSearch)) {
				  searchList.add(curVal);
				  return true;
			  }
		}
		return false;
	}
	
	//Find what number the searched book is in the array list
	private int findBookNumber(ArrayList<String> list, String strSearch) {
		
		ArrayList<String> searchList = new ArrayList<String>();
		int intCount = -1;
		for (String curVal : list){
			  intCount++;
			  if (curVal.contains(strSearch)) {
				  searchList.add(curVal);
				  break;
			  }
		}
		return intCount;
		
	}
	
	//Method for when the search method can't find the searched book
	private void bookNotFound(ArrayList<String> list) throws IOException {
		
		boolean boolEndCycle = false;
		System.out.println("Book not found");
		while(!boolEndCycle) {
			String strInput = input("Try again?").toLowerCase();
			if(strInput.contentEquals("yes")) {
				switch(intChosenFunction) {
					case 4:
						edit(list);
						break;
					case 5:
						delete(list);
						break;
					case 6:
						search(list);
						break;
				}
				boolEndCycle = true;
			}
			else if(strInput.contentEquals("no")) {
				boolEndCycle=true;
				System.out.println("Goodbye");
				System.exit(0);
			}
			else {
				System.out.println("Only 'yes' and 'no' are valid inputs.");
			}
		}
		
	}
	
	//Method for asking the user if they want to continue after each
	//action taken
	private void userContinue(ArrayList<String> list) throws IOException {
		
		String strValue = input("Would you like to continue? ").toLowerCase();
		if(strValue.contentEquals("yes")) {
			System.out.println("Returning home.");
			switch(intChosenFunction) {
			case 4:
				boolEdit = true;
				break;
			case 5:
				boolDelete = true;
				break;
			case 6:
				boolSearch = true;
				break;
			}
			home();
		}
		else if(strValue.contentEquals("no")) {
			switch(intChosenFunction) {
			case 4:
				boolEdit = true;
				break;
			case 5:
				boolDelete = true;
				break;
			case 6:
				boolSearch = true;
				break;
			}
			System.out.println("Goodbye");
			System.exit(0);
		}
		else {
			System.out.println("Not a valid input. Please type 'yes' or 'no'");
			userContinue(list);
		}
		
	}
	
	//Method for easy user inputting
	private String input(String strQuest) {
		
		Scanner scnUserInput = new Scanner(System.in);
		System.out.print(strQuest);
		String strWord = scnUserInput.nextLine();
		return strWord;
		
	}

}
