/**
 * @author zhucheng
 * @create 2021-03-25-15:50
 */
package easy.string;

import java.util.LinkedHashMap;
import java.util.Map;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 364 👎 0
public class NFirstUniqChar387 {
    //方法一：使用LinkedHashMap用于计数
    public int firstUniqChar(String s) {
        //1.边界
        if(s == null || s.equals("")) return -1;
        //2.用LinkedHashMap计数字符出现的次数
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c) + 1;
                map.put(c,value);
            }else{
                map.put(c,1);
            }
        }
        //3.遍历map集合，如果出现value的值为1，说明该字符是首先出现一次的
        //返回该字符在字符串中的下标
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                char c = entry.getKey();
                return s.indexOf(c);
            }
        }
        return -1;

        /*
        3.可以直接再次遍历字符串,只要该字符串的字符在map集合中的value是1，
        直接返回该字符的下标即可
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
         */
    }

    //2.使用数组来计数
    public int firstUniqChar2(String s){
        //1.边界
        if(s==null || s.equals("")) return -1;
        //2.使用数组计数
        int[] bucket = new int[26];
        //将s字符串中的每个字符映射到bucket数组中
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }

        for(int j=0; j<bucket.length; j++){
            if(bucket[s.charAt(j) - 'a'] == 1){
                return j;
            }
        }
        return -1;
    }
}
