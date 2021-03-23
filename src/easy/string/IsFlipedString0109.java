/**
 * @author zhucheng
 * @create 2021-03-17-10:15
 */
package easy.string;
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1:
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
//
// 示例2:
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
//
//
//
// 提示：
//
//
// 字符串长度在[0, 100000]范围内。
//
//
// 说明:
//
//
// 你能只调用一次检查子串的方法吗？
//
// Related Topics 字符串
// 👍 62 👎 0
public class IsFlipedString0109 {
    //方法1：自己写的方法。利用字符串截取子串的方式进行判断s1和s2是不是经过旋转得到
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int len = s1.length();
        if(len == 0) return true;
        if(len == 1) return s1.equals(s2);  //字符串长度为1要进行单独处理

        //因为substring方法截取子串后一位取不到，所以i从1开始。因此字符串长度为1要进行单独处理
        for (int i = 1; i < len; i++) {
            if(s1.substring(0,i).equals(s2.substring(len-i))
                    && s1.substring(i).equals(s2.substring(0,len-i))){
                return true;
            }
        }
        return false;
    }

    //方法二：s2与s2拼接，如果s1是s2经过旋转后得到的，那么拼接后的字符串一定包含s1
    public boolean isFlipedString2(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        String s = s2 + s2;
        if(s.contains(s1)){
            return true;
        }
        return false;
    }
}
