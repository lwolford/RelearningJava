package Paradigms;

public class TestScores {

    private String strName;
    private int intGrade;
    private int intAvgScore = 70;

    public TestScores(String strName, int intGrade) {
        this.strName = strName;
        this.intGrade = intGrade;
    }

    public String getGrade() {
        if (intGrade >= 90 && intGrade <=100) return "A";
        else if (intGrade >= 80 && intGrade < 90) return "B";
        else if (intGrade >= 70 && intGrade < 80) return "C";
        else if (intGrade >= 60 && intGrade < 70) return "D";
        else if (intGrade >= 0 && intGrade < 60) return "F";
        else return "Invalid Grade";
    }

    public String betterThanAvg() {
        if (intGrade > intAvgScore) {
            return strName + " scored higher than the average";
        }
        else if (intGrade == intAvgScore) {
            return strName + " scored equal to the average";
        }
        else return strName + " scored below the average";
    }

    public void gradeOverride(int grade) {
        intGrade = grade;
    }

    public void gradeSubtract(int grade) {
        grade -= 5;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getIntGrade() {
        return intGrade;
    }

    public void setIntGrade(int intGrade) {
        this.intGrade = intGrade;
    }

    public int getIntAvgScore() {
        return intAvgScore;
    }

    public void setIntAvgScore(int intAvgScore) {
        this.intAvgScore = intAvgScore;
    }
}
