/**
 * @author zhucheng
 * @create 2021-04-08-17:16
 */
package easy.array;
//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
//
// 示例 1：
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5
//
//
//
// 示例 2：
//
// 输入：[3,2]
//输出：-1
//
//
//
// 示例 3：
//
// 输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
// 说明：
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
// Related Topics 位运算 数组 分治算法
// 👍 80 👎 0
public class NMajorityElement17_10 {
    /*
    思路：摩尔投票法。但是最后需要判断该元素是不是众数(次数大于nums.length/2)
     */
    public int majorityElement(int[] nums) {
        //1.摩尔投票法，选出出现次数最多的元素。初始次数位1，从1下标开始
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                count = 1;
                major = nums[i];
            }else if(major == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        //2.判断胜出的元素是不是众数
        int flag = nums.length / 2;
        int n = 0;
        for(int num : nums){
            if(num == major) n++;
        }
        return n > flag ? major : -1;
    }

    //方法2：仍是摩尔投票法。与方法1不同的是计票规则有变化
    public int majorityElement2(int[] nums) {
        //1.摩尔投票法，选出出现次数最多的元素。初始次数为0，从0下标开始
        int major = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(major == nums[i]){
                count++;
            }else {
                if(count == 0){
                    major = nums[i];
                }else {
                    count--;
                }
            }
        }
        //2.判断胜出的元素是不是众数
        int flag = nums.length / 2;
        int n = 0;
        for(int num : nums){
            if(num == major) n++;
        }
        return n > flag ? major : -1;
    }
}
