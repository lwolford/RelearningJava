package learningNow;

public class LUFactorization {

    public static void main(String[] args) {

        double[][] A = { {1, -2, -2, -3}, {3, -9, 0, -9}, {-1, 2, 4, 7}, {-3, -6, 26, 2} };
        //double[][] A = { {1,2,3}, {3,4,5}, {5,6,7}};
        colLU(A);
        printMatrix(A);

    }

    // (Row, Column)
    public static void colLU(double[][] A) {
        int n = A.length;
        for (int k = 0; k < n; k++) {
            for (int j = k; j < n; j++) {
                double printed = A[j][k] /= A[k][k];
                System.out.println("Part 1: A(" + j + "," + k + ") = " + printed + "     j = " + j + " k = " + k);
            }
            for (int j = k + 1; j < n; j++) {
                for (int i = k + 1; i < n; i++) {
                    double printed = A[i][j] -= A[i][k] * A[k][j];
                    if (i > j) {
                        System.out.println("Part 2: L(" + i + "," + j + ") = " + printed + "     i = " + i + " j = " + j);
                    }
                    else {
                        System.out.println("Part 2: U(" + i + "," + j + ") = " + printed + "     i = " + i + " j = " + j);
                    }
                }
            }
        }
    }

    public static void printMatrix(double[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.3f ", A[i][j]);
            }
            System.out.println();
        }
    }

}
