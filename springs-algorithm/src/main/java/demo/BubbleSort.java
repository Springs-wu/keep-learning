package Impl.algorithm;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < 10; j++) {
            a[j] = scanner.nextInt();
        }
        //int[] b = bubbleSort(a);
        //int[] b = direct(a);
        //int[] b = simpleChoose(a);
        int[] b = quickSort(a, 0, a.length - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(b[i]);
        }
    }

    /**
     * 冒泡排序
     * @param list
     * @return
     */
    private static int[] bubbleSort(int[] list) {
        int[] array = copyArray(list);
        // flag 作用是提前结束 如果数组是顺序的 一轮下来没有替换 则提前结束
        boolean flag = true;
        // i代表轮数 从1开始总共比较n-1轮
        for (int i = 1; i < array.length; i++) {
            // j代表每轮比较次数 总共n-i次 因为每一轮 后面的i个已经排好序了
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    private static int[] copyArray(int[] list) {
        int[] array = new int[list.length];
        System.arraycopy(list, 0, array, 0, list.length);
        return array;
    }

    /**
     * 直接插入
     * 简单选择
     * 希尔排序
     * 快排
     * 归并
     * 堆排序
     * 桶排序
     * 基数排序
     * 计数排序
     */
    /**
     * 直接插入
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * @param list
     * @return
     */
    private static int[] direct(int[] list) {
        int[] array = copyArray(list);
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j+1] = array[j];
                } else {
                    array[j+1] = temp;
                    break;
                }
                if (j == 0) {
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 简单选择
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     * @param list
     * @return
     */
    private static int[] simpleChoose(int[] list) {
        int[] array = copyArray(list);
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            changeMin(array, min, i);
        }
        return array;
    }

    private static void changeMin(int[] array, int min, int i) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    /**
     * 快速排序
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    private static int[] quickSort(int[] list, int start, int end) {
        int locate = sortArray(list, start, end);
        quickSort(list, start, locate - 1);
        quickSort(list, locate + 1, end);
        return list;
    }

    private static int sortArray(int[] array, int start, int end) {
        // max为第一个大于基准点的值的位置 基准点为第一个值
        int max = start;
        boolean flag = false;
        for (int i = start + 1; i <= end; i++) {
            // 1.获取到比基准点大的位置
            if (array[i] > array[start] && !flag) {
                max = i;
                flag = true;
            }
            // 2.如果值比基准点小 则往左交换 且找到了比基准点大的值
            if (array[i] <= array[start] && max != start) {
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
                max++;
            }
        }
        if (start != max) {
            int temp = array[start];
            array[start] = array[max - 1];
            array[max - 1] = temp;
            return max - 1;
        }
        // 不等于它说明从来没有移动过 列表是倒序的
        return start;
    }
}
