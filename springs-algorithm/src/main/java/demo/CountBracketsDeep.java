package Impl.algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * 计算括号深度 不符合规范则返回0
 * 例 [{}] 返回2 [{}{}] 返回2 [{}{()}] 返回3
 * {[}]{} 返回0
 */
public class CountBracketsDeep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            System.out.println(getDeep(chars));
        }
    }

    private static int getDeep(char[] chars) {
        Stack<String> stack = new Stack<String>();
        int nowDeep = 0;
        int maxDeep = 0;
        for (char aChar : chars) {
            String charStr = String.valueOf(aChar);
            if (stack.empty()){
                stack.push(charStr);
                nowDeep++;
                continue;
            }
            String peek = stack.peek();
            if (charFit(charStr, peek)) {
                maxDeep = Math.max(maxDeep, nowDeep);
                nowDeep--;
                stack.pop();
            } else {
                stack.push(charStr);
                nowDeep++;
            }
        }
        if (stack.empty()) {
            return maxDeep;
        }
        return 0;
    }

    private static boolean charFit(String charStr, String peek) {
        if ("{".equals(peek) && "}".equals(charStr)) {
            return true;
        } else if ("[".equals(peek) && "]".equals(charStr)) {
            return true;
        } else if ("(".equals(peek) && ")".equals(charStr)) {
            return true;
        }
        return false;
    }
}
