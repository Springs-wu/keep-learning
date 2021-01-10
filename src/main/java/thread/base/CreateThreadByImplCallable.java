package thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadByImplCallable implements Callable<String> {

    @Override
    public String call() {
        return "impl callable";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new CreateThreadByImplCallable());
        futureTask.run();
        try {
            String res = futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
