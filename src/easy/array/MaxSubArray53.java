/**
 * @author zhucheng
 * @create 2021-03-12-10:54
 */
package easy.array;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2981 👎 0
public class MaxSubArray53 {
    /*
    思路:
    连续的子序列，且求得之和最大。对于第一个元素，最大值只能是nums[0]，即最优解是opt(0) = nums[0];
    对于第二个元素，最大值是max(opt(0)+nums[1], nums[1]) 因为连续，所以最大值是自身，或者是自身加上前面字串最优解。
    即最优解opt(1) = max(opt(0)+nums[1], nums[1]).
    对于第三个元素，最大值是max(opt(1)+nums[2], nums[2]) 因为连续，所以最大值是自身，或者是自身加上前面字串最优解。
    即最优解opt(2) = max(opt(1)+nums[2], nums[2]).
    ..............
    对于第i个元素，最大值是max(opt(i-1)+nums[i], nums[i]) 因为连续，所以最大值是自身，或者是自身加上前面字串最优解。
    即最优解opt(i) = max(opt(i-1)+nums[i], nums[i]).
     */
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }
    //动态规划
    public static int maxSubArray(int[] nums) {
        //边界条件
        if(nums == null) return 0;

        //申请dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
