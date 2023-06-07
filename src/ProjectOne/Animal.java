package ProjectOne;

/**
 * Super class of Vertebrate and Invertebrate classes
 */

public abstract class Animal {

    private String strName;
    private int intHasHair;
    private int intHasFeathers;
    private int intHasEggs;
    private int intHasMilk;
    private int intIsAirborne;
    private int intIsAquatic;
    private int intIsVenomous;
    private int intHasFins;
    private int intNumberOfLegs;
    private int intHasTail;

    public Animal(String strName, int intHasHair, int intHasFeathers, int intHasEggs, int intHasMilk,
                  int intIsAirborne, int intIsAquatic, int intIsVenomous, int intHasFins, int intNumberOfLegs,
                  int intHasTail) {

        this.strName = strName;
        this.intHasHair = intHasHair;
        this.intHasFeathers = intHasFeathers;
        this.intHasEggs = intHasEggs;
        this.intHasMilk = intHasMilk;
        this.intIsAirborne = intIsAirborne;
        this.intIsAquatic = intIsAquatic;
        this.intIsVenomous = intIsVenomous;
        this.intHasFins = intHasFins;
        this.intNumberOfLegs = intNumberOfLegs;
        this.intHasTail = intHasTail;

    }

    /**
     * Abstract speak method
     * Is overridden in each subclass
     * @return
     */
    public abstract String speak();

    /**
     * Overloaded version of the speak method
     * Allows for any animal to return a custom quote
     * @param strPhrase = Custom phrase you want the animal to say
     * @return
     */
    public String speak(String strPhrase) {
        String strSpeakInformation = "The " + strName + " says: " + strPhrase;
        return strSpeakInformation;
    }

    /**
     * Returns all animal information to a String
     * @return strAnimalInformation, which is all the possible information about the animal
     */
    public String toString() {

        String strAnimalInformation = "[" + strName + ": ";

        strAnimalInformation += "It is a " + getClass().getSimpleName() + ". ";

        // Hair
        if (intHasHair == 0) strAnimalInformation += "It has no hair. ";
        else strAnimalInformation += "It has hair. ";

        // Feathers
        if (intHasFeathers == 0) strAnimalInformation += "It has no feathers. ";
        else strAnimalInformation += "It has feathers. ";

        // Eggs
        if (intHasEggs == 0) strAnimalInformation += "It doesn't lay eggs. ";
        else strAnimalInformation += "It lays eggs. ";

        // Milk
        if (intHasMilk == 0) strAnimalInformation += "It makes no milk. ";
        else strAnimalInformation += "It makes milk. ";

        // Airborne
        if (intIsAirborne == 0) strAnimalInformation += "It is not airborne. ";
        else strAnimalInformation += "It is airborne. ";

        // Aquatic
        if (intIsAquatic == 0) strAnimalInformation += "It is not aquatic. ";
        else strAnimalInformation += "It is aquatic. ";

        // Venomous
        if (intIsVenomous == 0) strAnimalInformation += "It is not venomous. ";
        else strAnimalInformation += "It is venomous. ";

        // Fins
        if (intHasFins == 0) strAnimalInformation += "It has no fins. ";
        else strAnimalInformation += "It has fins. ";

        // Number of Legs
        strAnimalInformation += "It has " + intNumberOfLegs + " legs. ";

        // Tail
        if (intHasTail == 0) strAnimalInformation += "It has no tail. ";
        else strAnimalInformation += "It has a tail.";

        strAnimalInformation += "]";

        return strAnimalInformation;
    }

}
