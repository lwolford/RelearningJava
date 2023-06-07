package learningNow;

import Util.LWFileReader;

import java.sql.SQLOutput;

public class PokemonBattle {

    public static void main(String[] args) {

        //Pokemon pikachu = new Pokemon("Pikachu", 25, 100, 100, 20);
        //Pokemon mew = new Pokemon("Mew", 151, 100, 100, 15);

        //pikachu.Attack(mew);

        LWFileReader reader = new LWFileReader();
        String[] data = reader.readCSV("pokemon.csv", 1);

    }

}
