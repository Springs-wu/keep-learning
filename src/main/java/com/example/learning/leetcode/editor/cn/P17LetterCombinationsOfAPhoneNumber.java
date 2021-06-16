//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 1005 👎 0

package com.example.learning.leetcode.editor.cn;

import java.util.*;

//Java: 电话号码的字母组合
//Date: 2020-11-21 21:02:00
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args){
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("239");
        System.out.println(strings);
    }
    //com.example.lenrning.leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        char[] chars;
        int len;
        Map<Character,List<String>> map;
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }
            chars = digits.toCharArray();
            len = chars.length;
            setMap();
            List<String> charByDigit = map.get(chars[0]);
            List<String> res = new ArrayList<>();
            for (String s : charByDigit) {
                String r = "";
                getStringList(r, res, s, 1);
            }
            return res;
        }

        private void getStringList(String r, List<String> res, String s, int i) {
            if (i == len) {
                res.add(r + s);
                return;
            }
            List<String> charByDigit = map.get(chars[i]);
            for (String s1 : charByDigit) {
                getStringList(r + s, res, s1, i + 1);
            }
        }

        private void setMap() {
            map = new HashMap<>(8);
            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "q", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));
        }

}
//com.example.lenrning.leetcode submit region end(Prohibit modification and deletion)

}