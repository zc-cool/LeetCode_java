/**
 * @author zhucheng
 * @create 2021-04-15-15:36
 */
package easy.array;
//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。
//
//
//
// 示例 1：
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释：
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
//
//
// 示例 2：
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length, chars.length <= 100
// 所有字符串中都仅包含小写英文字母
//
// Related Topics 数组 哈希表
// 👍 129 👎 0
public class 拼写单词1160 {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;  //记录符合要求的字符长度
        for (int j = 0; j < words.length; j++) {  // 遍历字符数组
            int[] bucket = bucket(chars); //和bucket进行对比
            String str = words[j];
            boolean flag = true;
            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                if(bucket[c-'a'] == 0){  //如果字符中的字符在bucket中没有出现，不符合
                    flag = false;
                    break;
                }else{                   //否则，将桶中字符出现次数-1
                    bucket[c-'a']--;
                }
            }
            if(flag){
                int len = str.length();
                sum += len;
            }
        }
        return sum;
    }

    //将chars字符串中的字符出现的次数映射到bucket中
    public int[] bucket(String chars){
        int[] bucket = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char tem = chars.charAt(i);
            bucket[tem-'a']++;
        }
        return bucket;
    }
}
