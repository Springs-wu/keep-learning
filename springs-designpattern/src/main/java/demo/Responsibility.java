package com.example.learning.DesignPattern;

/**
 * chain
 * 责任链模式
 * 核心思想就是使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 * 用请假流程审批做例子（也可以用敏感词过滤做例子）
 * 1.三天以内 主管审批
 * 2.7天以内 总监审批
 * 3.21天以内 总经理审批
 * 4.21天以上 拒绝
 */
public class Responsibility {
    public static abstract class Approval
    {
        protected int MIN = 3;
        protected int MID = 7;
        protected int MAX = 21;
        protected Approval nextApproval;
        public void setNextApproval(Approval approval)
        {
            this.nextApproval = approval;
        }

        abstract void leave(int days);
    }

    public static class ConcreteComponentA extends Approval{

        @Override
        void leave(int days) {
            if (days <= this.MIN)
            {
                System.out.println("ConcreteComponentA 审批通过");
                return;
            }

            if (this.nextApproval != null)
            {
                this.nextApproval.leave(days);
            }
            else {
                System.out.println("审批拒绝");
            }
        }
    }

    public static class ConcreteComponentB extends Approval{

        public Approval approval;

        @Override
        void leave(int days) {
            if (days <= this.MID)
            {
                System.out.println("ConcreteComponentB 审批通过");
                return;
            }
            if (this.nextApproval != null)
            {
                this.nextApproval.leave(days);
            }
            else {
                System.out.println("审批拒绝");
            }
        }
    }

    public static class ConcreteComponentC extends Approval{

        @Override
        void leave(int days) {
            if (days <= this.MAX)
            {
                System.out.println("ConcreteComponentC 审批通过");
                return;
            }
            if (this.nextApproval != null)
            {
                this.nextApproval.leave(days);
            }
            else {
                System.out.println("审批拒绝");
            }
        }
    }

    public static void main(String[] args) {
        int days = 21;
        ConcreteComponentC componentC = new ConcreteComponentC();
        ConcreteComponentB componentB = new ConcreteComponentB();
        ConcreteComponentA componentA = new ConcreteComponentA();
        componentA.setNextApproval(componentB);
        componentB.setNextApproval(componentC);
        componentA.leave(days);
    }
}
