package Impl.algorithm;

import java.util.Stack;

/**
 * 斐波那契数列计算
 * 给出位数，计算数值
 * fun1为递归
 * fun2为非递归
 */
public class FeiboTest {
    public static void main(String[] args) {
        int x = 45;
        long l = System.currentTimeMillis();
        System.out.println(fun2(x));
        System.out.println(System.currentTimeMillis() - l);
    }
    private static int fun(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fun(n - 1) + fun(n - 2);
    }

    private static int fun2(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(1);
        while (stack.size() < n) {
            Integer var1 = stack.pop();
            Integer var2 = stack.pop();
            stack.push(var2);
            stack.push(var1);
            stack.push(var1 + var2);
        }
        return stack.pop();
    }
}
