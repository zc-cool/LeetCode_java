/**
 * @author zhucheng
 * @create 2021-03-30-16:25
 */
package easy.string;
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串
// 👍 78 👎 0
public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String S) {
        /*
        思路：
            1.遍历字符串，将字符串中所有的字符添加到StringBuilder中
            2.将StringBuilder反转
            3.再次遍历字符串，将字符串中非字符插入到StringBuilder对应位置上
            4.返回StringBuilder.toString()
         */
        if(S == null) return null;
        if(S.equals("")) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)) sb.append(c);
        }

        sb.reverse();
        for(int j=0; j<S.length(); j++){
            char c = S.charAt(j);
            if(!Character.isLetter(c)) sb.insert(j,c);
        }
        return sb.toString();
    }
}
