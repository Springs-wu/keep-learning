package demo;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        //int[] a = new int[]{9,6,3,4,2,1,7,8,5};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    /**
     * 冒泡排序
     */
    private static void sort(int[] a)
    {
        //1.遍历n-1次
        //2.对比n-i次，每次对比前后两个数 如果前面的比后面大则交换
        //3.最少对比n次 有序的时候 返回条件：一轮没有交换则为有序
        int n = a.length;
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if (flag)
            {
                System.out.println("原始列表有序");
                break;
            }
        }
    }
}
