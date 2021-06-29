package demo;


/**
 * 校验两个字符串的字符是否完全一致
 */
public class CheckSam {
    public static void main(String[] args) {
        System.out.println(checkSam("This is nowcoder", "is This nowcoder"));
    }

    public static boolean checkSam(String stringA, String stringB) {
        // write code here
        // 长度不一样 返回错误
        // 计数法 两个字符串都放入数组中 值为出现次数 遍历两个数组是否相等
        if (stringA.length() != stringB.length()) {
            return false;
        }
        char[] char_a = new char[256];
        char[] char_b = new char[256];
        for (int i = 0;i<stringA.length();i++){
            char_a[stringA.charAt(i)]++;
            char_b[stringB.charAt(i)]++;
        }
        for (int j = 0;j<stringA.length();j++){
            if (char_a[stringA.charAt(j)] != char_b[stringA.charAt(j)]){
                return false;
            }
        }
        return true;
    }
}
