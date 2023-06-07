package ProjectOne.Other;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for reading a CSV file line by line
 */

public class LWFileReader {

    public String[] readCSV(String fname, int intIndexNumber) {
        File myFile = new File(fname);
        String[][] data = new String[0][];
        try {
            Scanner s = new Scanner(myFile);
                data = new String[1000][1000];
                int i = 0;
                while (s.hasNextLine()) {
                    String[] line = s.nextLine().split(",");
                    data[i] = line;
                    i += 1;
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data[intIndexNumber];
    }

}
