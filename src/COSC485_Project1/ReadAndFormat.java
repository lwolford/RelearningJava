package COSC485_Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadAndFormat {

    /**
     * FinalAnswer is the only global variable needed for the ReadAndFormat class
     */
    private ArrayList<String> FinalAnswer = new ArrayList<>();

    /**
     * Method that sets the requirements based on the DFA file given
     * @param file = DFA File given by the user
     * @return Requirements object that sets the rules for the DFA problem
     */
    public Requirements setStatesAndFunctions(File file) {

        // Variables needed for setStatesAndFunctions() method
        // Array lists are used for every type of requirement except for starting state, since starting state will only
        // ever be one object
        String strLine, strFormatted;
        String strStart = "";
        boolean boolFunctionFound = false, boolEndFound = false;
        ArrayList<String> States = new ArrayList<>();
        ArrayList<String> Alphabet = new ArrayList<>();
        ArrayList<String> FinalStates = new ArrayList<>();
        ArrayList<String> Functions = new ArrayList<>();

        System.out.print("The current files being read are: " + file.getName() + " and ");

        // Set Requirements
        try {
            Scanner scn = new Scanner(file);

            while (scn.hasNextLine()) {
                strLine = scn.nextLine();

                // Adds all valid states to the States Array List
                if (strLine.startsWith("States")) {
                    strFormatted = strLine.substring(strLine.indexOf("{") + 2, strLine.lastIndexOf("}") - 1);
                    if (strFormatted.contains(", ")) {
                        String[] strStates = strFormatted.split(", ");
                        States.addAll(Arrays.asList(strStates));
                    }
                    else {
                        States.add(strFormatted);
                    }
                }
                // Adds all valid Alphabet elements to the Alphabet Array List
                if (strLine.startsWith("Alphabet")) {
                    strFormatted = strLine.substring(strLine.indexOf("{") + 2, strLine.lastIndexOf("}") - 1);
                    if (strFormatted.contains(", ")) {
                        String[] strAlphabet = strFormatted.split(", ");
                        Alphabet.addAll(Arrays.asList(strAlphabet));
                    }
                    else {
                        Alphabet.add(strFormatted);
                    }
                }
                // If the starting state is in the States Array List, then the starting state is set
                if (strLine.startsWith("Starting State")) {
                    strFormatted = strLine.substring(strLine.indexOf("=") + 2, strLine.lastIndexOf(","));
                    for (String strState : States) {
                        if (strFormatted.equals(strState)) {
                            strStart = strFormatted;
                            break;
                        }
                        else {
                            System.out.println("Start State Not Valid");
                        }
                    }
                }
                // Adds all final states to the Final States Array List
                if (strLine.startsWith("Final States")) {
                    strFormatted = strLine.substring(strLine.indexOf("{") + 2, strLine.lastIndexOf(",") - 2);
                    if (strFormatted.contains(", ")) {
                        String[] strFinalStates = strFormatted.split(", ");
                        FinalStates.addAll(Arrays.asList(strFinalStates));
                    }
                    else {
                        FinalStates.add(strFormatted);
                    }
                }
                // If boolFunctionFound is true, then every line is added to the Functions Array List
                // Once boolEndFound is true, then no more lines are added to the Functions Array List
                if (boolFunctionFound && !boolEndFound) {
                    if (!strLine.startsWith("}")) {
                        strFormatted = strLine.substring(strLine.indexOf("(") + 2,strLine.indexOf(")")-1);
                        Functions.add(strFormatted);
                    }
                    else {
                        boolEndFound = true;
                    }
                }
                // If the Transition Function line is found in the txt file, then boolFunctionFound = true
                if (strLine.startsWith("Transition Function")) {
                    boolFunctionFound = true;
                }
            }

            return new Requirements(States, Alphabet, strStart, FinalStates, Functions);

        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return null;
        }

    }

    /**
     * Method used to read the input file for the DFA problem, and print the answers to a txt file using the printFile()
     * method
     * @param rq = Requirements from the DFA problem's rule file
     * @param file = Input file for the DFA problem
     */
    public void readInput(Requirements rq, File file) {
        // Read the input file, and then print the results
        try {
            Scanner scn = new Scanner(file);

            // Reads the file line by line, and puts each line through the inputValid() method
            while (scn.hasNextLine()) {
                inputValid(rq, scn.nextLine());
            }

            System.out.println(file.getName());
            printFile(file);

        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Method used to check if the input given is accepted or rejected by the specified requirements, then that result
     * is added to the FinalAnswer Array List
     * @param rq = The DFA problem's specified requirements
     * @param strInput = The line of input from the input file
     */
    private void inputValid(Requirements rq, String strInput) {

        // Variables needed for inputValid(). Includes strCurrentState and strCurrentInput
        String strCurrentState = rq.getStrStart();
        String strCurrentInput = "";

        // If the input equal empty string, then follow the functions and update strCurrentState accordingly
        if (strInput.equals("")) {
            for (String strFunction : rq.getFunctions()) {
                // If strCurrentState + the input is in the Functions Array List, update strCurrentState accordingly
                if (strFunction.startsWith(strCurrentState + ",  ")) {
                    strCurrentState = strFunction.substring(strFunction.lastIndexOf(", ") + 2);
                    break;
                }
            }
        }
        else {
            // For every letter in the input line, follow the Functions
            for (int i = 0; i < strInput.length(); i++) {
                strCurrentInput = strInput.substring(i, i + 1);
                for (String strFunction : rq.getFunctions()) {
                    // If strCurrentState + strCurrentInput is in the Function Array List, update strCurrentState accordingly
                    if (strFunction.startsWith(strCurrentState + ", " + strCurrentInput)) {
                        strCurrentState = strFunction.substring(strFunction.lastIndexOf(", ") + 2);
                        break;
                    }
                }
            }

        }
        for (String strFinalState : rq.getFinalStates()) {
            // If strCurrentState is equal to any state in FinalStates, add strInput is accepted to the Final Answer
            // Array List and return
            if (strFinalState.equals(strCurrentState)) {
                FinalAnswer.add(strInput + " is accepted");
                return;
            }
        }
        // If strCurrentState does equal any state in FinalStates, add strInput is rejected to the Final Answer Array List
        FinalAnswer.add(strInput + " is rejected");
    }

    /**
     * Method used to print the answers file after checking each line of input
     * Uses the PrintWriter to print out results, and then clears the FinalAnswer Array List to prepare for any more
     * DFA problems the user wants to check
     * @param file = The DFA input file
     */
    private void printFile(File file) {
        // Uses string concatenation to name the answer sheet after the DFA file
        String strFirstPart = file.getName().substring(0, file.getName().indexOf("Strings"));
        String strSecondPart = file.getName().substring(file.getName().indexOf("Strings")+7);
        String strNewFileName = strFirstPart + "Answers" + strSecondPart;

        // Write each line of the FinalAnswer array list to a txt file, and print every result to the console also
        try {
            PrintWriter out = new PrintWriter(strNewFileName);
            for (String strNewLine : FinalAnswer) {
                System.out.println("- " + strNewLine);
                out.println(strNewLine);
            }
            out.close();
            System.out.println("These results have been saved in the file: " + strNewFileName);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        FinalAnswer.clear();
    }

}
