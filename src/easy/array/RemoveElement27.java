/**
 * @author zhucheng
 * @create 2021-03-04-20:44
 */
package easy.array;
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 num
//s = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100
//
// Related Topics 数组 双指针
// 👍 784 👎 0
public class RemoveElement27 {
    //第一版
    public static int removeElement1(int[] nums, int val) {
        int last = nums.length;
        for(int i=0; i<last; ){     //使用两个指针来完成，如果前指针值nums[i]为val，则将
            if(nums[i] == val){     //nums[i] = nums[last-1] 将后面的赋值给前面，但是前指针不移动
                nums[i] = nums[last-1];  //继续进行判断，因为赋值过来的值可能也是val，继续进行判断
                last--;                  //而后指针需要向前移动一位，
            }else {
                i++;
            }
        }
        return last;
    }

    //第二版
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for(int num : nums){    //遍历整个数组
            if(num != val){
                nums[i] = num;  //如果数组中元素不为val，说明是需要的元素，将其进行数组覆盖
                i++;            //将需要的元素重新覆盖进该数组中，则遍历结束，nums[0]-nums[i]
            }                   //元素都是需要的元素，i也就是所需要求的长度
        }
        return i;
    }
}
