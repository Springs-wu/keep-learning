package demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("==========>异步执行 无返回值");
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world1");
        });
        System.out.println("==========>异步执行 带返回值");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "hello,");
        System.out.println(completableFuture.get());

        System.out.println("==========>异步执行 带返回值 链式调用1-使用返回值-并返回结果");
        CompletableFuture<String> completableFuture1= CompletableFuture.supplyAsync(() -> "hello,").
                thenApply(k -> k + "world2");
        System.out.println(completableFuture1.get());

        System.out.println("==========>异步执行 带返回值 链式调用1-使用返回值-不返回结果-一般用在链式调用最后执行某些操作");
        CompletableFuture.supplyAsync(() -> "hello,").
                thenAccept(k -> System.out.println(k + "world3"));

        System.out.println("==========>异步执行 带返回值 链式调用1-不返回值-不返回结果-一般用在链式调用最后执行某些操作");
        CompletableFuture.supplyAsync(() -> "hello,").
                thenRun(() -> System.out.println("world4"));

        System.out.println("==========>组合 compose 依赖");
        CompletableFuture<Double> longFuture1 = CompletableFuture.supplyAsync(() ->{
            return 3.0;
        });
        CompletableFuture<Double> highFuture1 = CompletableFuture.supplyAsync(() ->{
            return 4.0;
        });

        System.out.println("==========>组合 combine 独立");
        CompletableFuture<Double> longFuture = CompletableFuture.supplyAsync(() ->{
            return 3.0;
        });
        CompletableFuture<Double> highFuture = CompletableFuture.supplyAsync(() ->{
            return 4.0;
        });
        CompletableFuture<Double> resultFuture = longFuture.thenCombine(highFuture, (longValue, higValue) -> {
            return longValue * higValue;
        });
        System.out.println(resultFuture.get());

        System.out.println("==========>allof");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 3";
        });

        List<CompletableFuture<String>> futureList = Arrays.asList(future1,future2,future3);
        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(future1, future2, future3).thenApply(s -> {
            return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        });
        System.out.println(listCompletableFuture.get());

        System.out.println("==========>anyof");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 4";
        });
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 5";
        });
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 6";
        });
        CompletableFuture<Object> future = CompletableFuture.anyOf(future4, future5, future6);
        System.out.println(future.get());

        System.out.println("==========>exceptionally");

        System.out.println("==========>handle");
    }
}
