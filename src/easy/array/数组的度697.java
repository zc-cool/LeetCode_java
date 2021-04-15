/**
 * @author zhucheng
 * @create 2021-04-14-14:55
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;

//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//
//
// 示例 1：
//
//
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
//
//
// 示例 2：
//
//
//输入：[1,2,2,3,1,4,2]
//输出：6
//
//
//
//
// 提示：
//
//
// nums.length 在1到 50,000 区间范围内。
// nums[i] 是一个在 0 到 49,999 范围内的整数。
//
// Related Topics 数组
// 👍 333 👎 0
public class 数组的度697 {
    public int findShortestSubArray(int[] nums) {
        //1.桶，记录nums数组中数字出现的次数
        int[] bucket = new int[50000];
        for(int num : nums) bucket[num]++;
        //2.遍历桶，找到nums数组中元素出现次数的最大值，即nums的度
        int max = bucket[0];
        for (int i = 0; i < 50000; i++) {
            if(bucket[i] >= max) max = bucket[i];
        }
        //3.遍历桶，找到nums数组中出现次数最多的元素是哪个（可能多个）。装进集合中
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            if(bucket[i] == max) list.add(i);
        }
        //4.遍历集合中的元素（这些元素都是导致nums度的元素，即出现次数都是一样的）
        //在nums中找到该元素第一次出现和最后一次出现的位置（保证连续子数组度和nums一样）
        //求前后的长度（保证该元素最短的长度）
        int len = nums.length;
        for(Integer e : list){
            int pre = 0;
            int last = nums.length-1;
            while(pre <= last){
                if(nums[pre] == e && nums[last] == e){
                    len = Math.min(len,last-pre+1);
                    break;
                }else if(nums[pre] == e && nums[last] != e){
                    last--;
                }else if(nums[pre] != e && nums[last] == e){
                    pre++;
                }else {
                    pre++;
                    last--;
                }
            }
        }
        return len;
    }
}
