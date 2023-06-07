package ParadigmES;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDriver {

    public static void main(String[] args) {
        executorServiceInvoke();
        executorServiceInvoke2();
    }

    private static void executorServiceInvoke() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("This is the executor service example:" + i);
            }
        });
    }

    private static void executorServiceInvoke2() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.submit(() -> {
            for (int i = 100; i > 0; i--) {
                System.out.println("This is the executor service example 2:" + i);
            }
        });
    }

}
