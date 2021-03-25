/**
 * @author zhucheng
 * @create 2021-03-25-14:57
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 你可以假设两个字符串均只含有小写字母。
//
// Related Topics 字符串
// 👍 136 👎 0
public class CanConstruct383 {
    //方法一，使用ArrayList的contains(),indexOf(),remove()方法
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        List<Character> list = new ArrayList<>();
        for(int j = 0; j < magazine.length(); j++){
            list.add(magazine.charAt(j));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(!list.contains(c)){
                return false;
            }else{
                list.remove(list.indexOf(c));
            }
        }
        return true;
    }
    //方法二，使用StringBuilder的indexOf()方法
    public boolean canConstruct2(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            //StringBuilder的indexOf()方法，参数是字符串
            //如果存在，返回值>=0,不存在，返回值小于0
            int index = sb.indexOf(String.valueOf(c));
            if(index >= 0){
                sb.deleteCharAt(index);
            }else{
                return false;
            }
        }
        return true;
    }
}
