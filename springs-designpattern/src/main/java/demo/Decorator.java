package demo;

/**
 * 装饰器
 */
public class Decorator {
    private interface Component
    {
         String descript();
         double cost();
    }

    private static class ConcreteComponent implements Component
    {
        @Override
        public String descript() {
            return "ConcreteComponent";
        }
        @Override
        public double cost() {
            return 0.99;
        }
    }

    private static class BaseDecorator implements Component
    {
        @Override
        public String descript() {
            return "";
        }
        @Override
        public double cost() {
            return 0;
        }
    }


    private static class ConcreteDecoratorA extends BaseDecorator
    {
        private Component component;

        public ConcreteDecoratorA(Component component)
        {
            this.component = component;
        }

        @Override
        public String descript() {
            return "ConcreteDecoratorA," + component.descript();
        }


        @Override
        public double cost()
        {
            return 0.12 + component.cost();
        }

    }

    private static class ConcreteDecoratorB extends  BaseDecorator
    {
        private Component component;

        public ConcreteDecoratorB(Component component)
        {
            this.component = component;
        }

        @Override
        public String descript() {
            return "ConcreteDecoratorB," + component.descript();
        }


        @Override
        public double cost()
        {
            return 0.15 + component.cost();
        }
    }

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);
        System.out.println(component.descript() + "," + component.cost());
    }
}
