package ExceptionLab;

public class ExceptionDriver {

    public static void main(String[] args) {
        System.out.println(normalException("3"));
        System.out.println(normalException("Hello"));
        try {
            System.out.println(returnMultiplication(3, 5));
            System.out.println(returnMultiplication(5, -3));
        }
        catch (NegativeNumberException e) {
            System.out.println("The number was negative, so a negative number exception has been thrown");
        }

    }

    public static int normalException(String strParse) {
        try {
            int intParse = Integer.parseInt(strParse);
            return intParse;
        }
        catch (NumberFormatException e) {
            System.out.println("The string could not be parsed and will return 0. Please use a valid number");
            return 0;
        }
    }

    public static int returnMultiplication(int n1, int n2) throws NegativeNumberException {
        if (n1*n2 >=0) {
            return n1*n2;
        }
        else throw new NegativeNumberException("Number can't be negative");
    }

}
