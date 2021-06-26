//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 276 👎 0

package com.example.learning.leetcode.editor.cn;
//Java: 字符串相加
//Date: 2020-11-15 22:35:30
public class P415AddStrings{
    public static void main(String[] args){
        Solution solution = new P415AddStrings().new Solution();
        String s = solution.addStrings("593", "1738");
        System.out.println(s);
    }
    //com.example.lenrning.leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        // 位数相加 高位补0 考虑进位 考虑最后一位进位
        // 593+1738=2331
        // 注意：
        // 1.补0 0是字符 不是数字
        // 2.循环时边界问题
        int maxLen = Math.max(num1.length(), num2.length());
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        array1 = setZero(array1, maxLen);
        array2 = setZero(array2, maxLen);
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = maxLen - 1; i >= 0; i--) {
            int c1 = Integer.parseInt(String.valueOf(array1[i]));
            int c2 = Integer.parseInt(String.valueOf(array2[i]));
            int sum = c1 + c2 + ans;
            ans = sum / 10;
            sb.append(sum % 10);
        }
        if (ans == 1)
        {
            sb.append(ans);
        }
        return sb.reverse().toString();
    }

        private char[] setZero(char[] array, int maxLen) {
            if (array.length == maxLen) {
                return array;
            }
            int num = maxLen - array.length;
            char[] a = new char[maxLen];
            for (int i = 0; i < maxLen; i++) {
                if (i < num) {
                    a[i] = '0';
                } else {
                    a[i] = array[i-num];
                }
            }
            return a;
        }
    }
//com.example.lenrning.leetcode submit region end(Prohibit modification and deletion)

}