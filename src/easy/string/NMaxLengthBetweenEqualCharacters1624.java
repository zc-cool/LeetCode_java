/**
 * @author zhucheng
 * @create 2021-03-31-13:59
 */
package easy.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
//
// 子字符串 是字符串中的一个连续字符序列。
//
//
//
// 示例 1：
//
// 输入：s = "aa"
//输出：0
//解释：最优的子字符串是两个 'a' 之间的空子字符串。
//
// 示例 2：
//
// 输入：s = "abca"
//输出：2
//解释：最优的子字符串是 "bc" 。
//
//
// 示例 3：
//
// 输入：s = "cbzxy"
//输出：-1
//解释：s 中不存在出现出现两次的字符，所以返回 -1 。
//
//
// 示例 4：
//
// 输入：s = "cabbac"
//输出：4
//解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
//
//
// 提示：
// 1 <= s.length <= 300
// s 只含小写英文字母
//
// Related Topics 字符串
// 👍 8 👎 0
public class NMaxLengthBetweenEqualCharacters1624 {
    //方法一：双层循环暴力求解
    public int maxLengthBetweenEqualCharacters(String s) {
        Set<Integer> set = new HashSet<>();
        set.add(-1);  //起始集合中只有-1
        //外层循环从字符串起始点开始
        for (int i = 0; i < s.length(); i++) {
            //内存循环从字符串末尾开始，到前面指针出结束
            for(int j = s.length()-1; j > i; j--){
                //如果存在两个字符相同，计算距离，存在在集合中，break。
                if(s.charAt(i) == s.charAt(j)){
                    int len = j-i-1;
                    set.add(len);
                    break;
                }
            }
        }
        int max = Collections.max(set);  //计算集合中最大值并返回
        return max;
    }

    //方法二：别人写的
    public int maxLengthBetweenEqualCharacters2(String s) {
        int ans = -1;  //起始值为-1
        /*
        核心思路：
            在字符串中找到a到z的indexOf，和lastIndexOf。计算两者之差。比较出最大值
            如果indexOf和lastIndexOf不存在，返回一个负数。之差为0
            如果只有一个元素，则indexOf和lastIndexOf返回值是一样的，结果还是0.
         */
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, s.lastIndexOf(i + 'a') - s.indexOf(i + 'a') - 1);
        }
        return ans;
    }
}
