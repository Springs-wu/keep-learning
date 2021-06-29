package demo;

import java.util.Scanner;

/**
 * 给定一个总和和数字数量 输出连续的几位数字相加为总和的数字， 没有则输出-1
 * 输入 78 3
 * 输出 25 26 27
 * 输入 66 4
 * 输出 15 16 17 18
 * 输入 66 3
 * 输出 21 22 23
 * 输入 66 2
 * 输出 -1
 */
public class TestAdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] numArrays = s.split(" ");
            Integer total = Integer.valueOf(numArrays[0]);
            Integer nums = Integer.valueOf(numArrays[1]);
            int totalSub = getTotalSub(nums);
            if ((total - totalSub) % nums != 0) {
                System.out.println(-1);
                continue;
            }
            int start = (total - totalSub) / nums;
            if (start < 1) {
                System.out.println(-1);
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums; i++) {
                stringBuilder.append(start + i);
                if (i != nums - 1) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private static int getTotalSub(Integer nums) {
        int total = 0;
        for (int i = 1; i < nums; i++) {
            total += i;
        }
        return total;
    }
}
