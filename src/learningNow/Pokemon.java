package learningNow;

public class Pokemon {

    private String strPokemonName;
    private int intPokemonIndex;
    private int intPokemonHP;
    private int intPokemonCurrentHP;
    private int intPokemonCombatPoints;

    public Pokemon(String strPokemonName, int intPokemonIndex, int intPokemonHP, int intPokemonCurrentHP, int intPokemonCombatPoints) {

        this.strPokemonName = strPokemonName;
        this.intPokemonIndex = intPokemonIndex;
        this.intPokemonHP = intPokemonHP;
        this.intPokemonCurrentHP = intPokemonCurrentHP;
        this.intPokemonCombatPoints = intPokemonCombatPoints;

    }

    public void Battle(Pokemon p1, Pokemon p2) {

    }

    public void Attack(Pokemon pkmnTarget) {

        System.out.println(strPokemonName + " has attacked" + pkmnTarget.strPokemonName);
        pkmnTarget.setIntPokemonCurrentHP(pkmnTarget.intPokemonCurrentHP - intPokemonCombatPoints);
        System.out.println(pkmnTarget.strPokemonName + " has received " + intPokemonCombatPoints + " of damage");
        System.out.println(pkmnTarget.strPokemonName + " has " + pkmnTarget.intPokemonCurrentHP + " HP remaining");

    }

    public void Heal(Pokemon pkmnHealTarget) {

        intPokemonCurrentHP = intPokemonHP;

    }

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

    public int getIntPokemonCombatPoints() {
        return intPokemonCombatPoints;
    }

    public void setIntPokemonCombatPoints(int intPokemonCombatPoints) {
        this.intPokemonCombatPoints = intPokemonCombatPoints;
    }
}
