package Impl.algorithm;

import java.util.*;

/**
 * 数值转换为价格显示
 * 例：1798646->1,798,646
 * @author wu
 * @date 2020.08.13
 */
public class NumberChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        List<Integer> list = new ArrayList<>();
        do {
            int b =  a % 1000;
            list.add(b);
            a = a / 1000;
        } while(a > 0);

        StringBuffer s = new StringBuffer();
        for(int i = list.size()-1;i>=0;i--)
        {
            s.append(list.get(i));
            if(i!=0)
            {
                s.append(",");
            }
        }
        System.out.println(s.toString());
    }
}