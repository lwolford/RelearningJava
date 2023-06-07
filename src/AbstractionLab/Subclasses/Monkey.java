package AbstractionLab.Subclasses;

import AbstractionLab.Animals;

public class Monkey extends Animals {

    private int intLegs;
    private boolean boolHasPaws;
    private boolean boolIsHousePet;

    public Monkey (int intLegs, boolean boolHasPaws, boolean boolIsHousePet) {

        super(intLegs, boolHasPaws, boolIsHousePet);
        this.intLegs = intLegs;
        this.boolHasPaws = boolHasPaws;
        this.boolIsHousePet = boolIsHousePet;

    }

    @Override
    public void speak() {
        System.out.println("I love bananas. Ooooo ooooo ah ah. ");
    }



}
