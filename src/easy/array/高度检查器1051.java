/**
 * @author zhucheng
 * @create 2021-04-15-14:19
 */
package easy.array;

import java.util.Arrays;

//学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
//
// 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
//
// 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
//
//
//
// 示例：
//
//
//输入：heights = [1,1,4,2,1,3]
//输出：3
//解释：
//当前数组：[1,1,4,2,1,3]
//目标数组：[1,1,1,2,3,4]
//在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
//在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
//在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
//
// 示例 2：
//
//
//输入：heights = [5,1,2,3,4]
//输出：5
//
//
// 示例 3：
//
//
//输入：heights = [1,2,3,4,5]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= heights.length <= 100
// 1 <= heights[i] <= 100
//
// Related Topics 数组
// 👍 78 👎 0
public class 高度检查器1051 {
    //方法1：将数组拷贝一份排序，遍历原数组，对比和排序后数组对应位置的元素是否相等
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        System.arraycopy(heights,0,copy,0,heights.length);
        Arrays.sort(copy);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != copy[i]) count++;
        }
        return count;
    }

    //方法2：方法1时间复杂度高
    /*
    首先我们其实并不关心排序后得到的结果，我们想知道的只是在该位置上，
    与最小的值是否一致 题目中已经明确了值的范围 1 <= heights[i] <= 100
    这是一个在固定范围内的输入，比如输入： [1,1,4,2,1,3]
    输入中有 3 个 1,1 个 2，1 个 3 和 1 个 4，3 个 1 肯定会在前面，依次类推
    所以，我们需要的仅仅只是计数而已
     */
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

}
