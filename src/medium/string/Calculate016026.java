/**
 * @author zhucheng
 * @create 2021-03-22-21:15
 */
package medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:
输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
 */
public class Calculate016026 {
    /*
    思路：
    1.首先需要去除字符串中的空格。遍历字符串，使用list集合存储数字和加减乘除。
      注意：需要判断数字的结束位置，进行截取。因为数字长度不是唯一，数字存储只能存储一个整体，但是加减乘除是字符。所以
      list泛型为String。
    2.存储list结束，观察list集合与之前的区别是，集合中都是数字字符串和加减乘除字符串。因为乘除优先级最高且相等。
      可以利用栈stack来进行乘除计算。遍历list集合，遇到数字和加减符号进栈。遇到乘除符号，弹栈一个元素，与list集合下一个数字进行乘除运算
      后进栈。
    3.观察stack栈。栈中元素只有数字和加减符号。但是出栈顺序和计算顺序是反着的。需要第二个栈stack1将stack栈中元素存储。
    4.观察stack1栈。此时栈中出栈顺序和计算顺序一致。遇到数字弹栈，遇到字符进行加减
     */
    public int calculate(String s) {
        //1.去除空格，截取数字和运算符号，存储在list集合。
        List<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ') continue;   //遍历字符串，遇到空格跳过不存储
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                //遇到加减乘除字符，直接添加存储
                list.add(String.valueOf(s.charAt(i)));
            }else{
                int start = i;  //遇到数字，记录下数字开始下标
                //找到数字结束位置，注意，判断i是否越界，i<s.length()需要放在最前面，当i不成立的时候循环结束，不然s.charAt(i)会越界
                while(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    i++;
                }
                int end = i;
                String num = s.substring(start,end);  //截取数字字符串
                list.add(num);
                i--;  //注意，这个地方，需要i--。在进入for循环中，i++才能到达正确下标
            }
        }
        //2.乘除优先级高，优先计算乘除
        Stack<String> stack = new Stack<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("*")){
                int tem = Integer.parseInt(stack.pop()) * Integer.parseInt(list.get(i+1));
                stack.push(String.valueOf(tem));
                i++;
            }else if(list.get(i).equals("/")){
                int tem = Integer.parseInt(stack.pop()) / Integer.parseInt(list.get(i+1));
                stack.push(String.valueOf(tem));
                i++;
            }else{
                stack.push(list.get(i));
            }
        }
        //3.栈中只剩下加减符号和数,但是栈的数据是反着的，再次进栈
        Stack<String> stack1 = new Stack<>();
        while(!(stack.empty())){
            stack1.push(stack.pop());
        }
        //4.弹栈计算最终结果
        int sum=0;
        while(!(stack1.empty())){
            String ss = stack1.pop();
            if(ss.equals("+")){
                sum = sum + Integer.parseInt(stack1.pop());
            }else if(ss.equals("-")){
                sum = sum - Integer.parseInt(stack1.pop());
            }else{
                sum = sum + Integer.parseInt(ss);
            }
        }
        return sum;

    }
}
