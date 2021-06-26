package Impl.algorithm;

import java.util.regex.Pattern;

public class ReorderDatainLogFiles {

    public static void main(String[] args) {
        // "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"
        String[] logs = new String[5];
        logs[0] = "dig1 8 1 5 1";
        logs[1] = "let1 art can";
        logs[2] = "dig2 3 6";
        logs[3] = "let2 own kit dig";
        logs[4] = "let3 art zero";
        String[] strings = reorderLogFiles(logs);
        System.out.println(strings);
    }

    public static String[] reorderLogFiles(String[] logs) {
        //定义两个指针 从后米面遍历 一个指向第一个不为数字的下标。另一个向前遍历，如果为数字，则交换
        // 把所有数字日志按顺序移到最后
        // 再排序前面的字母日志[0,last-1]
        // 字母日志可以用冒泡法来排序
        int last = getLast(logs);
        int start = last-1;
        for (int i = start;i >= 0;i--)
        {
            String s = logs[i];
            String[] array = s.split(" ");
            if (isNumber(array[1]))
            {
                String temp = logs[last];
                logs[last] = logs[i];
                logs[i] = temp;
                last--;
            }
        }
        for (int i = 1; i <= last;i++)
        {
            for (int j = 0;j <= last - i;j++)
            {
                if (compareStr(logs[j],logs[j+1]))
                {
                    String temp = logs[j+1];
                    logs[j+1] = logs[j];
                    logs[j] = temp;
                }
            }
        }
        return logs;
    }

    private static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }

    private static int getLast(String[] logs)
    {
        for (int i = logs.length-1;i > 0;i--)
        {
            String s = logs[i];
            String[] array = s.split(" ");
            if (!isNumber(array[1]))
            {
                return i;
            }
        }
        return 0;
    }

    private static boolean compareStr(String s1,String s2)
    {
        String[] array1 = s1.split(" ");
        String[] array2 = s2.split(" ");
        int min = Math.min(array1.length,array2.length);
        for (int i = 1;i < min; i++)
        {
            if(array1[i].compareTo(array2[i]) > 0)
            {
                return true;
            } else if (array1[i].compareTo(array2[i]) < 0)
            {
                return false;
            }
        }
        return array1[0].compareTo(array2[0]) > 0;
    }
}
