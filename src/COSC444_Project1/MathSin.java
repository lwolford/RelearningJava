package COSC444_Project1;

public class MathSin extends Thread {

    public double dblDegree;
    public double dblResult;

    public MathSin(int intDegree) {
        dblDegree = intDegree;
    }

    public void run() {
        System.out.println("Executing sin of: " + dblDegree);
        double dblDegreeToRadian = Math.toRadians(dblDegree);
        dblResult = Math.sin(dblDegreeToRadian);
        System.out.println("Exit from MathSin. Result = " + dblResult);
    }

}
