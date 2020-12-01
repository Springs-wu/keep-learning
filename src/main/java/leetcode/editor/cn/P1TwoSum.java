//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9732 👎 0

package leetcode.editor.cn;
//Java: 两数之和
//Date: 2020-12-01 22:38:03
public class P1TwoSum{
    public static void main(String[] args){
        Solution solution = new P1TwoSum().new Solution();
        int[] ints = solution.twoSum(new int[]{2, 11, 7, 15}, 9);
        System.out.println(""+ints[0]+""+ints[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int source = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == target - source)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}