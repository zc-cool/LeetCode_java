/**
 * @author zhucheng
 * @create 2021-04-09-10:20
 */
package easy.array;

import java.util.HashSet;
import java.util.Set;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 数组
// 👍 99 👎 0
public class IsUnique01_01 {
    //使用Set集合。set的add方法：如果含有重复元素，添加不成功，返回false
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }
}
