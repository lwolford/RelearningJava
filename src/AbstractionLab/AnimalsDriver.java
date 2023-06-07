package AbstractionLab;

import AbstractionLab.Subclasses.Cat;
import AbstractionLab.Subclasses.Dog;
import AbstractionLab.Subclasses.Monkey;

public class AnimalsDriver {

    public static void main(String[] args) {

        Monkey George = new Monkey(2, false, false);
        Cat Luna = new Cat(4, true, true);
        Dog Spot = new Dog(4, true, true);

        George.speak();
        System.out.println(George.getIntLegs());
        System.out.println(George.toString());
        System.out.println();

        Luna.speak();
        System.out.println(Luna.isBoolHasPaws());
        System.out.println(Luna.toString());
        System.out.println();

        Spot.speak();
        System.out.println(Spot.isBoolIsHousePet());
        System.out.println(Spot.toString());
        System.out.println();

    }

}
