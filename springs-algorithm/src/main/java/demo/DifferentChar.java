package Impl.algorithm;

/**
 * 校验是否有重复字符
 */
public class DifferentChar {

    public static void main(String[] args) {
        String a = "acbdbesy";
        System.out.println(checkDifferent(a));
    }

    public static boolean checkDifferent(String iniString) {
        // write code here
        if (iniString.length()>256) return false;
        boolean[] char_set = new boolean[256];
        for(int i = 0;i<iniString.length();i++)
        {
            if(char_set[iniString.charAt(i)])
            {
                return false;
            }
            char_set[iniString.charAt(i)] = true;
        }
        return true;
    }
}
