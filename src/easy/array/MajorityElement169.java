/**
 * @author zhucheng
 * @create 2021-04-02-19:05
 */
package easy.array;

import java.util.HashMap;
import java.util.Map;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 938 👎 0
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        int max = 0;
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        return index;
    }
}
