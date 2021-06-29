package demo;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    /**
     * 暴力解法 双重循环
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxlen = 0;
        char[] array = s.toCharArray();
        Set<Character> sets = new HashSet<>();
        for (int i = 0;i < array.length;i++)
        {
            for (int j = i;j < array.length;j++)
            {
                if (sets.contains(array[j])) {
                    if (sets.size() > maxlen)
                    {
                        maxlen = sets.size();
                    }
                    sets = new HashSet<>();
                    break;
                } else {
                    sets.add(array[j]);
                }
            }
        }
        if (!sets.isEmpty() && sets.size() > maxlen)
        {
            maxlen = sets.size();
        }
        return maxlen;
    }

    /**
     * 解法二 滑动窗口
     * 假设 k 到 r是不重复字段
     * 那么k+1到r也是不重复字段
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxlen = 0;
        int end = -1;
        int n = s.length();
        Set<Character> sets = new HashSet<>();
        for (int i = 0;i < n; i++)
        {
            if (i != 0)
            {
                sets.remove(s.charAt(i-1));
            }
            while (end + 1 < n && !sets.contains(s.charAt(end + 1)))
            {
                sets.add(s.charAt(end + 1));
                end++;
            }
            maxlen = Math.max(maxlen, end - i + 1);
        }
        return maxlen;
    }

}
