/**
 * @author zhucheng
 * @create 2021-04-13-10:27
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
//
//
// 示例 1：
//
//
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。
//
// 示例 2：
//
//
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
//
//
// 示例 3：
//
//
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
// Related Topics 数组
// 👍 215 👎 0
public class NThirdMax414 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i : nums) set.add(i);
        List<Integer> list = new ArrayList<>(set);

        if(list.size() < 3) return list.get(list.size()-1);
        return list.get(list.size()-3);
    }

    public int thirdMax2(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == max1 || num == max2 || num == max3) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
