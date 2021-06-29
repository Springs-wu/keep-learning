package demo;

/**
 * 最长回文串
 */
public class LongestPalindrome {
    /**
     * 暴力解
     * 两层遍历，判断是否为回文串
     * 时间复杂度O(n3)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
        {
            return s;
        }
        char[] array = s.toCharArray();
        int beginLen = 0;
        int maxLength = 0;
        for (int i = 0;i < len-1;i++)
        {
            for (int j = i + 1;j < len;j++)
            {
                if(j - i + 1 > maxLength && isPalinDrome(array,i,j)){
                    maxLength = j - i + 1;
                    beginLen = i;
                }
            }
        }
        return s.substring(beginLen, beginLen + maxLength);
    }

    private boolean isPalinDrome(char[] array,int i,int j)
    {
        while(i<j)
        {
            if(array[i]!=array[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 中心扩散法
     * 一次遍历 分别求奇数回文串和偶数回文串的长度
     * 得到最大子串
     * @param s
     * @return
     */
    public String longestPalindromeForCenter(String s) {
        int len = s.length();
        if (len < 2)
        {
            return s;
        }
        char[] array = s.toCharArray();
        int beginLen = 0;
        int maxLength = 0;
        for (int i = 0;i < len - 1;i++)
        {
            int singleLen = palinDromeLen(array,i,i);
            int twoLen = palinDromeLen(array,i,i+1);
            int maxLen = Math.max(singleLen,twoLen);
            if(maxLen>maxLength)
            {
                maxLength = maxLen;
                beginLen = i-(maxLen -1)/2;
            }
        }
        return s.substring(beginLen,beginLen+maxLength);
    }

    private int palinDromeLen(char[] array,int i,int j)
    {
        while(i >= 0 && j < array.length)
        {
            if(array[i] != array[j])
            {
                break;
            }
            i--;
            j++;
        }
        return j-i-1;
    }

    /**
     * 动态规划
     * dp[i][j] = array[i] == array[j] and dp[i+1][j-1]
     * 边界条件 j-1-(i+1)+1<2 = j - i < 3
     * 从列递增计算，使左下方[i+1][j-1]先有值
     * @param s
     * @return
     */
    public String longestPalindromeForDynamic(String s) {
        int len = s.length();
        if (len < 2)
        {
            return s;
        }
        char[] array = s.toCharArray();
        int beginLen = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        for (int j = 1;j < len;j++)
        {
            for(int i = 0;i < j;i++)
            {
                if(array[i] != array[j])
                {
                    dp[i][j] = false;
                } else {
                    if(j - i < 3)
                    {
                        dp[i][j] = true;
                    } else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLength)
                {
                    maxLength = j - i + 1;
                    beginLen = i;
                }
            }
        }
        return s.substring(beginLen,beginLen+maxLength);
    }
}
