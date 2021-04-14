/**
 * @author zhucheng
 * @create 2021-04-13-22:22
 */
package easy.array;
//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
//
//
//
// 示例 1：
//
//
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
//
//
// 示例 2：
//
//
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] 为 0 或 1
// flowerbed 中不存在相邻的两朵花
// 0 <= n <= flowerbed.length
//
// Related Topics 贪心算法 数组
// 👍 339 👎 0
public class NCanPlaceFlowers605 {
    /*
    思路：贪心算法。连续三个0，才能种下一颗花。
    注意：数组首元素和末尾元素的情况。首元素左边没有元素了，末尾元素右边没有元素了。

     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        int[] nums = new int[flowerbed.length+2];
        System.arraycopy(flowerbed,0,nums,1,flowerbed.length);
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i-1] == 0 && nums[i] == 0 && nums[i+1] == 0){
                nums[i] = 1;
                ans++;
            }
        }
        return ans >= n;
    }
}
