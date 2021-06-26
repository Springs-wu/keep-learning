package Impl.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

import static java.util.Collections.swap;

/**
 * 给一个全是0/1/2的数组 排序 要求时间复杂度为O(n) 空间复杂度
 *
 * 前后两个指针，A指向不是0的 B指向不是2的
 * 然后有一个指针C从A开始向后遍历，
 * 当c为0时和a交换，a往后移到下一个不为0的，
 * 当c为2时和b交换，b往前移到下一个不为2的
 * 当c为1时，c往后移一位
 *
 */
public class ListSort {
    public static void main(String[] args) {
        List<Integer> a = Lists.newArrayList(0, 1, 2, 0, 1, 2, 2, 1, 0, 0, 2, 1, 0, 1, 2, 0, 1, 2, 0, 2, 1, 0, 1, 2, 0);
        sortList(a);
    }

    private static void sortList(List<Integer> a) {
        int indexOne = 0;
        int indexTwo = a.size() - 1;
        indexOne = getOnePlace(a, indexOne);
        indexTwo = getTwoPlace(a, indexTwo);
        int indexZero = indexOne;
        while (indexZero <= indexTwo) {
            if (a.get(indexZero) == 0) {
                swap(a, indexZero, indexOne);
                indexOne = getOnePlace(a, indexOne);
            } else if (a.get(indexZero) == 2) {
                swap(a, indexZero, indexTwo);
                indexTwo = getTwoPlace(a, indexTwo);
            } else {
                indexZero++;
            }
        }
        System.out.println(a);
    }

    private static int getTwoPlace(List<Integer> a, int indexTwo) {
        while (a.get(indexTwo) == 2) {
            indexTwo--;
        }
        return indexTwo;
    }

    private static int getOnePlace(List<Integer> a, int indexOne) {
        while (a.get(indexOne) == 0) {
            indexOne++;
        }
        return indexOne;
    }
}
