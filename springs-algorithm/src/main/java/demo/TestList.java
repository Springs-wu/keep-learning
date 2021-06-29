package demo;

import java.util.*;

public class TestList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] numberArray = s.split(",");
            Set<Integer> numSet = new HashSet<Integer>();
            for (String number : numberArray) {
                if (verifyNum(Integer.valueOf(number))) {
                    continue;
                }
                numSet.add(Integer.valueOf(number));
            }
            if (numSet.size() != numberArray.length) {
                System.out.println(-1);
                continue;
            }
            if (existRepeatNum(numSet)) {
                System.out.println(-1);
                continue;
            }
            List<Integer> numList = new ArrayList<Integer>(numSet);
            Collections.sort(numList);
            Integer maxNum = numList.get(numList.size() - 1);
            addOtherNum(numList);
            Collections.sort(numList);

            List<Integer> result = new ArrayList<Integer>(numList);
            for (Integer num : numList) {
                for (Integer num1 : numList) {
                    if (numEquals(num, num1)) {
                        continue;
                    }
                    result.add(Integer.valueOf(num + "" + num1));
                }
            }
            System.out.println(result.get(maxNum - 1));
        }
    }

    private static boolean numEquals(Integer num, Integer num1) {
        if (num.equals(2) && num1.equals(5)) {
            return true;
        }
        if (num.equals(5) && num1.equals(2)) {
            return true;
        }
        if (num.equals(6) && num1.equals(9)) {
            return true;
        }
        if (num.equals(9) && num1.equals(6)) {
            return true;
        }
        return num.equals(num1);
    }

    private static void addOtherNum(List<Integer> numList) {
        if (numList.contains(2)) {
            numList.add(5);
        } else if (numList.contains(5)) {
            numList.add(2);
        }
        if (numList.contains(6)) {
            numList.add(9);
        } else if (numList.contains(9)) {
            numList.add(6);
        }
    }

    private static boolean existRepeatNum(Set<Integer> numSet) {
        if (numSet.contains(2) && numSet.contains(5)) {
            return true;
        }
        if (numSet.contains(6) && numSet.contains(9)) {
            return true;
        }
        return false;
    }

    private static boolean verifyNum(Integer number) {
        return number < 1 || number > 9;
    }
}
