/**
 * @author zhucheng
 * @create 2021-04-09-16:42
 */
package easy.array;

import java.util.Arrays;

//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
//
// 以数组形式返回答案。
//
//
//
// 示例 1：
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释：
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。
//对于 nums[3]=2 存在一个比它小的数字：（1）。
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
//
//
// 示例 2：
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
//
//
// 示例 3：
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 500
// 0 <= nums[i] <= 100
//
// Related Topics 数组 哈希表
// 👍 151 👎 0
public class NSmallerNumbersThanCurrent1365 {
    //方法1：
    /*
    思路：
        数组ans是结果数组。
        拷贝数组nums元素到nums2中，将数组nums2的数组排序。
        遍历nums数组的元素，使用二分查找在nums2中进行查找，返回索引下标j。
        注意，因为可能有重复元素，所以二分查找需要检查一下前一个元素是不是也是所要查找的元素。
        索引下标j就代表比所要比较的元素小的个数。
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums,0,nums2,0,nums.length);
        Arrays.sort(nums2);

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = Arrays.binarySearch(nums2,nums[i]);
            while(j > 0 && nums2[j-1] == nums[i]){
                j--;
            }
            ans[i] = j;
        }
        return ans;
    }
    //方法2：使用桶排序  题目：0 <= nums[i] <= 100
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        //桶，统计nums中元素出现的次数。下标就是nums中的元素
        int[] bucket = new int[101];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        //更新桶中的元素值（变成比当前元素小的个数）
        for (int j = 1; j < 101; j++) {
            bucket[j] = bucket[j] + bucket[j-1];
        }

        //遍历nums数组，找到nums中元素在桶中对应的值（注意，应该是桶前一个下标的值，不包括自身）
        int[] ans = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            ans[k] = bucket[nums[k]] == 0 ? 0 : bucket[nums[k]-1];
        }
        return ans;
    }
}
