## 76. 最小覆盖子串

**题目：**

给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

**注意:**
不能使用代码库中的排序函数来解决这道题。

**示例：**

```md
输入：S = "ADOBECODEBANC", T = "ABC"
输出："BANC"
```

### 双指针滑动窗口+哈希表

使用两个哈希表，一个记录所需要的字符还需要多少，另一个记录当前滑动窗口中各字符的数量有多少，*count*记录滑动窗口中已经包含了*t*中多少字符。

开始左指针不动，右指针向右移动，直到窗口中包含了*t*中全部字符，开始移动左指针收缩，收缩到窗口中````刚好不满足*t*中的字符为止。如此循环，一旦*count == t.length*说明当前是满足条件的，记录此时的大小和字符串。

```java
class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[128], need = new int[128];
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int count = 0, min = ss.length;
        String res = "";
        for (int i = 0; i < tt.length; i++) {
            need[tt[i]]++;
        }
        int i = 0, j = 0;
        while(j < ss.length) {
            char c = ss[j];
            window[c]++;
            if (window[c] <= need[c]) count++;
            while(count == tt.length) {
                if (j - i + 1 <= min){
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if (window[ss[i]] < need[ss[i]]) count--;
                i++;
                if (i >= ss.length) break;
            }
            j++;
        }
        return res;
    }
}
```

#### 复杂度分析

* 时间复杂度：*O(n)*
  
    遍历一遍数组。
* 空间复杂度：*O(1)*

    使用了字典数量的额外空间。

我的博客：<https://me.csdn.net/qq_20067165?ref=miniprofile>