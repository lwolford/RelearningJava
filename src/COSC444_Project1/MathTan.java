package COSC444_Project1;

public class MathTan extends Thread {

    public double dblDegree;
    public double dblResult;

    public MathTan(int intDegree) {
        dblDegree = intDegree;
    }

    public void run() {
        System.out.println("Executing tan of: " + dblDegree);
        double dblDegreeToRadian = Math.toRadians(dblDegree);
        dblResult = Math.tan(dblDegreeToRadian);
        System.out.println("Exit from MathTan. Result = " + dblResult);
    }

}
