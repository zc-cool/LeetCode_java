/**
 * @author zhucheng
 * @create 2021-03-27-0:53
 */
package easy.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//
//
// 示例 2：
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
//
//
// 示例 3：
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
//
//
// 示例 4：
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 和 s2 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 8 👎 0
public class AreAlmostEqual1790 {
    //方法一：自己写的
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for(char c1 : s1.toCharArray()) list1.add(c1);
        for(char c2 : s2.toCharArray()) list2.add(c2);

        Collections.sort(list1);
        Collections.sort(list2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(Character e1 : list1) sb1.append(e1);
        for(Character e2 : list2) sb2.append(e2);

        if(sb1.toString().equals(sb2.toString())){
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)){
                    count++;
                }
                if(count > 2){
                    return false;
                }
            }
            if(count == 2){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    //方法二：别人写的优化方法
    public boolean areAlmostEqual2(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String s1_diff = "";
        String s2_diff = "";
        for (int i = 0;i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                s1_diff += s1.charAt(i);
                s2_diff = s2.charAt(i) + s2_diff;
                if (s1_diff.length() > 2) {
                    return false;
                }
            }
        }
        return (s1_diff.length() == 2) && (s1_diff.equals(s2_diff));
    }

}
