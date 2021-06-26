package Impl.threadPackage;

public class ThreadCreate extends Thread {
    @Override
    public void run() {
        System.out.println("111");
    }

    public static void main(String[] args) {
        Thread thread = new ThreadCreate();
        thread.start();
    }
}
