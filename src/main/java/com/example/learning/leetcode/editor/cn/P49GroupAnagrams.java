//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 518 👎 0

package com.example.learning.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java: 字母异位词分组
//Date: 2020-11-14 21:20:01
public class P49GroupAnagrams{
    public static void main(String[] args){
        Solution solution = new P49GroupAnagrams().new Solution();
    }
    //com.example.lenrning.leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length ==0 ) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
//com.example.lenrning.leetcode submit region end(Prohibit modification and deletion)

}