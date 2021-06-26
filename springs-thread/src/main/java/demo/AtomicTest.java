package Impl.threadPackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicLong atomicLong = new AtomicLong();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AtomicReference<Integer> atomicReference = new AtomicReference<Integer>();
        atomicReference.compareAndSet(0, 1);
        atomicBoolean.compareAndSet(false, true);
        atomicInteger.getAndIncrement();
        atomicLong.getAndIncrement();
    }
}
