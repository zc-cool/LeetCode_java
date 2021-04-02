/**
 * @author zhucheng
 * @create 2021-04-01-16:11
 */
package easy.string;
//给你一个字符串 s ，请你根据下面的算法重新构造字符串：
//
//
// 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
// 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
// 重复步骤 2 ，直到你没法从 s 中选择字符。
// 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
// 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
// 重复步骤 5 ，直到你没法从 s 中选择字符。
// 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
//
//
// 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
//
// 请你返回将 s 中字符重新排序后的 结果字符串 。
//
//
//
// 示例 1：
//
// 输入：s = "aaaabbbbcccc"
//输出："abccbaabccba"
//解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
//第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
//第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
//第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
//第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
//
//
// 示例 2：
//
// 输入：s = "rat"
//输出："art"
//解释：单词 "rat" 在上述算法重排序以后变成 "art"
//
//
// 示例 3：
//
// 输入：s = "leetcode"
//输出："cdelotee"
//
//
// 示例 4：
//
// 输入：s = "ggggggg"
//输出："ggggggg"
//
//
// 示例 5：
//
// 输入：s = "spo"
//输出："ops"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母。
//
// Related Topics 排序 字符串
// 👍 89 👎 0
public class NSortString1370 {
    /*
    思路：
        1.将字符串中的字符映射到数组中a-z对应0-25
        2.遍历字符串，重复的字符串则在对应的数组中加1，记录次数
        3.找出数组中次数最大的值，它决定了需要遍历数组的次数
        4.当次数最大值大于0时，循环
        5.循环开始数组从前向后遍历，遇到数组下标不为0的元素，再映射回字符。添加到StringBuilder中
            5.1因为不为0说明该字符存在，
            5.2添加完，将该字符再数组中的计数减1
        6.5结束后，将最大值减1，并判断最大值不为0，说明可以从后向前遍历。从后向前遍历，操作同5
        7.循环结束，说明添加完毕，返回
     */
    public String sortString(String s) {
        //将字符串中的字符映射到数组中
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            array[index]++;
        }
        //找到数组中字符出现次数最大的值
        int max = 0;
        for(int j : array){
            max = Math.max(max,j);
        }
        //当最大值大于0时循环
        StringBuilder sb = new StringBuilder();
        while(max > 0){
            //从前向后遍历，依次添加字符
            for(int k=0; k<array.length; k++){
                if(array[k] != 0){
                    char c = (char)(k + 'a');
                    sb.append(c);
                    array[k]--;
                }
            }
            //从前向后添加完毕，最大值减1
            max--;
            //最大值不为0时，从后向前遍历，依次添加字符
            if(max != 0){
                for(int n=array.length-1; n>=0; n--){
                    if(array[n] != 0){
                        char ch = (char)(n + 'a');
                        sb.append(ch);
                        array[n]--;
                    }
                }
                //从后向前添加完毕，最大值减1
                max--;
            }
        }
        return sb.toString();
    }
}
