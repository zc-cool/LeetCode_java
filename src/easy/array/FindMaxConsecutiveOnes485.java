/**
 * @author zhucheng
 * @create 2021-04-13-13:23
 */
package easy.array;
//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 226 👎 0
public class FindMaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while(j<nums.length && nums[j] == 1){
                j++;
            }
            max = Math.max(max,j-i);
            i = j;
        }
        return max;
    }
}
