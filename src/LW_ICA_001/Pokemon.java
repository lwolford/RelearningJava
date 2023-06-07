package LW_ICA_001;

public class Pokemon {

    private String strPokemonName;
    private int intPokemonIndex;
    private int intPokemonHP;
    private int intPokemonCurrentHP;
    private int intPokemonAttackStat;

    public Pokemon(String strPokemonName, int intPokemonIndex, int intPokemonHP, int intPokemonAttackStat) {

        this.strPokemonName = strPokemonName;
        this.intPokemonIndex = intPokemonIndex;
        this.intPokemonHP = intPokemonHP;
        intPokemonCurrentHP = intPokemonHP;
        this.intPokemonAttackStat = intPokemonAttackStat;

    }

    public void PrintInformation() {
        System.out.println("Name: " + strPokemonName);
        System.out.println("Pokedex Entry: " + intPokemonIndex);
        System.out.println("Health Points: " + intPokemonHP);
        System.out.println("Current Health Points: " + intPokemonCurrentHP);
        System.out.println("Attack Stat: " + intPokemonAttackStat);
    }

    // Getters and Setters
    public String getStrPokemonName() {
        return strPokemonName;
    }

    public void setStrPokemonName(String strPokemonName) {
        this.strPokemonName = strPokemonName;
    }

    public int getIntPokemonIndex() {
        return intPokemonIndex;
    }

    public void setIntPokemonIndex(int intPokemonIndex) {
        this.intPokemonIndex = intPokemonIndex;
    }

    public int getIntPokemonHP() {
        return intPokemonHP;
    }

    public void setIntPokemonHP(int intPokemonHP) {
        this.intPokemonHP = intPokemonHP;
    }

    public int getIntPokemonCurrentHP() {
        return intPokemonCurrentHP;
    }

    public void setIntPokemonCurrentHP(int intPokemonCurrentHP) {
        this.intPokemonCurrentHP = intPokemonCurrentHP;
    }

    public int getIntPokemonAttackStat() {
        return intPokemonAttackStat;
    }

    public void setIntPokemonAttackStat(int intPokemonAttackStat) {
        this.intPokemonAttackStat = intPokemonAttackStat;
    }
}
