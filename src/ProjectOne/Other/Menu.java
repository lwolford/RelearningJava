package ProjectOne.Other;

import ProjectOne.Animal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Menu is the class used for user input, and user output
 * It includes input, the separate menus to ask for input, and also methods for printing the information to a txt file
 */

public class Menu {

    Scanner scn = new Scanner(System.in);

    // Menus and User Input

    /**
     * Starting method for the user input to being
     * introduction is a separate method to allow the main menu to be called without the welcome text appearing again and again
     * @param a = Animal[]
     */
    public void introduction(Animal[] a) {
        System.out.println("Hello user, and welcome to the zoo catalog system.");
        System.out.println("What would group would you like info on today?");
        mainMenu(a);
    }

    /**
     * The main menu used for user input
     * Asks a user to choose what type of animals they want information from
     * Uses a switch case to determine which class of animal to output
     * Can choose from each class type in Project One to print out
     * If input is not recognized, mainMenu() is called to allow the user to try again
     * @param a = Animal[]
     */
    private void mainMenu(Animal[] a) {
        String strResponse = input("You may choose mammals, fish, birds, reptiles, amphibians, bugs, other invertebrates, vertebrates, invertebrates, or all animals: ");

        switch (strResponse.toLowerCase()) {
            case "all animals":
            case "animals":
            case "animal":
            case "all":
                outputAll(a);
                break;
            case "vertebrates":
            case "vertebrate":
                outputVertebrate(a);
                break;
            case "invertebrates":
            case "invertebrate":
                outputInvertebrate(a);
                break;
            case "mammals":
            case "mammal":
                outputMammal(a);
                break;
            case "birds":
            case "bird":
                outputBird(a);
                break;
            case "fishes":
            case "fish":
                outputFish(a);
                break;
            case "reptiles":
            case "reptile":
                outputReptile(a);
                break;
            case "amphibians":
            case "amphibian":
                outputAmphibian(a);
                break;
            case "bugs":
            case "bug":
                outputBug(a);
                break;
            case "other invertebrates":
            case "other invertebrate":
                outputOtherInvertebrate(a);
                break;
            default:
                System.out.println("Your response was not recognized. Please try again.");
                mainMenu(a);
                break;
        }
    }

    /**
     * After the previous information is output to a txt file, continue menu is called
     * Asks a user if they want to print another list, or end the program
     * If input is not recognized, continueMenu() is called to let the user try again
     * @param a = Animal[]
     */
    private void continueMenu(Animal[] a) {
        String strUserInput = input("Would you like to print another list? (Yes to continue, No to exit the program): ");
        if (strUserInput.equalsIgnoreCase("yes")) mainMenu(a);
        else if (strUserInput.equalsIgnoreCase("no")) System.out.println("Thank you!");
        else {
            System.out.println("Input not recognized. Please try again");
            continueMenu(a);
        }
    }

    /**
     * Method used for simplifying user input
     * Asks the user a question that is entered through the parameter, and returns what the user types into the console
     * @param strQuestion = Question you want to ask the user
     * @return response that is given by the user
     */
    private String input(String strQuestion) {
        System.out.println(strQuestion);
        return scn.nextLine();
    }

    // Outputs for each class of animal

    /**
     * Takes an animal array and prints the information from speak() out to a txt file
     * Prints to the txt one index at a time, and uses to comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputAll(Animal[] a) {
        try {
            String strFileName = "animal.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                String[] strPrintArray = a[i].speak().split(",");
                for (String strSplit : strPrintArray) {
                    out.println(strSplit);
                }
                out.println();
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() for each Vertebrate class out to a txt file
     * Checks if the class name of an animal index is equal to any of the vertebrate subclasses, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputVertebrate(Animal[] a) {
        try {
            String strFileName = "vertebrate.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("mammal") ||
                        a[i].getClass().getSimpleName().equalsIgnoreCase("bird") ||
                        a[i].getClass().getSimpleName().equalsIgnoreCase("reptile") ||
                        a[i].getClass().getSimpleName().equalsIgnoreCase("amphibian") ||
                        a[i].getClass().getSimpleName().equalsIgnoreCase("fish")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() for each Invertebrate class out to a txt file
     * Checks if the class name of an animal index is equal to any of the invertebrate subclasses, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputInvertebrate(Animal[] a) {
        try {
            String strFileName = "invertebrate.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("bug") ||
                        a[i].getClass().getSimpleName().equalsIgnoreCase("otherinvertebrate")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Mammal class out to a txt file
     * Checks if the class name of an animal index is equal to mammal, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputMammal(Animal[] a) {
        try {
            String strFileName = "mammal.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("mammal")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Fish class out to a txt file
     * Checks if the class name of an animal index is equal to fish, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputFish(Animal[] a) {
        try {
            String strFileName = "fish.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("fish")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Bird class out to a txt file
     * Checks if the class name of an animal index is equal to bird, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputBird(Animal[] a) {
        try {
            String strFileName = "bird.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("bird")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Reptile class out to a txt file
     * Checks if the class name of an animal index is equal to reptile, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputReptile(Animal[] a) {
        try {
            String strFileName = "reptile.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("reptile")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Amphibian class out to a txt file
     * Checks if the class name of an animal index is equal to amphibian, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputAmphibian(Animal[] a) {
        try {
            String strFileName = "amphibian.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("amphibian")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the Bug class out to a txt file
     * Checks if the class name of an animal index is equal to bug, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputBug(Animal[] a) {
        try {
            String strFileName = "bug.txt";
            PrintWriter out = new PrintWriter(strFileName);
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("bug")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named " + strFileName);
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

    /**
     * Takes an animal array and prints the information from speak() from the OtherInvertebrate class out to a txt file
     * Checks if the class name of an animal index is equal to otherinvertebrate, and begins the printing for loop
     * Prints to the txt one index at a time, and uses a comma split to separate the information from speak() onto different lines
     * Uses PrintWriter to print to a txt file
     * @param a = Animal[]
     */
    private void outputOtherInvertebrate(Animal[] a) {
        try {
            PrintWriter out = new PrintWriter("other_invertebrates.txt");
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getClass().getSimpleName().equalsIgnoreCase("otherinvertebrate")) {
                    String[] strPrintArray = a[i].speak().split(",");
                    for (String strSplit : strPrintArray) {
                        out.println(strSplit);
                    }
                    out.println();
                }
            }
            out.close();
            System.out.println("Your list has been created successfully. It is named other_invertebrates.txt");
            System.out.println("Your file will be visible once you are finished with the program.");
            continueMenu(a);
        }
        catch (IOException e) {
            System.out.println("Something went wrong printing the file. Ending the program.");
            e.printStackTrace();
        }
    }

}
