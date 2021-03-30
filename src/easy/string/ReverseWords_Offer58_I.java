/**
 * @author zhucheng
 * @create 2021-03-30-23:35
 */
package easy.string;

import java.util.Stack;

//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。
//
//
//
// 示例 1：
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
//
//
// 示例 2：
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
//
//
// 注意：此题对比原题有改动
// Related Topics 字符串
// 👍 81 👎 0
public class ReverseWords_Offer58_I {
    public String reverseWords(String s) {
        //1.边界条件
        if(s.equals("")) return "";

        //2.进行空格切割
        String[] str = s.split(" ");
        //2.1边界条件，如果s为全是空格的字符串 例如："      "
        if(str.length == 0) return "";
        //2.2将切割后的字符串装进栈中
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if(!str[i].equals("")){
                stack.push(str[i]);
                stack.push(" ");
            }
        }
        //2.3最后栈顶多出一个空格，弹出
        stack.pop();
        //3依次弹栈，使用StringBuilder拼接。输出
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
