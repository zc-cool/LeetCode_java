/**
 * @author zhucheng
 * @create 2021-03-10-23:28
 */
package easy.array;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 843 👎 0
public class SearchInsertPosition35 {
    /*
    题目已知前提：数组有序（递增），无重复。所以此题简单遍历即可
                 遍历整个数组，
                   1.如果nums[i] == target 说明元素找到了，返回下标即可
                   2.如果nums[i] > target 说明数组中不存在该元素，因为该数组是无需递增的。所以遇到nums[i]>target
                     说明后面不用再遍历了，应该插入的位置正好就是第一次出现nums[i]>target时候的i
                   3.如果遍历整个数组都是nums[i] < target 说明数组中不存在该元素而且数组中的元素都小于target，
                     应该插入的位置是数组末尾位置。即nums.length
     */
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }
}
