/**
 * @author zhucheng
 * @create 2021-04-09-11:16
 */
package easy.array;
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
//输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 数组 二分查找
// 👍 126 👎 0
public class NMissingNumber_Offer_53_II {
    //方法1：使用位运算异或
    public int missingNumber(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            miss ^= nums[i] ^ (i+1);
        }
        return miss;
    }

    //方法2：使用二分查找
    //若丢失了某元素，则该下标元素!=该下标
    //先找中间，若中间下标对应的值不等于中间下标，说明在左半部分出现了missing
    //若中间下标对应的值等于中间下标，说明在右半部分出现了missing
    public int missingNumber2(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]!=m){
                j=m-1;
            }else{
                i=m+1;
            }
        }
        return i;
    }
}
