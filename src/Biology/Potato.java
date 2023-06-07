package Biology;

public class Potato {

    public static double p11 = 4.9;
    public static double p12 = 4.7;
    public static double p13 = 4.9;

    public static double p21 = 5.1;
    public static double p22 = 4.6;
    public static double p23 = 5.0;

    public static double p31 = 4.7;
    public static double p32 = 4.9;
    public static double p33 = 4.7;

    public static double p41 = 5.0;
    public static double p42 = 4.8;
    public static double p43 = 4.6;

    public static double p51 = 5.2;
    public static double p52 = 5.0;
    public static double p53 = 4.6;

    public static double p61 = 5.0;
    public static double p62 = 5.1;
    public static double p63 = 5.0;

    public static double p71 = 4.8;
    public static double p72 = 4.9;
    public static double p73 = 4.4;

    public static double fp11 = 5.2;
    public static double fp12 = 5.0;
    public static double fp13 = 5.3;

    public static double fp21 = 5.4;
    public static double fp22 = 4.9;
    public static double fp23 = 5.3;

    public static double fp31 = 4.9;
    public static double fp32 = 5.1;
    public static double fp33 = 4.9;

    public static double fp41 = 5.0;
    public static double fp42 = 4.9;
    public static double fp43 = 4.6;

    public static double fp51 = 5.0;
    public static double fp52 = 4.8;
    public static double fp53 = 4.6;

    public static double fp61 = 4.8;
    public static double fp62 = 4.8;
    public static double fp63 = 4.6;

    public static double fp71 = 4.3;
    public static double fp72 = 4.5;
    public static double fp73 = 3.8;

    public static void main(String[] args) {

        double dblDifference11 = Difference(p11, fp11);
        System.out.println("Difference in Test Tube 1,1 is: " + dblDifference11);
        double dblDifference12 = Difference(p12, fp12);
        System.out.println("Difference in Test Tube 1,2 is: " + dblDifference12);
        double dblDifference13 = Difference(p13, fp13);
        System.out.println("Difference in Test Tube 1,3 is: " + dblDifference13);

        double dblDifference21 = Difference(p21, fp21);
        System.out.println("Difference in Test Tube 2,1 is: " + dblDifference21);
        double dblDifference22 = Difference(p22, fp22);
        System.out.println("Difference in Test Tube 2,2 is: " + dblDifference22);
        double dblDifference23 = Difference(p23, fp23);
        System.out.println("Difference in Test Tube 2,3 is: " + dblDifference23);

        double dblDifference31 = Difference(p31, fp31);
        System.out.println("Difference in Test Tube 3,1 is: " + dblDifference31);
        double dblDifference32 = Difference(p32, fp32);
        System.out.println("Difference in Test Tube 3,2 is: " + dblDifference32);
        double dblDifference33 = Difference(p33, fp33);
        System.out.println("Difference in Test Tube 3,3 is: " + dblDifference33);

        double dblDifference41 = Difference(p41, fp41);
        System.out.println("Difference in Test Tube 4,1 is: " + dblDifference41);
        double dblDifference42 = Difference(p42, fp42);
        System.out.println("Difference in Test Tube 4,2 is: " + dblDifference42);
        double dblDifference43 = Difference(p43, fp43);
        System.out.println("Difference in Test Tube 4,3 is: " + dblDifference43);

        double dblDifference51 = Difference(p51, fp51);
        System.out.println("Difference in Test Tube 5,1 is: " + dblDifference51);
        double dblDifference52 = Difference(p52, fp52);
        System.out.println("Difference in Test Tube 5,2 is: " + dblDifference52);
        double dblDifference53 = Difference(p53, fp53);
        System.out.println("Difference in Test Tube 5,3 is: " + dblDifference53);

        double dblDifference61 = Difference(p61, fp61);
        System.out.println("Difference in Test Tube 6,1 is: " + dblDifference61);
        double dblDifference62 = Difference(p62, fp62);
        System.out.println("Difference in Test Tube 6,2 is: " + dblDifference62);
        double dblDifference63 = Difference(p63, fp63);
        System.out.println("Difference in Test Tube 6,3 is: " + dblDifference63);

        double dblDifference71 = Difference(p71, fp71);
        System.out.println("Difference in Test Tube 7,1 is: " + dblDifference71);
        double dblDifference72 = Difference(p72, fp72);
        System.out.println("Difference in Test Tube 7,2 is: " + dblDifference72);
        double dblDifference73 = Difference(p73, fp73);
        System.out.println("Difference in Test Tube 7,3 is: " + dblDifference73);

        System.out.println("Percent Change in 1,1: " + PercentChange(dblDifference11, p11));
        System.out.println("Percent Change in 1,2: " + PercentChange(dblDifference12, p12));
        System.out.println("Percent Change in 1,3: " + PercentChange(dblDifference13, p13));

        System.out.println("Percent Change in 2,1: " + PercentChange(dblDifference21, p21));
        System.out.println("Percent Change in 2,2: " + PercentChange(dblDifference22, p22));
        System.out.println("Percent Change in 2,3: " + PercentChange(dblDifference23, p23));

        System.out.println("Percent Change in 3,1: " + PercentChange(dblDifference31, p31));
        System.out.println("Percent Change in 3,2: " + PercentChange(dblDifference32, p32));
        System.out.println("Percent Change in 3,3: " + PercentChange(dblDifference33, p33));

        System.out.println("Percent Change in 4,1: " + PercentChange(dblDifference41, p41));
        System.out.println("Percent Change in 4,2: " + PercentChange(dblDifference42, p42));
        System.out.println("Percent Change in 4,3: " + PercentChange(dblDifference43, p43));

        System.out.println("Percent Change in 5,1: " + PercentChange(dblDifference51, p51));
        System.out.println("Percent Change in 5,2: " + PercentChange(dblDifference52, p52));
        System.out.println("Percent Change in 5,3: " + PercentChange(dblDifference53, p53));

        System.out.println("Percent Change in 6,1: " + PercentChange(dblDifference61, p61));
        System.out.println("Percent Change in 6,2: " + PercentChange(dblDifference62, p62));
        System.out.println("Percent Change in 6,3: " + PercentChange(dblDifference63, p63));

        System.out.println("Percent Change in 7,1: " + PercentChange(dblDifference71, p71));
        System.out.println("Percent Change in 7,2: " + PercentChange(dblDifference72, p72));
        System.out.println("Percent Change in 7,3: " + PercentChange(dblDifference73, p73));

    }

    public static double Difference(double dblStartingWeight, double dblFinalWeight) {

        double dblDifference = dblFinalWeight - dblStartingWeight;
        return dblDifference;

    }

    public static double PercentChange(double dblDifference, double dblStartingWeight) {

        double dblPercentChange = ((Math.abs(dblDifference))/dblStartingWeight)*100;
        return dblPercentChange;

    }

}
