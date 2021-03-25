/**
 * @author zhucheng
 * @create 2021-03-25-22:32
 */
package easy.stack;

import java.util.Stack;

//给你一个由大小写英文字母组成的字符串 s 。
//
// 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
//
//
// 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
// 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
//
//
// 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
//
// 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
//
// 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
//
//
//
// 示例 1：
//
//
//输入：s = "leEeetcode"
//输出："leetcode"
//解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
//
//
// 示例 2：
//
//
//输入：s = "abBAcC"
//输出：""
//解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
//
//
// 示例 3：
//
//
//输入：s = "s"
//输出："s"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含小写和大写英文字母
//
// Related Topics 栈 字符串
// 👍 21 👎 0
public class NMakeGood1544 {
    /*
    思路：
    可以利用栈的结构特点来实现。
    遍历字符串，当一个元素需要进栈操作时，判断栈内情况
    1.如果栈空，则直接进栈
    2.如果栈不为空，判断栈顶元素和需要进栈的元素之间关系是否满足题目要求
        如果满足，则将栈顶元素弹栈，遍历到的此元素不操作，继续遍历
        如果不满足，则遍历到的此元素进栈
    3.遍历结束，判断栈内情况，如果栈空，说明字符串中的元素全被消灭，返回空
    4.如果栈不是空，则使用StringBuilder将栈内元素添加，由于栈是先进后出，所以将
      StringBuilder的字符串反转输出
     */
    public String makeGood(String s) {
        //1.申请一个栈，用来存储字符串中的字符
        Stack<Character> stack = new Stack<>();
        //2.遍历字符串，添加到栈中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.empty()){
                stack.push(c);
                continue;
            }
            char peek = stack.peek();
            if(peek == c - 32 || peek == c + 32){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        //3.遍历结束，如果栈空，返回空
        if(stack.empty()) return "";
        //4.如果栈不是空，输出栈内元素，并反转。
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
