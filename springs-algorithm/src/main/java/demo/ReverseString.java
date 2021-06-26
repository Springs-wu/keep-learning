package Impl.algorithm;

/**
 * 翻转字符串
 * abcd->dcba
 */
public class ReverseString {
    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(reverseString2(a));
    }

    /**
     * 借用一个数组 反向输入 空间复杂度O(n)
     * @param iniString
     * @return
     */
    public static String reverseString(String iniString) {
        // write code here
        if(iniString.length()==1) return iniString;
        char[] char_list = new char[iniString.length()];
        for (int i = iniString.length() - 1; i >= 0; i--) {
            char_list[iniString.length() - i - 1] = iniString.charAt(i);
        }
        return String.valueOf(char_list);
    }

    /**
     * 借用一个变量 交换 空间复杂度O(1)
     * @param iniString
     * @return
     */
    public static String reverseString2(String iniString) {
        // write code here
        if(null == iniString || iniString.length() == 1) {
            return iniString;
        }
        char[] charList = iniString.toCharArray();
        int size = charList.length;
        int halfSize = size / 2;
        for (int i = 0; i < halfSize; i++) {
            char temp = charList[i];
            charList[i] = charList[size-i-1];
            charList[size-i-1] = temp;
        }
        return String.valueOf(charList);
    }
}
