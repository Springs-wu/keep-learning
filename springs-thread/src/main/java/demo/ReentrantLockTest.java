package demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i am a,i get the lock");
            } finally {
                lock.unlock();
            }
        });
        Thread b = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i am b,i get the lock");
            } finally {
                lock.unlock();
            }
        });
        a.start();
        b.start();
    }
}
