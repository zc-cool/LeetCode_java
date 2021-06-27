/**
 * @author zhucheng
 * @create 2021-04-01-13:40
 */
package easy.string;
//给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
//
//
//
// 示例 1：
//
// 输入：n = 987
//输出："987"
//
//
// 示例 2：
//
// 输入：n = 1234
//输出："1.234"
//
//
// 示例 3：
//
// 输入：n = 123456789
//输出："123.456.789"
//
//
// 示例 4：
//
// 输入：n = 0
//输出："0"
//
//
//
//
// 提示：
//
//
// 0 <= n < 2^31
//
// Related Topics 字符串
// 👍 8 👎 0

import java.util.Stack;

public class NThousandSeparator1556 {
    //方法一：直接看方法二
    public String thousandSeparator(int n) {
        //将数字转为字符串
        String str = String.valueOf(n);
        //长度小于4，直接返回
        if(str.length() < 4) return str;

        //字符串是3的多少倍
        int count = str.length() / 3;
        //使用栈，从后遍历字符串
        Stack<Character> stack = new Stack<>();
        for (int i = str.length()-1; i >= 0; i--) {
            //如果count还大于0，说明还可以连续入栈3个元素
            if(count > 0){
                stack.push(str.charAt(i));
                stack.push(str.charAt(--i));
                stack.push(str.charAt(--i));
                stack.push('.');
                count--;
                //否则，count=0，不能再连续入栈3个元素
            }else
                stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        //判断栈顶元素，如果是.则需要pop出去。因为这是上面代码中字符串正好全是3的倍数，导致在起始位置插入一个.
        if(stack.peek() == '.') stack.pop();
        //遍历栈，将元素弹出
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    //方法二：别人写的，简化。使用StringBuilder，最后反转输入
    public String thousandSeparator2(int n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            cnt++;
            // 如果cnt%3==0，并且i!=0(不是最后一个字符)
            if (cnt % 3 == 0 && i != 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }

    //方法三：使用StringBuilder的insert方法
    public String thousandSeparator3(int n) {
        String str = String.valueOf(n);
        if(str.length() <= 3) return str;

        StringBuilder sb = new StringBuilder(str);//String转为StringBuilder，为了使用insert方法
        int index = sb.length();  //index是字符串的长度，
        while(index > 0){    //当index>0是循环开始，index = index - 3
            index -= 3;      //判断index是否到达字符串首元素，如果到达则不添加'.'
            if(index > 0){
                sb.insert(index,'.');  //否则在index位置插入'.'
            }
        }
        return sb.toString();
    }
}
