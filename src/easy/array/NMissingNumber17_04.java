/**
 * @author zhucheng
 * @create 2021-04-08-22:48
 */
package easy.array;
//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
//
// 注意：本题相对书上原题稍作改动
//
// 示例 1：
//
// 输入：[3,0,1]
//输出：2
//
//
//
// 示例 2：
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
//
// Related Topics 位运算 数组 数学
// 👍 38 👎 0
public class NMissingNumber17_04 {
    /*
    思路：位运算。异或^. 满足交换律，结合律。
    a ^ a = 0
    0 ^ a = a
    将nums数组中的元素和0~n+1个数异或。相同的异或结果为0.
    最终的就是只出现一次的数
     */
    public int missingNumber(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            miss = miss ^ nums[i] ^ (i+1);
        }
        return miss;
    }
}
