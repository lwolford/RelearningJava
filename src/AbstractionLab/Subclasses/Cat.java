package AbstractionLab.Subclasses;

import AbstractionLab.Animals;

public class Cat extends Animals {

    private int intLegs;
    private boolean boolHasPaws;
    private boolean boolIsHousePet;

    public Cat (int intLegs, boolean boolHasPaws, boolean boolIsHousePet) {

        super(intLegs, boolHasPaws, boolIsHousePet);
        this.intLegs = intLegs;
        this.boolHasPaws = boolHasPaws;
        this.boolIsHousePet = boolIsHousePet;

    }

    @Override
    public void speak() {
        System.out.println("I like milk. Meow");
    }


}
