package AbstractionLab;

public abstract class Animals {

    private int intLegs;
    private boolean boolHasPaws;
    private boolean boolIsHousePet;

    public Animals (int intLegs, boolean boolHasPaws, boolean boolIsHousePet) {

        this.intLegs = intLegs;
        this.boolHasPaws = boolHasPaws;
        this.boolIsHousePet = boolIsHousePet;

    }

    public abstract void speak();

    public String toString() {

        String strInfo = "[" + getClass().getSimpleName() + ": ";

        strInfo += "I have " + intLegs + " legs. ";

        if (boolHasPaws = true) strInfo += "I have paws. ";
        else strInfo += "I have feet. ";

        if (boolIsHousePet = true) strInfo += "I am a house pet.]";
        else strInfo += "I am a wild animal. I will kill you.]";

        return strInfo;

    }

    // Getters and Setters

    public int getIntLegs() {
        return intLegs;
    }

    public void setIntLegs(int intLegs) {
        this.intLegs = intLegs;
    }

    public boolean isBoolHasPaws() {
        return boolHasPaws;
    }

    public void setBoolHasPaws(boolean boolHasPaws) {
        this.boolHasPaws = boolHasPaws;
    }

    public boolean isBoolIsHousePet() {
        return boolIsHousePet;
    }

    public void setBoolIsHousePet(boolean boolIsHousePet) {
        this.boolIsHousePet = boolIsHousePet;
    }
}
