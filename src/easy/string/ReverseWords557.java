/**
 * @author zhucheng
 * @create 2021-04-01-13:51
 */
package easy.string;
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 字符串
// 👍 281 👎 0
public class ReverseWords557 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String ele = str[i];
            String revEle = new StringBuilder().append(ele).reverse().toString();
            sb.append(revEle).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
