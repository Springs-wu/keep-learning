package demo;

public class RunnableTest implements Runnable {

    @Override
    public void run() {
        System.out.println("222");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest());
        thread.start();
    }
}
