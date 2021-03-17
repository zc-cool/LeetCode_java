/**
 * @author zhucheng
 * @create 2021-03-16-16:18
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;

//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 数组 字符串
// 👍 29 👎 0
public class CheckPermutation0102 {
    //面试题[01.02]
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        List<Character> list = new ArrayList<>();  //将s1字符串转为list集合
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i));
        }

        for(int j = 0; j< s2.length(); j++){  //遍历s2字符串，判断s2字符串中字符是否在s1的list中
            char c = s2.charAt(j);
            if(list.contains(c)){             //如果在的话，将list中对应的字符删除
                int index = list.indexOf(c);
                list.remove(index);
            }else{                  //如果不存在，则直接返回false
                return false;
            }
        }
        return true;       //程序执行到这，说明全部存在，直接返回true。
    }
}
