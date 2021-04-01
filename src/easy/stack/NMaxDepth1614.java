/**
 * @author zhucheng
 * @create 2021-03-31-14:37
 */
package easy.stack;

import java.util.Stack;

//如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
//
//
// 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
// 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
// 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
//
//
// 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
//
//
// depth("") = 0
// depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
// depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
// depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
//
//
// 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
//
//
// 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
//
//
//
// 示例 1：
//
//
//输入：s = "(1+(2*3)+((8)/4))+1"
//输出：3
//解释：数字 8 在嵌套的 3 层括号中。
//
//
// 示例 2：
//
//
//输入：s = "(1)+((2))+(((3)))"
//输出：3
//
//
// 示例 3：
//
//
//输入：s = "1+(2*3)/(2-1)"
//输出：1
//
//
// 示例 4：
//
//
//输入：s = "1"
//输出：0
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
// 题目数据保证括号表达式 s 是 有效的括号表达式
//
// Related Topics 字符串
// 👍 18 👎 0
public class NMaxDepth1614 {
    /*
    思路：
        使用栈。记录栈内最大深度，就是所要求得最大深度
        遍历有效括号表达式字符串
        遇到(进栈，栈深度加1，并与栈内深度最大值比较，更新栈内深度最大值
        遇到)出栈，栈深度减1，并不需要与栈内深度最大值比较，因为出栈深度减少。肯定比栈内深度最大值低
        遍历结束，返回栈内深度最大值
     */
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int deep = 0;  //记录栈内实时深度
        int maxDeep = deep;  //记录栈内最大深度
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遇到'('进栈，栈实时深度加1，并更新栈内最大深度
            if(c == '('){
                stack.push(c);
                deep++;
                maxDeep = deep > maxDeep ? deep : maxDeep;
            //遇到')'出栈，栈实时深度减1
            }else if(c == ')'){
                stack.pop();
                deep--;
            }
        }
        return maxDeep;
    }
}
