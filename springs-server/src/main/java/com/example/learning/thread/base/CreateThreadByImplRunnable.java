package com.example.learning.thread.base;

public class CreateThreadByImplRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("impl runnable");
    }

    public static void main(String[] args) {
        new Thread(new CreateThreadByImplRunnable()).start();
    }
}
