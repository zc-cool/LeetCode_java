/**
 * @author zhucheng
 * @create 2021-03-04-18:18
 */
package easy.stack;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
// 示例 1：
//
//输入：s = "()"
//输出：true
//
// 示例 2：
//
//输入：s = "()[]{}"
//输出：true
//
// 示例 3：
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
// 提示：
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2203 👎 0
public class ValidParentheses20 {
    public static void main(String[] args) {
        /*
        要判断括号的有效性，左括号必须和右括号相对应。如果是有效括号，并且他们中间还有括号，
        那么他们必须也是有效的，所以最简单的一种方式就是使用栈来解决。
        我们遍历字符串中的所有字符
        1，如果遇到了左括号，就把对应的右括号压栈（比如遇到了字符'('，就把字符')'压栈）。
        2，如果遇到了右括号
           1）查看栈是否为空，如果为空，说明不能构成有效的括号，直接返回false。
           2）如果栈不为空，栈顶元素出栈，然后判断出栈的这个元素是否等于这个右括号，
              如果不等于，说明不匹配，直接返回false。如果匹配，就继续判断字符串的下一个字符。
        3，最后如果栈为空，说明是完全匹配，是有效的括号，否则如果栈不为空，说明不完全匹配，不是有效的括号。
         */
    }
    //第一版
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();  //创建一个存储字符的栈
        char[] chars = s.toCharArray();  //将字符串转为字符数组
        for(char c : chars){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(c == ')'){
                if(stack.isEmpty()) return false;
                if(stack.peek() != ')') return false; //stack.peek():方法，获取栈顶元素，不弹栈
                stack.pop();                         //stack.pop():方法，弹出栈顶元素，并返回该值
            }else if(c == '}'){                //注意：此处不能使用pop()方法，因为这样就弹栈了
                if(stack.isEmpty()) return false;
                if(stack.peek() != '}') return false;
                stack.pop();
            }else{
                if(stack.isEmpty()) return false;
                if(stack.peek() != ']') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    //改进版
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();  //创建一个存储字符的栈
        char[] chars = s.toCharArray();  //将字符串转为字符数组

        for(char c : chars){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){  //改进：因为除了'(','{','['左括号，剩下只能是右括号
                return false;                   //即c就是右括号')','}',']'。
            }                                   //此时，栈空，或者弹栈的第一个元素不等于c，说明匹配失败
        }                                       //注意区别：peek()和pop()方法。pop()已经弹栈，栈中元素减1
        return stack.isEmpty(); //程序执行到这，说明需要判断的字符串已经遍历完了，此时
    }                           //如果栈空，说明匹配成功，如果栈不为空，说明没有完全匹配完，即匹配失败
}
