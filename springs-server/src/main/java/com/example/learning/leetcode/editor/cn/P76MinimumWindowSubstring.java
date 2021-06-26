//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
// ADOBEC BECODEBA CODEBA BANC
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 833 👎 0

package com.example.learning.leetcode.editor.cn;

//Java: 最小覆盖子串
//Date: 2020-11-17 23:12:03
public class P76MinimumWindowSubstring{
    public static void main(String[] args){
        Solution solution = new P76MinimumWindowSubstring().new Solution();
    }
    //com.example.lenrning.leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String minWindow(String s, String t) {
            int[] window = new int[128];
            int[] need = new int[128];
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            int min = ss.length;
            String res = "";
            for (int i = 0; i < t.length(); i++) {
                need[tt[i]]++;
            }
            int i = 0, j = 0, count = 0;
            while (j < ss.length) {
                char c = ss[j];
                window[c]++;
                if (window[c] <= need[c]) count++;
                while (count == tt.length) {
                    if (j - i + 1 <= min) {
                        res = s.substring(i, j+1);
                        min = j - i + 1;
                    }
                    window[ss[i]]--;
                    if (window[ss[i]] < need[ss[i]]) count--;
                    i++;
                    if (i > ss.length) break;
                }
                j++;
            }
            return res;
        }
    }
//com.example.lenrning.leetcode submit region end(Prohibit modification and deletion)

}