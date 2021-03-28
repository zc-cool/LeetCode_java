/**
 * @author zhucheng
 * @create 2021-03-27-0:19
 */
package easy.string;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
// 混合字符串 由小写英文字母和数字组成。
//
//
//
// 示例 1：
//
//
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
//
//
// 示例 2：
//
//
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母和（或）数字。
//
// Related Topics 字符串
// 👍 2 👎 0
public class SecondHighest1796 {
    public int secondHighest(String s) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                set.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        if(set.size() < 2) return -1;
        int[] array = new int[set.size()];
        int index = 0;
        for(Integer i : set){
            array[index] = i;
            index++;
        }

        Arrays.sort(array);
        return array[array.length-2];
    }
}
