package demo;

import java.util.Stack;

/**
 * 有效字符
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VaildParentheses {
    public boolean isValid(String s) {
        if (s.isEmpty())
        {
            return true;
        }
        int len = s.length();
        char[] array = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0;i < len; i++)
        {
            String sChar = String.valueOf(array[i]);
            if (stack.empty()){
                stack.push(sChar);
            } else if (isMatch(stack.peek(),sChar)) {
                stack.pop();
            } else {
                stack.push(sChar);
            }
        }
        if (stack.empty())
        {
            return true;
        }
        return false;
    }

    private boolean isMatch(String a ,String b)
    {
        if ("(".equals(a) && ")".equals(b))
        {
            return true;
        }
        if ("{".equals(a) && "}".equals(b))
        {
            return true;
        }
        if ("[".equals(a) && "]".equals(b))
        {
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        if (s.isEmpty())
        {
            return true;
        }
        int len = s.length();
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < len; i++)
        {
            if (stack.empty()){
                stack.push(array[i]);
            } else if (isMatch2(stack.peek(), array[i])) {
                stack.pop();
            } else {
                stack.push(array[i]);
            }
        }
        if (stack.empty())
        {
            return true;
        }
        return false;
    }

    private boolean isMatch2(char a ,char b)
    {
        if (a == '(' && b == ')')
        {
            return true;
        }
        if (a == '{' && b == '}')
        {
            return true;
        }
        if (a == '[' && b == ']')
        {
            return true;
        }
        return false;
    }
}
