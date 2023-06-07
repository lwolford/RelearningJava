package COSC444_Project1;

public class MathThreads {

    public static void main(String args[]) {

        MathSin st = new MathSin(45);
        MathCos ct = new MathCos(60);
        MathTan tt = new MathTan(30);

        st.start();
        ct.start();
        tt.start();

        try {
            st.join();
            ct.join();   //wait for completion of all thread and then sum
            tt.join();
            double z = st.dblResult + ct.dblResult + tt.dblResult;
            System.out.println("Sum of sin, cos, tan = " + z);
        }
        catch (InterruptedException IntExp) {

        }

    }

}
