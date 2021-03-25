/**
 * @author zhucheng
 * @create 2021-03-25-14:23
 */
package easy.string;

import java.util.HashSet;
import java.util.Set;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 148 👎 0
public class NReverseVowels345 {
    public String reverseVowels(String s) {
        //用集合存储所有元音字母
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('o');
        set.add('O');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('u');
        set.add('U');
        //边界条件
        if(s == null) return null;

        char[] chars = s.toCharArray();
        //双指针
        int start = 0;
        int end = chars.length-1;

        while(start < end){
            char c1 = chars[start];
            char c2 = chars[end];

            if(!set.contains(c1)){
                start++;
                continue;
            }
            if(!set.contains(c2)){
                end--;
                continue;
            }
            chars[end] = c1;
            chars[start] = c2;
            start++;
            end--;
        }
        return new String(chars);
    }
}
