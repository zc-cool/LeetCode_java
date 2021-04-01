/**
 * @author zhucheng
 * @create 2021-04-01-9:58
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;

//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//
// 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//
// 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
//
//
//
// 示例 1：
//
// 输入：s = "a0b1c2"
//输出："0a1b2c"
//解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
//
//
// 示例 2：
//
// 输入：s = "leetcode"
//输出：""
//解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
//
//
// 示例 3：
//
// 输入：s = "1229857369"
//输出：""
//解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
//
//
// 示例 4：
//
// 输入：s = "covid2019"
//输出："c2o0v1i9d"
//
//
// 示例 5：
//
// 输入：s = "ab123"
//输出："1a2b3"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 仅由小写英文字母和/或数字组成。
//
// Related Topics 字符串
// 👍 13 👎 0
public class Reformat1417 {
    public String reformat(String s) {
        if(s.length() == 1) return s;

        List<Character> letterList = new ArrayList<>();
        List<Character> digitList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) digitList.add(c);
            if(Character.isLetter(c)) letterList.add(c);
        }

        int letterLen = letterList.size();
        int digitLen = digitList.size();
        int flag = letterLen > digitLen ? letterLen-digitLen : digitLen-letterLen;
        if(flag != 0 && flag != 1) return "";

        int boundLen = letterLen > digitLen ? digitLen : letterLen;
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<boundLen; j++){
            if(letterLen > boundLen){
                sb.append(letterList.get(j));
                sb.append(digitList.get(j));
                if(j == boundLen-1) sb.append(letterList.get(letterLen-1));
            }else if(digitLen > boundLen){
                sb.append(digitList.get(j));
                sb.append(letterList.get(j));
                if(j == boundLen-1) sb.append(digitList.get(digitLen-1));
            }else{
                sb.append(digitList.get(j));
                sb.append(letterList.get(j));
            }
        }
        return sb.toString();
    }
}
