package DataStructure;

public class StackDriver {

    public static void main(String[] args) {

        Stack s = new Stack(10);

        s.push(12);
        s.push(10);
        s.push(8);

        int top = s.pop();
        int top2 = s.pop();
        int top3 = s.pop();
        System.out.println(top3);

    }

}
