package Impl.designPattern;

public class StaticInnerClass {
    private StaticInnerClass() {

    }

    private static class InnerClass {
        private static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public static StaticInnerClass getStaticInnerClass(){
        return InnerClass.staticInnerClass;
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = StaticInnerClass.getStaticInnerClass();
    }

}
