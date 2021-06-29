package demo;

public class StaticObject {
    private StaticObject() {

    }

    private static StaticObject staticObject = new StaticObject();

    public static StaticObject getStaticObject() {
        return staticObject;
    }

    public void showMessage() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticObject staticObject = new StaticObject();
        staticObject.showMessage();
        StaticObject staticObject1 = StaticObject.getStaticObject();
        staticObject1.showMessage();
    }
}
