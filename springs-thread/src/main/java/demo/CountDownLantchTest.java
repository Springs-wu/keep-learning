package Impl.threadPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLantchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        List<String> result = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int j = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    lock.lock();
                    result.add("i am " + j);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();

                }
            });
            thread.start();
        }
        try {
            countDownLatch.await();
            System.out.println("結束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - l);
    }
}
