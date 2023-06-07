package LW_P_001;

import java.util.Scanner;

public class LW_AVLDriver implements COSC310_AVL {

    AVL avl = new AVL();
    Scanner scn = new Scanner(System.in);

    /**
     * Main method for the driver class
     * @param args
     */
    public static void main(String[] args) {
        LW_AVLDriver driver = new LW_AVLDriver();
        driver.go();
    }

    /**
     * Begins the AVL tree program
     * First adds all information from the CSV file into the AVL tree
     * After all the information is added, greeting() is called to begin the user input section
     */
    @Override
    public void go() {
        LWFileReader reader = new LWFileReader();
        for (int i = 1; i < 604; i++) {
            String[] data = reader.readCSV("top10s.csv", i);  // This is the updated csv, just named to top10s
            avl.add(data);
        }
        greeting();
    }

    /**
     * Searches for the song the user wants to find in the AVL tree
     * Calls privateSearch first to see if the song is in the tree
     * If the song is in the tree, then search is called to print the directional arrows
     * If the song is not found, the user gets a message stating the song was not found
     * Implemented from interface
     * @param name
     */
    @Override
    public void find(String name) {
        if (avl.privateSearch(name)) {
            avl.search(name);
        }
        else System.out.println("Sorry, your song was not found in the database");
    }

    /**
     * Method used to add a song from the user
     * Implemented from interface
     * @param record = the record from startAdd()
     * @return true is the song was successfully added, false if the song is not added successfully
     */
    @Override
    public boolean add(Record record) {
        String[] data = record.recordToStringArray();
        avl.add(data);
        boolean boolSearch = avl.directSearch(data);
        if (boolSearch) return true;
        else return false;
    }

    /**
     * The method that gives the user all the necessary prompts to add a song to the tree
     * @return record = a Record type of all the needed prompts
     */
    public Record startAdd() {
        String strName = input("What is the song's name?");
        String strArtist = input("What is the artist's name?");
        String strGenre = input("What is the song's genre?");
        String strYear = validYear();
        String strBPM = validBPM();
        String strEnergy = validEnergy();
        String strDance = validDance();
        Record record = new Record(strName, strArtist, strGenre, strYear, strBPM,
                strEnergy, strDance);
        return record;
    }

    /**
     * Method to make sure the user enters a valid year into the database
     * @return strYear = the year that the user input
     */
    private String validYear() {
        String strInput = input("What year was the song popular in?");
        int intYear = 0;
        try {
            intYear = Integer.parseInt(strInput);
            if (intYear < 2010 || intYear > 2019) {
                System.out.println("The song must be a song from the 2010s. Exiting to main menu.");
                startMenu();
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Remember that you must input a valid year. Please try again.");
            validYear();
        }
        String strYear = Integer.toString(intYear);
        return strYear;
    }

    /**
     * Method to make sure the user enters a valid year info the database
     * @return strBPM = the user input of BPM
     */
    private String validBPM() {
        String strInput = input("What is the song's BPM?");
        int intBPM = 0;
        try {
            intBPM = Integer.parseInt(strInput);
            if (intBPM < 0) {
                System.out.println("The song's BPM must be greater than 0. Please try again.");
                validBPM();
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Remember that you must input a valid BPM. It must be a whole number, please try again.");
            validBPM();
        }
        String strBPM = Integer.toString(intBPM);
        return strBPM;
    }

    /**
     * Method to make sure the user enters a valid energy level
     * @return strEnergy = the user input of energy level
     */
    private String validEnergy() {
        String strInput = input("On a scale of 0-100, how much energy does the song have? (If you want to really emphasize how energetic or boring a song is, you can exceed the scale)");
        int intEnergy = 0;
        try {
            intEnergy = Integer.parseInt(strInput);
        }
        catch (NumberFormatException ex) {
            System.out.println("Remember that you must input a valid energy level. It must be a whole number, please try again.");
            validEnergy();
        }
        String strEnergy = Integer.toString(intEnergy);
        return strEnergy;
    }

    /**
     * Method to make sure the user enters a valid danceability level
     * @return strDance = the user input of the danceability level
     */
    private String validDance() {
        String strInput = input("On a scale of 0-100, how danceable is the song? (If you want to really emphasize how energetic or boring a song is, you can exceed the scale)");
        int intDance = 0;
        try {
            intDance = Integer.parseInt(strInput);
        }
        catch (NumberFormatException ex) {
            System.out.println("Remember that you must input a valid danceability level. It must be a whole number, please try again.");
            validDance();
        }
        String strDance = Integer.toString(intDance);
        return strDance;
    }

    /**
     * Gets the total number of nodes in the AVL tree
     * Implemented from the interface
     * @return avl.getNodeNumber()
     */
    @Override
    public int count() {
        return avl.getNodeNumber();
    }

    /**
     * Prints the AVL tree in in-order traversal
     * Implemented from the interface
     */
    @Override
    public void printInorder() {
        printSleep();
        avl.inOrderTraversal();
    }

    /**
     * Prints the AVL tree in pre-order traversal
     * Implemented from the interface
     */
    @Override
    public void printPreorder() {
        printSleep();
        avl.preOrderTraversal();
    }

    /**
     * Prints the AVL tree in post-order traversal
     * Implemented from the interface
     */
    @Override
    public void printPostorder() {
        printSleep();
        avl.postOrderTraversal();
    }

    /**
     * A method to give a 5-second stop
     * Used for all traversals to give the user time to read the prompt
     */
    public void printSleep() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            System.out.println("An error has occurred. Exiting the program.");
        }
    }

    /**
     * Given the user a greeting message including my name, general information of the program, and how to get started
     * Implemented from the interface
     */
    @Override
    public void greeting() {
        System.out.println(getMyName());
        System.out.println("Do you want information of the 2010s best songs?");
        System.out.println("If so, then I have the perfect product for you.");
        System.out.println("You can get information on your favorite hits from the 2010s");
        System.out.println("You can start whenever you like. If you need any help, just type \"help\"");
        startMenu();
    }

    /**
     * Prints the user a list of all valid commands
     * Implemented from the interface
     */
    @Override
    public void help() {
        System.out.println("Here is a list of commands and what they can do:");
        System.out.println(" - find: gets information on a song you want to search for");
        System.out.println(" - add: if you can't find a song in our database, you can add it!");
        System.out.println(" - count: gives you the total number of songs currently in the database");
        System.out.println(" - exit: exits this amazing program");
        System.out.println(" - in order: prints out a full list of the songs in tree in-order");
        System.out.println(" - pre order: prints out a full list of the songs in tree pre-order");
        System.out.println(" - post order: prints out a full list of the songs in tree post-order");
        System.out.println(" - info: reprints the message you saw in the beginning");
        System.out.println(" - help: gives you a list of all the commands you need");
        startMenu();
    }

    /**
     * Prints the user a goodbye message and ends the program
     * Implemented from the interface
     */
    @Override
    public void exit() {
        System.out.println("Thank you for using the SK Tabulating Company's 2010s song database");
        System.out.println("See you again!");
        System.exit(0);
    }

    /**
     * Gets my name to show the user the incredible developer that made this program :)
     * @return strMyInfo = my name
     * Implemented from the interface
     */
    @Override
    public String getMyName() {
        String strMyInfo = "Program by: lwolford";
        return strMyInfo;
    }

    /**
     * The startMenu method is the method that allows the user to choose what they want to do
     * Uses a case statement to find which command the user wants to use
     * If the command can't be found, an error message is given to the user and startMenu is called again
     */
    private void startMenu() {
        String strInput = input("What would you like to do?");
        switch (strInput.toLowerCase()) {
            case "find":
            case "search":
                String strSearch = input("What song would you like to find?");
                find(strSearch);
                startMenu();
                break;
            case "add":
                boolean boolAdded = (add(startAdd()));
                if (boolAdded) System.out.println("Your song was successfully added");
                else System.out.println("Sorry your song was not added. There must already be a song with that name");
                startMenu();
                break;
            case "count":
                System.out.println("There are " + count() + " songs in the database.");
                startMenu();
                break;
            case "exit":
                exit();
                break;
            case "in order":
            case "inorder":
            case "in-order":
                System.out.println("In 5 seconds, the order will print with the format: ");
                System.out.println("[Song name, artist, genre, release year, BPM, song energy, song danceability]");
                printInorder();
                startMenu();
                break;
            case "pre order":
            case "preorder":
            case "pre-order":
                System.out.println("In 5 seconds, the order will print with the format: ");
                System.out.println("[Song name, artist, genre, release year, BPM, song energy, song danceability]");
                printPreorder();
                startMenu();
                break;
            case "post order":
            case "postorder":
            case "post-order":
                System.out.println("In 5 seconds, the order will print with the format: ");
                System.out.println("[Song name, artist, genre, release year, BPM, song energy, song danceability]");
                printPostorder();
                startMenu();
                break;
            case "info":
                greeting();
                startMenu();
                break;
            case "help":
                help();
                startMenu();
                break;
            default:
                System.out.println("Sorry, your input was not recognized");
                System.out.println("If you need to look at the commands again, please type \"help\"");
                startMenu();
                break;
        }
    }

    /**
     * Method used to simply user-input fields
     * @param strQuestion = the question you want to ask the user
     * @return scn.nextLine() = the information that the user put into the response box
     */
    private String input(String strQuestion) {
        System.out.println(strQuestion);
        return scn.nextLine();
    }
}
