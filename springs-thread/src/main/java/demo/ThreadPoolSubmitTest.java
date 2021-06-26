package Impl.threadPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolSubmitTest {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        List<String> list = Collections.synchronizedList(result);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 200,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200), new MyThreadFactory("test-thread-pool-"), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i am " + Thread.currentThread().getName());
            });
        }
        while (list.size() != 10) {

        }
        System.out.println(list);
        System.out.println(System.currentTimeMillis() - l);
    }

    static class RunTest implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am " + Thread.currentThread().getName());
        }
    }
}
