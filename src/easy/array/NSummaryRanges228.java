/**
 * @author zhucheng
 * @create 2021-04-08-10:14
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;

//给定一个无重复元素的有序整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
// 示例 3：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：["-1"]
//
//
// 示例 5：
//
//
//输入：nums = [0]
//输出：["0"]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
// Related Topics 数组
// 👍 152 👎 0
public class NSummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        //1.边界条件
        if(nums.length == 0) return list;

        //使用StringBuilder进行字符串拼接
        StringBuilder sb = new StringBuilder();
        //定义两个指针，i，j。j=i+1.边界条件是j<nums.length.i++,j++
        for (int i = 0, j = i + 1; j <nums.length ; i++,j++) {
            //如果num[j]-nums[i] != 1。说明i所指的元素是不连续的，直接添加。然后将sb置空
            if(nums[j] - nums[i] != 1){
                sb.append(nums[i]);
                list.add(sb.toString());
                sb = new StringBuilder();
                //否则，说明i所指的元素是连续的，需要判断i是不是连续元素刚开始的首元素
            }else{
                //如果，此时sb的长度是0，说明i是连续元素的首元素，添加"nums[i]->"
                if(sb.length() == 0){
                    sb.append(nums[i]);
                    sb.append("->");
                }
            }
        }
        //循环结束，数组末尾元素需要添加。如果元素末尾是不连续的，可以
        //如果元素末尾是连续的，由于前面循环中如果是连续的，只有"nums[i]->"，此时
        //添加完毕是"nums[i]->nums[nums.length-1]"，也可以。
        sb.append(nums[nums.length-1]);
        list.add(sb.toString());
        return list;
    }
}
