package Concurrency;

import java.util.concurrent.*;

public class ConcurrencyLab {

    public static void main(String[] args) {
        executorServiceInvoke();
        executorInvoke();
    }

    private static void executorInvoke() {
        Executor e = new Caller();
        e.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("This is the executor example:" + i);
            }
        });
    }

    private static void executorServiceInvoke() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("This is the executor service example:" + i);
            }
        });
    }

}
