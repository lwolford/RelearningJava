package learningNow;

public class Pokedex {

    public static final int DEFAULT_SIZE = 1000;

    private Pokemon[] dex;

    public Pokedex() {

        dex = new Pokemon[DEFAULT_SIZE];

    }

    private void insert(Pokemon p) {

        dex[p.getIntPokemonIndex()] = p;

    }

    private Pokemon get (int id) {
        Pokemon poke = dex[id];
        if (poke == null) {
            System.err.println("That pokemon was not found");
            return null;
        }
        return poke;
    }

}
