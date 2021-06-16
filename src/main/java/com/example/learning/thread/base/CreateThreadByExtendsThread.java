package com.example.learning.thread.base;

public class CreateThreadByExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("extends Thread");
    }

    public static void main(String[] args) {
        new CreateThreadByExtendsThread().start();
    }
}
