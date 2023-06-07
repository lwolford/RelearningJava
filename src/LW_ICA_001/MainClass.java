package LW_ICA_001;

import Util.LWFileReader;

import java.util.concurrent.ThreadLocalRandom;

public class MainClass {

    public static final int CONST_INDEX = 0;
    public static final int CONST_NAME = 1;
    public static final int CONST_HP_STAT = 5;
    public static final int CONST_ATTACK_STAT = 6;

    public static void main(String[] args) {

        int intRandomNumber = ThreadLocalRandom.current().nextInt(1, 800);

        LWFileReader reader = new LWFileReader();

        //Pokemon p1 = new Pokemon(data[CONST_NAME], intIndex, intHealth, intAttack);
        //p1.PrintInformation();

        Pokemon[] pkmnYourPokemon = new Pokemon[801];

        for (int i = 1; i < pkmnYourPokemon.length; i++) {

            String[] data = reader.readCSV("pokemon.csv", i);

            int intIndex = Integer.parseInt(data[CONST_INDEX]);
            int intHealth = Integer.parseInt(data[CONST_HP_STAT]);
            int intAttack = Integer.parseInt(data[CONST_ATTACK_STAT]);

            pkmnYourPokemon[i] = new Pokemon(data[CONST_NAME], intIndex, intHealth, intAttack);
            //pkmnYourPokemon[i].PrintInformation();
            //System.out.println();

        }

        // The number entered into the square bracket is dependent on the line of the CSV file, not the Pokemon's index number
        pkmnYourPokemon[intRandomNumber].PrintInformation();

    }

}
