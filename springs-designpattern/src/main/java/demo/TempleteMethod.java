package demo;

/**
 * 模板方法
 */
public class TempleteMethod {
    /**
     * 电饭锅
     */
    public static abstract class ElectricCooker
    {
        final void done()
        {
            System.out.println("洗米");
            System.out.println("把米放入锅中");
            System.out.println("放入适量的水");
            chooseFunction();
            System.out.println("做好了");
        }

        protected abstract void chooseFunction();
    }

    /**
     * 煮饭
     */
    public static class Cook extends ElectricCooker
    {
        @Override
        protected void chooseFunction() {
            System.out.println("选择煮饭按钮");
        }
    }

    /**
     * 煮粥
     */
    public static class Congee extends ElectricCooker
    {
        @Override
        protected void chooseFunction() {
            System.out.println("选择煮粥按钮");
        }
    }

    public static void main(String[] args) {
        Cook cook = new Cook();
        cook.done();

        Congee congee = new Congee();
        congee.done();
    }
}
