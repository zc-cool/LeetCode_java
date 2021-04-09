/**
 * @author zhucheng
 * @create 2021-04-09-10:37
 */
package easy.array;

import java.util.Arrays;

//统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 113 👎 0
public class Search_Offer53_I {
    //二分查找
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums,target);
        if(index < 0) return 0;

        //向前向后找重复的元素。
        int count = 0;
        int flag = index;
        while(index < nums.length && nums[index] == target){
            count++;
            index++;
        }
        while(flag > 0 && nums[flag-1] == target){
            count++;
            flag--;
        }
        return count;
    }
}
