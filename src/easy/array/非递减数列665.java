/**
 * @author zhucheng
 * @create 2021-04-14-13:11
 */
package easy.array;
//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
//
//
// 示例 2:
//
//
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10 ^ 4
// - 10 ^ 5 <= nums[i] <= 10 ^ 5
//
// Related Topics 数组
// 👍 566 👎 0
public class 非递减数列665 {
    public boolean checkPossibility(int[] nums) {
        //1.边界条件
        if(nums.length == 1) return true;
        //2.count记录修正的元素个数
        int count = 0;
        //3.遍历数组，如果当前下标i元素大于后一个下标i+1元素
        //  3.1如果i是数组首元素，则“坏点”是i下标的元素，nums[i] = nums[i+1]
        //  3.2如果i-1下标元素小于等于i+1下标元素，则“坏点”是i下标的元素，nums[i] = nums[i-1]
        //  3.3如果i-1下标元素大于i+1下标元素，则“坏点”是i+1下标的元素，nums[i+1] = nums[i]
        //  将count+1
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]){
                if(i==0){
                    nums[i] = nums[i+1];
                }else if(nums[i-1] <= nums[i+1]){
                    nums[i] = nums[i-1];
                }else{
                    nums[i+1] = nums[i];
                }
                count++;
            }
        }
        //4.判断数组末尾元素和前一个元素的大小，如果末尾元素小于前一个元素，则“坏点”是末尾元素。
        //nums[nums.length-1] = nums[nums.length-2]但是没有必要了，count+1就行了。
        if(nums[nums.length-1] < nums[nums.length-2]) count++;
        //判断count的大小，count > 1则false。
        return count <= 1;
    }
}
