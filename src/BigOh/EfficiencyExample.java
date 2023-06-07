package BigOh;

public class EfficiencyExample {

    public static void main(String[] args) {

        int n = 10;
        doFirst(n);
        doSecond(n);
        doThird(n);
        doFourth(n);

    }

    public static void doFirst(int n) {

        // O(n) = cn + 2c          The O is theta in this case
        int count = 0; // c
        for (int i = 0; i < n; i++) { // n
            count++; // c
        }
        System.out.println(count); // c

    }

    public static void doSecond(int n) {

        int count = 0; // c
        for (int i = 0; i < n; i++) { // n
            for (int j=0; j < n; j++) { // n
                count++; // c
            }
        }
        System.out.println(n + ": " + count); // c

    }

    public static void doThird(int n) {

        int count = 0; // c
        for (int i = 0; i < n; i++) { // n
            for (int j = i; j < n; j++) { // <n
                count++; // c
            }
        }
        System.out.println(n + ": " + count); // c

    }

    public static void doFourth(int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+i; j++) {
                count++;
            }
        }
        System.out.println(n + ": " + count);

    }

}
