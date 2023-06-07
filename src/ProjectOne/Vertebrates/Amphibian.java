package ProjectOne.Vertebrates;

import ProjectOne.Vertebrate;

/**
 * Amphibian class
 * Subclass of vertebrate
 * Defines animal of type Amphibian
 */
public class Amphibian extends Vertebrate {

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

    private boolean boolHasBackbone = true;

    public Amphibian(String strName, int intHasHair, int intHasFeathers, int intHasEggs, int intHasMilk,
                      int intIsAirborne, int intIsAquatic, int intIsVenomous, int intHasFins, int intNumberOfLegs,
                      int intHasTail) {

        super(strName, intHasHair, intHasFeathers, intHasEggs, intHasMilk, intIsAirborne, intIsAquatic, intIsVenomous,
                intHasFins, intNumberOfLegs, intHasTail);

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
     * speak() in Amphibian overrides the speak() method inside of Vertebrate
     * @return strSpeakInformation, which includes the class name, every true trait, and a custom quote
     */
    @Override
    public String speak() {

        String strSpeakInformation = "The " + strName + " is type " + getClass().getSimpleName() + ",";

        if (intHasHair == 1) strSpeakInformation += "- It has hair,";
        if (intHasFeathers == 1) strSpeakInformation += "- It has feathers,";
        if (intHasEggs == 1) strSpeakInformation += "- It lays eggs,";
        if (intHasMilk == 1) strSpeakInformation += "- It has milk,";
        if (intIsAirborne == 1) strSpeakInformation += "- It is airborne,";
        if (intIsAquatic == 1) strSpeakInformation += "- It is aquatic,";
        if (intIsVenomous == 1) strSpeakInformation += "- It is venomous,";
        if (intHasFins == 1) strSpeakInformation += "- It has fins,";
        if (intHasTail == 1) strSpeakInformation += "- It has a tail,";
        strSpeakInformation += "Quote: I have " + intNumberOfLegs + " legs. ";
        if (intNumberOfLegs == 0) {
            strSpeakInformation += "This makes me sad. ";
            if (intHasTail == 0) strSpeakInformation += "I don't even have a tail. This really sucks. ";
            else strSpeakInformation += "At least I have a tail to make up for it";
        }
        else {
            strSpeakInformation += "Having legs is amazing. ";
            if (intHasTail == 0) strSpeakInformation += " Having them helps me forget I don't have a tail. ";
            else strSpeakInformation += "Having both legs and a tail is amazing! ";
        }

        return strSpeakInformation;

    }

    //Getters and Setters
    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getIntHasHair() {
        return intHasHair;
    }

    public void setIntHasHair(int intHasHair) {
        this.intHasHair = intHasHair;
    }

    public int getIntHasFeathers() {
        return intHasFeathers;
    }

    public void setIntHasFeathers(int intHasFeathers) {
        this.intHasFeathers = intHasFeathers;
    }

    public int getIntHasEggs() {
        return intHasEggs;
    }

    public void setIntHasEggs(int intHasEggs) {
        this.intHasEggs = intHasEggs;
    }

    public int getIntHasMilk() {
        return intHasMilk;
    }

    public void setIntHasMilk(int intHasMilk) {
        this.intHasMilk = intHasMilk;
    }

    public int getIntIsAirborne() {
        return intIsAirborne;
    }

    public void setIntIsAirborne(int intIsAirborne) {
        this.intIsAirborne = intIsAirborne;
    }

    public int getIntIsAquatic() {
        return intIsAquatic;
    }

    public void setIntIsAquatic(int intIsAquatic) {
        this.intIsAquatic = intIsAquatic;
    }

    public int getIntIsVenomous() {
        return intIsVenomous;
    }

    public void setIntIsVenomous(int intIsVenomous) {
        this.intIsVenomous = intIsVenomous;
    }

    public int getIntHasFins() {
        return intHasFins;
    }

    public void setIntHasFins(int intHasFins) {
        this.intHasFins = intHasFins;
    }

    public int getIntNumberOfLegs() {
        return intNumberOfLegs;
    }

    public void setIntNumberOfLegs(int intNumberOfLegs) {
        this.intNumberOfLegs = intNumberOfLegs;
    }

    public int getIntHasTail() {
        return intHasTail;
    }

    public void setIntHasTail(int intHasTail) {
        this.intHasTail = intHasTail;
    }

    public boolean isBoolHasBackbone() {
        return boolHasBackbone;
    }

    public void setBoolHasBackbone(boolean boolHasBackbone) {
        this.boolHasBackbone = boolHasBackbone;
    }
}
