/**
 * @author zhucheng
 * @create 2021-03-17-13:35
 */
package easy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
// Related Topics 哈希表 字符串
// 👍 44 👎 0
public class CanPermutePalindrome0104 {

    //方法一：自己写的。利用hashMap
    public boolean canPermutePalindrome(String s) {
        if(s == null) return false;

        Map<Character,Integer> map = new HashMap<>();  //申请一个map集合，key表示字符串中字符，value表示该字符的计数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){       //如果集合中不存在该元素，添加，计数1.
                map.put(s.charAt(i),1);
            }else{
                int count = map.get(c);   //如果集合中存在该元素，将元素(计数+1)%2 保证最后元素个数在0和1之间。
                map.put(c,(count+1)%2);   //遍历value，如果1的个数超出1，说明不可能构成回文串。
            }
        }

        int flag = 1;
        for (Integer value : map.values()) {
            if(value == 1){
                flag--;
                if(flag < 0){
                    return false;
                }
            }
        }
        return true;
    }

    //方法二：利用set集合的add属性：set集合中若不存在该元素，添加成功返回true。
    //set集合中若存在该元素，添加不改变set集合结构，返回false
    public boolean canPermutePalindrome2(String s){
        if(s == null) return false;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {   //遍历字符串
            if(!set.add(s.charAt(i))){    //如果添加失败，说明集合中已存在该元素，否则添加成功
                set.remove(s.charAt(i));  //添加失败，将集合中已经存在的该元素删除。
            }
        }
        return set.size() <= 1;  //如果遍历结束，集合中元素个数<=1，说明是回文串。因为重复成对的字符都被排除了。
    }
}
