/**
 * @author zhucheng
 * @create 2021-04-13-15:30
 */
package easy.array;

import java.util.Arrays;

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：6
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：24
//
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3]
//输出：-6
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
//
// Related Topics 数组 数学
// 👍 290 👎 0
public class MaximumProduct628 {
    /*
    思路：
    排序，最大值出现在数组最后三个数相乘，或者数组第一个第二个负数和最后一个整数相乘
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0]*nums[1]*nums[len-1],nums[len-3]*nums[len-2]*nums[len-1]);
    }
}
