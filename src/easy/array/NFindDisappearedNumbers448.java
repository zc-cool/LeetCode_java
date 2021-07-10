/**
 * @author zhucheng
 * @create 2021-04-13-11:11
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;

//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
//
// 示例:
//
//
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
//
// Related Topics 数组
// 👍 706 👎 0
public class NFindDisappearedNumbers448 {
    //使用哈希表，时间复杂度O(n),但是空间复杂度为O(n).
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[nums.length+1];
        for(int num : nums){
            ans[num]++;
        }

        for (int i = 1; i < ans.length; i++) {
            if(ans[i] == 0) list.add(i);
        }
        return list;
    }

    /*
    原地修改
    思路及解法
    我们可以用一个哈希表记录数组nums中的数字，由于数字范围均在[1,n]中，
    记录数字后我们再利用哈希表检查[1,n]中的每一个数是否出现，从而找到缺失的数字。
    由于数字范围均在[1,n]中，我们也可以用一个长度为n的数组来代替哈希表。这一做法的空间复杂度是 O(n)的。
    我们的目标是优化空间复杂度到 O(1)。
    注意到nums的长度恰好也为n，能否让nums充当哈希表呢？
    由于nums的数字范围均在[1,n] 中，我们可以利用这一范围之外的数字，来表达「是否存在」的含义。
    具体来说，遍历nums，每遇到一个数x，就让nums[x−1]增加n。由于nums中所有数均在 [1,n]中，增加以后，
    这些数必然大于n。最后我们遍历nums，若nums[i]未大于n，就说明没有遇到过数i+1。这样我们就找到了缺失的数字。
    注意，当我们遍历到某个位置时，其中的数可能已经被增加过，因此需要对n 取模来还原出它本来的值。
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;  //对n取模还原它本来的值。不能使用-n。因为该位可能还并未加上n
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
