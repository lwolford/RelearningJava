package COSC485_Project1;

import java.util.ArrayList;

public class Requirements {

    /**
     * All needed variables for the Requirements class
     * States = All possible states in the DFA problem
     * Alphabet = All possible elements that can be input in the DFA problem
     * strStart = The starting state
     * FinalStates = All possible final states in the DFA problem
     * Functions = All possible transition functions in the DFA problem
     */
    private ArrayList<String> States;
    private ArrayList<String> Alphabet;
    private String strStart;
    private ArrayList<String> FinalStates;
    private ArrayList<String> Functions;

    /**
     * Constructor for the Requirements class
     * @param States = All states
     * @param Alphabet = All input elements
     * @param strStart = Starting state
     * @param FinalStates = All final states
     * @param Functions = All transition functions
     */
    public Requirements(ArrayList<String> States, ArrayList<String> Alphabet, String strStart,
                        ArrayList<String> FinalStates, ArrayList<String> Functions) {
        this.States = States;
        this.Alphabet = Alphabet;
        this.strStart = strStart;
        this.FinalStates = FinalStates;
        this.Functions = Functions;
    }

    // Getters

    public ArrayList<String> getStates() {
        return States;
    }

    public ArrayList<String> getAlphabet() {
        return Alphabet;
    }

    public String getStrStart() {
        return strStart;
    }

    public ArrayList<String> getFinalStates() {
        return FinalStates;
    }

    public ArrayList<String> getFunctions() {
        return Functions;
    }

}
