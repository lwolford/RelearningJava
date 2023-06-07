package COSC485_Project1;

import java.io.File;

public class DFA {

    /**
     * Main Method for the DFA_Driver
     * Starts the program by calling the go() method
     * @param args
     */
    public static void main(String[] args) {

        DFA driver = new DFA();
        driver.go();

    }

    /**
     * Calls the ReadAndFormat() class, and creates files for each DFA Problem
     * Calls the setStatesAndFunctions() method to create the requirements for each DFA problem
     * Calls readInput() to determine if the inputs in the input file are accepted or rejected for each DFA problem
     */
    public void go() {

        ReadAndFormat raf = new ReadAndFormat();

        // DFA Files
        File file = new File("COSC485_P1_DFA.txt");
        File fileInput = new File("COSC485_P1_StringsDFA.txt");

        Requirements rq = raf.setStatesAndFunctions(file);
        raf.readInput(rq, fileInput);

        // DFA (another sample) Files
        File file2 = new File("COSC485_P1_DFA (another sample).txt");
        File fileInput2 = new File("COSC485_P1_StringsDFA (another sample).txt");

        Requirements rq2 = raf.setStatesAndFunctions(file2);
        raf.readInput(rq2, fileInput2);

        // DFA (more sample) Files
        File file3 = new File("COSC485_P1_DFA (more sample).txt");
        File fileInput3 = new File("COSC485_P1_StringsDFA (more sample).txt");

        Requirements rq3 = raf.setStatesAndFunctions(file3);
        raf.readInput(rq3, fileInput3);
    }

}
