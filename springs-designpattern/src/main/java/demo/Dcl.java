package demo;

public class Dcl {
    private Dcl() {
    }

    private static volatile Dcl singleton;

    public static Dcl getSingleton() {
        if (null == singleton) {
            synchronized (Dcl.class) {
                if (null == singleton) {
                    singleton = new Dcl();
                }
            }
        }
        return singleton;
    }

    private void showMessage() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Dcl dcl = new Dcl();
        dcl.showMessage();
        Dcl singleton = Dcl.getSingleton();
        singleton.showMessage();
    }
}
