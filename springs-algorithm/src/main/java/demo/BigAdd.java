package demo;

/**
 * 大数相加
 */
public class BigAdd
{
    public static void main(String[] args) {
        System.out.println(add("123", "45"));
        System.out.println(add("785", "658"));
    }

    private static String add(String a,String b) {
        int max = Math.max(a.length(), b.length());
        char[] aList = new char[max];
        char[] bList = new char[max];
        aList = setList(aList,a);
        bList = setList(bList,b);
        StringBuilder sb = new StringBuilder();
        int ins = 0;
        for (int i = max-1; i >= 0; i--) {
            int aInt = Integer.valueOf(String.valueOf(aList[i]));
            int bInt = Integer.valueOf(String.valueOf(bList[i]));
            int sum = aInt + bInt + ins;
            ins = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
        if (ins > 0) {
            sb.append(ins);
        }
        return sb.reverse().toString();
    }

    private static char[] setList(char[] list, String str) {
        char[] chars = str.toCharArray();
        if (chars.length == list.length) {
            return chars;
        }
        int i = list.length - chars.length;
        for (int j = 0; j < list.length; j++) {
            if (j < i) {
                list[j] = "0".toCharArray()[0];
            } else {
                list[j] = chars[j - i];
            }
        }
        return list;
    }
}