package Paradigms;

public class ParadigmDriver {

    public static void main(String args[]) {

        TestScores ts = new TestScores("Adam", 71);
        System.out.println(ts.getGrade());
        System.out.println(ts.betterThanAvg());
        ts.gradeOverride(90);
        System.out.println(ts.getGrade());

        ts.gradeSubtract(ts.getIntGrade());
        System.out.println(ts.getGrade());

    }

}
