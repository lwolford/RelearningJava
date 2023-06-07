package ProjectOne;

import ProjectOne.Invertebrates.Bug;
import ProjectOne.Invertebrates.OtherInvertebrate;
import ProjectOne.Other.LWFileReader;
import ProjectOne.Other.Menu;
import ProjectOne.Vertebrates.*;

/**
 * Driver for Project One
 */

public class LWAnimalProject {

    public static void main(String[] args) {

        LWFileReader reader = new LWFileReader();
        Menu menu = new Menu();

        Animal[] animals = new Animal[100];

        // Sets what type of animal each animal in the array should be
        for (int i = 1; i < animals.length; i++) {

            String[] data = reader.readCSV("zoo_animals.csv", i);

            // Need to parse each data value from the CSV due to almost all parameters being type int
            int intHairValue = Integer.parseInt(data[1]);
            int intFeathersValue = Integer.parseInt(data[2]);
            int intEggsValue = Integer.parseInt(data[3]);
            int intMilkValue = Integer.parseInt(data[4]);
            int intAirborneValue = Integer.parseInt(data[5]);
            int intAquaticValue = Integer.parseInt(data[6]);
            int intVenomousValue = Integer.parseInt(data[7]);
            int intFinsValue = Integer.parseInt(data[8]);
            int intLegsValue = Integer.parseInt(data[9]);
            int intTailValue = Integer.parseInt(data[10]);
            int intTypeValue = Integer.parseInt(data[11]);

            // Set Mammal
            if (intTypeValue == 1) animals[i-1] = new Mammal(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Bird
            if (intTypeValue == 2) animals[i-1] = new Bird(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Reptile
            if (intTypeValue == 3) animals[i-1] = new Reptile(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Fish
            if (intTypeValue == 4) animals[i-1] = new Fish(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Amphibian
            if (intTypeValue == 5) animals[i-1] = new Amphibian(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Bug
            if (intTypeValue == 6) animals[i-1] = new Bug(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);

            // Set Other Invertebrate
            if (intTypeValue == 7) animals[i-1] = new OtherInvertebrate(data[0], intHairValue, intFeathersValue, intEggsValue,
                    intMilkValue, intAirborneValue, intAquaticValue, intVenomousValue, intFinsValue, intLegsValue,
                    intTailValue);
        }

        menu.introduction(animals);

    }

}
