package thread.base;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wu
 * @date 2021.6.8
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //futureTaskGetTest();
        //futureTaskDoneTest();
        //completeFutureTest();
        //completeFutureRunTest();
        //completeFutureSupplyTest();
        completeFutureSupplyTest2();
    }

    /**
     * 普通future 阻塞获取
     */
    private static void futureTaskGetTest()
    {
        FutureTask<String> future = new FutureTask<>(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception ex) {

            }
            return "Hello";
        });
        Thread thread = new Thread(future);
        thread.start();
        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 循环校验获取
     */
    private static void futureTaskDoneTest()
    {
        FutureTask<String> future = new FutureTask<>(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        Thread thread = new Thread(future);
        thread.start();
        try {
            while (!future.isDone())
            {
                Thread.sleep(1000);
                System.out.println("未执行完成");
            }
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completeFutureTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completedFuture = new CompletableFuture<>();
        completedFuture.complete("Hello");
        System.out.println(completedFuture.get());
    }

    private static void completeFutureRunTest()  {
        CompletableFuture<Void> noReturn = CompletableFuture.runAsync(() -> {
            System.out.print("hello");
        });
        noReturn.thenRun(()->{
            System.out.print(" world");
        });
    }

    private static void completeFutureSupplyTest() {
        System.out.println("=================>thenAccept");
        CompletableFuture<String> returnAccept = CompletableFuture.supplyAsync(() -> "Hello");
        // 可以使用上一个的返回值，但是本身没有返回
        returnAccept.thenAccept(name ->{
            System.out.println(name + " world");
        });
        System.out.println("=================>thenRun");
        CompletableFuture<String> returnRun = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return "Hello";
        });
        // 不能使用上一个的返回值，本身也没有返回
        returnRun.thenRun(() ->{
            System.out.print(" world");
        });
    }

    private static void completeFutureSupplyTest2() throws ExecutionException, InterruptedException {
        System.out.println("=================>thenApply 分散");
        CompletableFuture<String> returnApply = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });
        CompletableFuture<String> thenApply = returnApply.thenApply(name -> {
            return name + " world";
        });

        System.out.println(returnApply.get());
        System.out.println(thenApply.get());

        System.out.println("=================>thenApply 传递");
        CompletableFuture<String> returnApply2 = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApply(name -> {
            return name + " world";
        }).thenApply(name ->{
            return name + ",I am springs";
        });

        System.out.println(returnApply2.get());
    }
}
