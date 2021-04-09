/**
 * @author zhucheng
 * @create 2021-04-08-13:19
 */
package easy.array;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1793 👎 0
public class NSingleNumber136 {
    /*
    位运算
    异或^ :按位异或，相同为0，不同为1。异或满足交换律，结合律
    a ^ a = 0
    0 ^ a = a
    0 ^ 0 = 0
    0和任何数异或结果还是任何数本身。
    两个相同的数异或结果是0

    所以此题很简单。遍历一遍数组，将数组中的元素全部异或一遍。出现两次的异或都为0，最后结果就是
    只出现一次的元素
     */
    public int singleNumber(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            flag = flag ^ nums[i];
        }
        return flag;
    }
}