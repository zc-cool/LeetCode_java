/**
 * @author zhucheng
 * @create 2021-04-01-10:59
 */
package easy.string;
//给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//
// 请你返回字符串的能量。
//
//
//
// 示例 1：
//
// 输入：s = "leetcode"
//输出：2
//解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
//
//
// 示例 2：
//
// 输入：s = "abbcccddddeeeeedcba"
//输出：5
//解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
//
//
// 示例 3：
//
// 输入：s = "triplepillooooow"
//输出：5
//
//
// 示例 4：
//
// 输入：s = "hooraaaaaaaaaaay"
//输出：11
//
//
// 示例 5：
//
// 输入：s = "tourist"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母。
//
// Related Topics 字符串
// 👍 15 👎 0
public class NMaxPower1446 {
    public int maxPower(String s) {
        /*
        思路：
            遍历字符串，并将当下元素等于当下元素时进入while循环，指针前移一步，继续判断（优先保证指针<s.length()）
            外层循环count记录每次当下元素连续重复的数量。
         */
        int maxPower = 0;
        for (int i = 0; i < s.length(); ) {
            int count = 0;
            char c = s.charAt(i);
            while(i < s.length() && s.charAt(i) == c){
                i++;
                count++;
            }
            maxPower = Math.max(maxPower,count);
        }
        return maxPower;
    }
}
