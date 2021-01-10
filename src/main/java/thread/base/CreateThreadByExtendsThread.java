package thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadByExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("extends Thread");
    }

    public static void main(String[] args) {
        new CreateThreadByExtendsThread().start();
    }
}
