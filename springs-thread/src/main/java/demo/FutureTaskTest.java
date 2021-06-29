package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) {
        List<Future> result = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future submit = executorService.submit(new myRunnable());
            result.add(submit);
        }
        for (Future future : result) {
            while (true) {
                if (future.isDone() && !future.isCancelled()) {
                    try {
                        System.out.println(future.get());
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class myRunnable implements Callable {

        @Override
        public Object call() throws Exception {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        }
    }
}
