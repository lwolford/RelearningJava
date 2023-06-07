package LW_P_010;

import java.util.Scanner;

public class LWMoviesDriver implements MoviesProject{

    HashTable ht = new HashTable(10949);
    Scanner scn = new Scanner(System.in);

    /**
     * Main method for the driver class
     * @param args
     */
    public static void main(String[] args) {
        LWMoviesDriver md = new LWMoviesDriver();
        md.go();
    }

    /**
     * Finds the movie that the user wants to search for and returns the movie's other information
     * @param movie The name of the movie
     * @return The other information if the entry is not null, returns an error message if the entry is null
     */
    @Override
    public String find(String movie) {
        if (ht.get(movie) != null) {
            return ht.get(movie).returnResults();
        }
        else return "The movie you were looking for could not be found. Please try again";
    }

    /**
     * Adds a new movie to the movie database
     * @param movie The name will be the table key.
     * @param entry The values that will be inserted.
     * @return
     */
    @Override
    public boolean add(String movie, String[] entry) {
        return ht.add(movie, entry);
    }

    /**
     * Deletes a entry from the database if the entry is found
     * @param movie  The key for the entry to remove.
     * @return true if entry is found, false is entry is not found
     */
    @Override
    public boolean delete(String movie) {
        return ht.remove(movie);
    }

    /**
     * Prints all of the entries in the hash table
     */
    @Override
    public void printHT() {
        ht.printHT();
        actionMenu();
    }

    /**
     * Gets the current load factor of the hash table
     * @return The load factor
     */
    @Override
    public double getLoadFactor() {
        return ht.getLoadFactor();
    }

    /**
     * Gets the max load factor of the hash table
     * @return 0.8
     */
    @Override
    public double getMaxLoadFactor() {
        // I'm honestly not sure what this method is for at all
        // But the hash table refuses to add any more entries once the load factor exceeds 0.8
        // So that's why I have this as the max load factor
        return 0.8;
    }

    /**
     * Gets the current number of entries in the table
     * @return The number of entries in the table
     */
    @Override
    public int count() {
        return ht.getIntSize();
    }

    /**
     * Prints out the name of the person who developed this program
     */
    @Override
    public void who() {
        System.out.println("This program was developed by: Logen Wolford");
        actionMenu();
    }

    /**
     * Prints a list of commands for the user
     */
    @Override
    public void help() {
        System.out.println("Here is our list of commands: ");
        System.out.println(" - add: Lets you add a new movie to the database");
        System.out.println(" - delete: Lets you remove a movie to the database");
        System.out.println(" - find: Lets you get information on a movie in the database");
        System.out.println(" - print: Prints every movie's title that is in the database");
        System.out.println(" - who: Lets you know who made this amazing program");
        System.out.println(" - help: What you're looking at right now");
        System.out.println(" - exit: Exits the program");
        actionMenu();
    }

    /**
     * Exits the program
     */
    @Override
    public void exit() {
        System.out.println("Thank you for using the SK Ninja Tabulating Company's Movie Database");
        System.out.println("We hope to see you again!");
    }

    /**
     * Begins the hash table program
     * Asks the user to wait before going to the start menu because of the long wait time
     * Enters the entire movies.csv file into the hash table and then calls the startMenu() method
     */
    public void go() {
        System.out.println("The Movie Database is Loading.");
        System.out.println("Please wait a moment");
        LWFileReader reader = new LWFileReader();
        // 10949 is a prime number that gives a load capacity of 0.70
        for (int i = 1; i < 7669; i++) {
            String[] data = reader.readCSV("movies.csv", i);  // This is the updated csv, just named to top10s
            String strKey = data[0];
            String[] strValue = {data[1], data[2], data[3]};
            ht.add(strKey, strValue);
        }
        startMenu();
    }

    /**
     * Gives a greeting to the user, and then sends the user to the action menu
     */
    public void startMenu() {
        System.out.println("Welcome to the Movie Database.");
        System.out.println("Thank you for your patience!");
        System.out.println("Remember that if you want to search for a movie, the movie's case MATTERS!");
        System.out.println("You can start whenever you like. If you need any help, just type \"help\"");
        actionMenu();
    }

    /**
     * The actionMenu() is where command input is handled
     * It allows input for every command, with different ways to call each command
     */
    public void actionMenu() {
        String strInput = input("What would you like to do?");
        switch (strInput.toLowerCase()) {
            case "add":
            case "insert":
                userAdd();
                break;
            case "delete":
            case "remove":
                userRemove();
                break;
            case "find":
            case "search":
                userSearch();
                break;
            case "print":
            case "print all":
            case "printht":
                printHT();
                break;
            case "help":
                help();
                break;
            case "who":
                who();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println("Sorry, your input was not recognized");
                System.out.println("If you need to look at the commands again, please type \"help\"");
                actionMenu();
                break;
        }
    }

    /**
     * Handles the user input of adding a new movie to the hash table
     */
    public void userAdd() {
        String strName = input("What is the name of the movie you would like to add?");
        String strGenre = input("What is the movie's genre?");
        String strYear = input("What year did the movie release? (Please put an actual year. I didn't have time to error handle users putting in a word");
        String strDirector = input("Who directed this movie?");
        String[] strValue = {strGenre, strYear, strDirector};
        if (add(strName, strValue)) {
            System.out.println("Your movie was successfully added!");
        }
        else {
            System.out.println("Your movie. Could not be added. Please try again.");
        }
        actionMenu();
    }

    /**
     * Handles the user input of removing a movie from the hash table
     */
    public void userRemove() {
        String strName = input("What is the name of the movie you would like to remove?");
        if (delete(strName)) System.out.println("The movie " + strName + " was successfully deleted.");
        else System.out.println("The movie " + strName + " could not be found. Make sure you typed the name in correctly");

        actionMenu();
    }

    /**
     * Handles the user input of searching for a movie from the hash table
     */
    public void userSearch() {
        String strName = input("What movie would you like to search for?");
        String strResults = find(strName);
        if (!strResults.equals("The movie you were looking for could not be found. Please try again"))  {
            System.out.println("Your info is ordered as Movie Title | Movie Genre | Director | Release Year");
            System.out.println("Here is your info: " + strResults);
        }
        else System.out.println("Sorry, but that movie could not be found in our database. Please try again.");
        actionMenu();
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
