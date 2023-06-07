package COSC444_Project1;

public class MathCos extends Thread {

    public double dblDegree;
    public double dblResult;

    public MathCos(int intDegree) {
        dblDegree = intDegree;
    }

    public void run() {
        System.out.println("Executing cos of: " + dblDegree);
        double dblDegreeToRadian = Math.toRadians(dblDegree);
        dblResult = Math.cos(dblDegreeToRadian);
        System.out.println("Exit from MathCos. Result = " + dblResult);
    }

}
