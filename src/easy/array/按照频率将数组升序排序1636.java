/**
 * @author zhucheng
 * @create 2021-04-16-16:22
 */
package easy.array;
//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
//
// 请你返回排序后的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
//
//
// 示例 2：
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
//
//
// 示例 3：
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
// Related Topics 排序 数组
// 👍 21 👎 0
public class 按照频率将数组升序排序1636 {
    /*
    思路：
    将nums中数按出现次数排序，bucket
    定义出现频率count初值为1，然后从后向前遍历bucket。如果bucket中有值等于
    count，则将count次的bucket下标添加到ans数组中。直到ans数组满为止。
     */
    public int[] frequencySort(int[] nums) {
        int[] bucket = new int[201];
        for(int num : nums) bucket[num+100]++;

        int[] ans = new int[nums.length];
        int count = 1;  //定义出现频率初值为1
        for (int i = 0; i < ans.length; ) {
            for (int j = 200; j >= 0; j--) {
                if(bucket[j] == count){
                    while(bucket[j] > 0){
                        ans[i] = j-100;
                        bucket[j]--;
                        i++;
                    }
                }
            }
            count++;
        }
        return ans;
    }
}
