package ExamOne;

public class Structures {

    public static void main(String[] args) {

        int[] intNumbers = new int[5];
        intNumbers[0] = 1;
        intNumbers[1] = 2;
        intNumbers[2] = 3;

        System.out.println(intNumbers.length);

    }

    public static void arrayInsert(int[] intArray) {
        if (intArray[intArray.length-1] != 0) {

        }
    }

    public static void printArray(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray);
        }
        System.out.println();
    }

}
