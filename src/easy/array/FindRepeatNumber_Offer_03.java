/**
 * @author zhucheng
 * @create 2021-04-09-9:16
 */
package easy.array;

import java.util.HashMap;
import java.util.Map;

//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 373 👎 0
public class FindRepeatNumber_Offer_03 {
    //方法1：桶排序
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for(int j = 0; j < count.length; j++){
            if(count[j] >= 2) return j;
        }
        return -1;
    }
    //方法2：使用HashMap，效果不如方法1
    public int findRepeatNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                return i;
            }else{
                map.put(i,1);
            }
        }
        return -1;
    }
}
