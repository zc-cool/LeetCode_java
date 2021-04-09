/**
 * @author zhucheng
 * @create 2021-04-09-13:15
 */
package easy.array;
//给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
//
// 请你返回 nums 中唯一元素的 和 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,2]
//输出：4
//解释：唯一元素为 [1,3] ，和为 4 。
//
//
// 示例 2：
//
// 输入：nums = [1,1,1,1,1]
//输出：0
//解释：没有唯一元素，和为 0 。
//
//
// 示例 3 ：
//
// 输入：nums = [1,2,3,4,5]
//输出：15
//解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
//
// Related Topics 数组 哈希表
// 👍 6 👎 0
public class SumOfUnique1748 {
    public int sumOfUnique(int[] nums) {
        //1.使用桶来记录nums数组中元素出现的次数，桶的下标是nums中的元素值
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        //2.遍历桶，桶中元素的次数为1，则将该桶的下标进行加合。
        int sum = 0;
        for (int j = 0; j < count.length; j++) {
            if(count[j] == 1)
                sum += j;
        }
        return sum;
    }
}
