//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别
// 为 (i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2023 👎 0

package com.example.learning.leetcode.editor.cn;
//Java: 盛最多水的容器
//Date: 2020-12-03 21:06:41
public class P11ContainerWithMostWater{
    public static void main(String[] args){
        Solution solution = new P11ContainerWithMostWater().new Solution();
    }
    //com.example.lenrning.leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int area = 0;
        while (left != right)
        {
            int leftValue = height[left];
            int rightValue = height[right];
            if (leftValue <= rightValue)
            {
                area = leftValue * (right - left);
                left++;
            }
            else {
                area = rightValue * (right - left);
                right--;
            }
            if (area > max)
            {
                max = area;
            }
        }
        return  max;
    }
}
//com.example.lenrning.leetcode submit region end(Prohibit modification and deletion)

}