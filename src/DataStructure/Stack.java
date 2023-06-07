package DataStructure;

public class Stack {

    private int[] data;
    private int counter = 0;

    public Stack(int size){

        counter = 0;
        data = new int[size];

    }

    public boolean push(int e) {

        if (counter >= data.length) {
            return false;
        }
        else {
            data[counter] = e;
            counter++;
            return true;
        }

    }

    public int pop() {

        counter--;
        int intReturn = data[counter];
        data[counter] = 0;
        return intReturn;

    }

}
