package AbstractionLab.Subclasses;

import AbstractionLab.Animals;

public class Dog extends Animals {

    private int intLegs;
    private boolean boolHasPaws;
    private boolean boolIsHousePet;

    public Dog (int intLegs, boolean boolHasPaws, boolean boolIsHousePet) {

        super(intLegs, boolHasPaws, boolIsHousePet);
        this.intLegs = intLegs;
        this.boolHasPaws = boolHasPaws;
        this.boolIsHousePet = boolIsHousePet;

    }

    @Override
    public void speak() {
        System.out.println("I am incredibly hyper and love to play. Woof!");
    }

}
