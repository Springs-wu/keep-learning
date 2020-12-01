//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 460 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java: 复原IP地址
//Date: 2020-11-25 23:38:07
public class P93RestoreIpAddresses{
    public static void main(String[] args){
        Solution solution = new P93RestoreIpAddresses().new Solution();
        List<String> strings = solution.restoreIpAddresses("101023");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<String>> lists = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() == 0 || s.length() < 4) {
                return new ArrayList<>();
            }
            // 即把String拆成4个数字，不含前导0 且在0到255之间
            char[] chars = s.toCharArray();
            List<String> res = new ArrayList<>();
            getIp(res, chars, 0);
            List<String> result = new ArrayList<>();
            for (List<String> list : lists) {
                StringBuilder sb = new StringBuilder();
                for (String s1 : list) {
                    sb.append(s1).append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
            }
            return result;
        }

        private void getIp(List<String> res, char[] chars, int i) {
            for (int j = i ; j < chars.length; j++) {
                String str = "";
                for (int k = i; k <= j; k++) {
                    str += String.valueOf(chars[k]);
                }
                if (isEffective(str)) {
                    res.add(str);
                    if (res.size() == 4) {
                        if (i == chars.length-1) {
                            lists.add(res);
                            return;
                        }
                        res.remove(3);
                        continue;
                    }
                    getIp(res, chars, j + 1);
                    res.remove(res.size() - 1);
                }
            }
        }

        private boolean isEffective(String s) {
            if (s.length() > 1 && s.startsWith("0")) {
                return false;
            }
            int cha = Integer.parseInt(s);
            return cha >= 0 && cha <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}