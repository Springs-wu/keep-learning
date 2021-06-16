package com.example.learning.thread.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> threads = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            threads.add(t);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger);
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for(;;){
            int i = atomicInteger.get();
            boolean success = atomicInteger.compareAndSet(i, ++i);
            if (success) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
