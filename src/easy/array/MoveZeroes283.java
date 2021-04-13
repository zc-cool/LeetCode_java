/**
 * @author zhucheng
 * @create 2021-04-12-23:55
 */
package easy.array;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1022 👎 0
public class MoveZeroes283 {
    /*
    思路：采用覆盖的思想
    遍历数组，如果数组下标的值与覆盖数组下标的值相等，并且数组下标的值不是0，并且两个下标相等
    则不进行覆盖，因为该数组目前扫描到的元素就是不需要移动的。
    如果数组下标的值不是0，则进行覆盖。如果数组下标的值是0，则index不变，数组i下标移动一位。
    遍历结束，根据index的值，和数组长度来计算补0的个数
     */
    public void moveZeroes(int[] nums) {
        //index覆盖后数组的下标
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 && nums[i] == nums[index] && i == index){
                index++;
            }else if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        //元素遍历结束后，计算需要0的个数
        while(index < nums.length){
            nums[index] = 0;
            index++;
        }
    }
}
