package Impl.threadPackage;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 200
                , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200), new MyThreadFactory("test-thread-pool-"), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new RunTest());
        }

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(new MyThreadFactory("single-thread-pool-"));
        for (int i = 0; i < 10; i++) {
            singleThreadExecutor.execute(new RunTest());
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5,new MyThreadFactory("fixed-thread-pool-"));
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new RunTest());
        }*/

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5, new MyThreadFactory("scheduled-thread-pool-"));
        //scheduledThreadPool.schedule(new RunTest(), 10, TimeUnit.SECONDS);
        //scheduledThreadPool.schedule(Executors.callable(new RunTest()), 2, TimeUnit.SECONDS);
        //scheduledThreadPool.scheduleAtFixedRate(new RunTest(), 0, 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(new RunTest(), 0, 4, TimeUnit.SECONDS);
       /* ExecutorService cachedThreadPool = Executors.newCachedThreadPool(new MyThreadFactory("cached-thread-pool-"));
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(new RunTest());
        }*/
    }

    static class RunTest implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(LocalDateTime.now());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now()+"i am " + Thread.currentThread().getName());
        }
    }
}
