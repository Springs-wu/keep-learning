package Impl.threadPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class CasConcurrent implements Runnable {

    private static AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Thread(new CasConcurrent()));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }

    public void run() {
        while (true) {
            System.out.println(atomicLong.incrementAndGet());
        }
    }
}
