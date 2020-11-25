//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 561 👎 0

package leetcode.editor.cn;
//Java: 解码方法
//Date: 2020-11-22 14:46:05
public class P91DecodeWays{
    public static void main(String[] args){
        Solution solution = new P91DecodeWays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if(s.charAt(0)=='0'){
                return 0;
            }
            int [] dp = new int [s.length()+1];//长度为n时，的排列组合种类
            dp[0] = 1;
            dp[1] = 1;
            if(s.length()==1)   return dp[1];
            for(int i=2;i<=s.length();i++){
                int num = Integer.parseInt(String.valueOf(s.charAt(i-1)));//得到当前数；
                int nums2 = Integer.parseInt(String.valueOf(s.charAt(i-2)));//得到当前数的前一个数
                if (nums2+num==0||(num==0&&nums2>2)){
                    return 0;
                }else if(num==0||nums2==0){
                    dp[i] = num==0?dp[i-2]:dp[i-1];
                }else{
                    dp[i] = nums2*10+num>26?dp[i-1]:dp[i-2]+dp[i-1];
                }

            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}