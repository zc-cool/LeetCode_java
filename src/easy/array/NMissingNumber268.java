/**
 * @author zhucheng
 * @create 2021-04-08-12:11
 */
package easy.array;

import java.util.Arrays;

//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
//
// 进阶：
// 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
//
// 示例 1：
//输入：nums = [3,0,1]
//输出：2
//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
//
// 示例 2：
//输入：nums = [0,1]
//输出：2
//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
//
// 示例 3：
//输入：nums = [9,6,4,2,3,5,7,0,1]
//输出：8
//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
//
// 示例 4：
//输入：nums = [0]
//输出：1
//解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
//
// 提示：
// n == nums.length
// 1 <= n <= 104
// 0 <= nums[i] <= n
// nums 中的所有数字都 独一无二
//
// Related Topics 位运算 数组 数学
// 👍 381 👎 0
public class NMissingNumber268 {
    //方法1 自己写的，桶排序，遍历一遍。再次遍历桶，对应桶上的次数不是1（是0）说明缺失。
    public int missingNumber(int[] nums) {
        int[] order = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            order[nums[i]]++;
        }

        for(int j=0; j<order.length; j++){
            if(order[j] != 1) return j;
        }
        return 0;
    }

    //方法2  位运算
    /*
    题中的意思就是从数字[0,n]之间的n+1个数字少了一个，而其他的数字都存在。
    如果我们把这个数组添加从0~n的n+1个元素，就变成了数组中只有一个数出现了一次，
    其他数字都出现了2次，让我们求这个只出现一次的数字。这题使用位运算是最容易解决的，关于位运算有下面几个规律
    1^1=0;
    1^0=1;
    0^1=1;
    0^0=0;
    也就说0和1异或的时候相同的异或结果为0，不同的异或结果为1，根据上面的规律我们得到
    a^a=0；自己和自己异或等于0
    a^0=a；任何数字和0异或还等于他自己
    a^b^c=a^c^b；异或运算具有交换律
    有了这3个规律，这题就很容易解了，我们只需要把所有的数字都异或一遍，
    最终的结果就是我们要求的那个数字。来看下代码
     */
    public int missingNumber2(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++)
            xor ^= nums[i] ^ (i + 1);   //因为异或满足交换律和结合律
        return xor;
    }

    //方法3 二分查找
    //要想使用二分法，必须要想排序。一般的二分法查找，找到之后会直接返回，
    //这里使用二分法主要是在不断的缩小区间，直到找到为止。
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid) {
                //如果nums[mid] == mid也就是说当前元素的
                //下标等于他自己，比如数组[0,1,2,3,4,5]每
                //个元素的下标都等于他自己，说明[start,mid]
                //没有缺少任何数字，那么缺少的肯定是在[mid+1,end]
                start = mid + 1;
            } else {
                //如果当前元素的下标不等于他自己，比如[0,1,2,4]中
                //nums[3]==4，说明说明缺少的数字就在这个区间内
                end = mid;
            }
        }
        //如果类似于[0,1,2,3]这种start指向了数组的最后一个，我们让他加1
        return start == nums[start] ? start + 1 : start;
    }
}
