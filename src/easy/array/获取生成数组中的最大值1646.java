/**
 * @author zhucheng
 * @create 2021-04-16-15:04
 */
package easy.array;

import java.util.Arrays;

//给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
//
//
// nums[0] = 0
// nums[1] = 1
// 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
// 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
//
//
// 返回生成数组 nums 中的 最大 值。
//
//
//
// 示例 1：
//
//
//输入：n = 7
//输出：3
//解释：根据规则：
//  nums[0] = 0
//  nums[1] = 1
//  nums[(1 * 2) = 2] = nums[1] = 1
//  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
//  nums[(2 * 2) = 4] = nums[2] = 1
//  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
//  nums[(3 * 2) = 6] = nums[3] = 2
//  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
//因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：1
//解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
//
//
// 示例 3：
//
//
//输入：n = 3
//输出：2
//解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 数组
// 👍 7 👎 0
public class 获取生成数组中的最大值1646 {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n+1];

        if (n < 2) return n;

        arr[0] = 0;
        arr[1] = 1;
        int i = 1;
        if(n % 2 == 0){
            while(2 * i <= n){
                arr[2*i] = arr[i];
                if(2 * i + 1 < n){
                    arr[2*i+1] = arr[i] + arr[i+1];
                }else{
                    break;
                }
                i++;
            }
        }else{
            while(2 * i + 1 <= n){
                arr[2*i] = arr[i];
                arr[2*i+1] = arr[i] + arr[i+1];
                i++;
            }
        }
        Arrays.sort(arr);
        return arr[n];
    }

    /*
    规律如下：
    如果下标为偶数，那么nums[i] = nums[i / 2]
    如果下标为奇数，那么nums[i] = nums[i / 2] + nums[i / 2 + 1]
     */
    public int getMaximumGenerated2(int n) {
        int[] nums = new int[n + 1];
        if (n < 2) {
            return n;
        }
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
