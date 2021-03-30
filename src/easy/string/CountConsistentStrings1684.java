/**
 * @author zhucheng
 * @create 2021-03-30-15:08
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;

//给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字
//符串 。
//
// 请你返回 words 数组中 一致字符串 的数目。
//
//
//
// 示例 1：
//
//
//输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//输出：2
//解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
//
//
// 示例 2：
//
//
//输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//输出：7
//解释：所有字符串都是一致的。
//
//
// 示例 3：
//
//
//输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//输出：4
//解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 104
// 1 <= allowed.length <= 26
// 1 <= words[i].length <= 10
// allowed 中的字符 互不相同 。
// words[i] 和 allowed 只包含小写英文字母。
//
// Related Topics 字符串
// 👍 14 👎 0
public class CountConsistentStrings1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        List<Character> list = new ArrayList<>();
        for(int j=0; j<allowed.length(); j++) list.add(allowed.charAt(j));  //将目标字符串装进集合list

        int count = 0;
        for (int i = 0; i < words.length; i++) {  //遍历字符串数组
            String str = words[i];
            for(int k=0; k<str.length(); k++){    //遍历字符串数组中每一个字符串的字符
                if(!list.contains(str.charAt(k))){  //如果集合中不含有该字符，直接pass
                    break;
                }else if(k == str.length()-1){  //否则，如果已经遍历到字符串末尾，说明该字符串的元素都存在集合中。计数+1
                    count++;
                }
            }
        }

        return count;
    }
}
