package LW_P_011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LW_DFS_Driver {

    /**
     * Main method for the DFS driver
     * Starts the program by calling the go() method
     * @param args
     */
    public static void main(String[] args) {

        LW_DFS_Driver driver = new LW_DFS_Driver();
        driver.go();

    }

    /**
     * Calls the greeting, and the readFile method in order to read the txt file for the graph
     * Reads the example_graph.txt and the my_graph.txt
     */
    public void go() {
        greeting();
        readFile("example_graph.txt");
        readFile("my_graph.txt");
        goodbye();
    }

    /**
     * The greeting method for the program
     * Introduces itself and convinces the user that we do NOT kill humans
     */
    public void greeting() {
        try {
            Thread.sleep(1000);
            System.out.print("Welcome to the Steve K Ninja Tabulation Company's human extermina ");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("Sorry slip of the tongue!");
            System.out.print("Welcome to the Labyrinth Exploration Program");
            System.out.print("This program was developed by: lwolford");
            Thread.sleep(2000);
            System.out.println();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goodbye() {
        try {
            Thread.sleep(1000);
            System.out.println("This is all we have for you today!");
            Thread.sleep(1000);
            System.out.println("Thank you for using our program, and remember to keep an eye out.");
            Thread.sleep(1500);
            System.out.println("You never know when you're next with how those robots have been acting lately haha.");
            Thread.sleep(2000);
            System.out.print("Anyways, thank you and see you next time ");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(700);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(" maybe");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used to read the txt files that contain the graphs
     * @param fname = the name of file given to the method
     * Calls the DFS class and dfs.traverse() to traverse the given graph
     */
    public void readFile(String fname) {
        try {
            Scanner reader = new Scanner(new File(fname));
            int intSize = reader.nextInt();
            reader.nextLine();
            int intTargetVertex = reader.nextInt();
            int[][] adjacencyMatrix = new int[intSize][intSize];
            for (int i = 0; i < intSize; i++) {
                for (int j = 0; j < intSize; j++) {
                    adjacencyMatrix[i][j] = reader.nextInt();
                }
            }
            System.out.println("This labyrinth is: " + fname);
            DFS dfs = new DFS(adjacencyMatrix, intTargetVertex);
            dfs.traverse();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
