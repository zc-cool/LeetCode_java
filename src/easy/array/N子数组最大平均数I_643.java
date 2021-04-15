/**
 * @author zhucheng
 * @create 2021-04-13-16:19
 */
package easy.array;
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//
//
// 示例：
//
//
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。
//
// Related Topics 数组
// 👍 179 👎 0
public class N子数组最大平均数I_643 {
    /*
    思路：滑动窗口
    以下代码，可以作为滑动窗口模板使用：
        1.初始化将滑动窗口压满，取得第一个滑动窗口的目标值
        2.继续滑动窗口，每往前滑动一次，需要删除一个和添加一个元素
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max,sum);
        }
        return max / k;
    }
}
