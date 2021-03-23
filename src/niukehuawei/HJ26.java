/**
 * @author zhucheng
 * @create 2021-03-22-14:29
 */
package niukehuawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
题目描述
编写一个程序，将输入字符串中的字符按如下规则排序。

规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
如，输入： Type 输出： epTy

规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
如，输入： BabA 输出： aABb

规则 3 ：非英文字母的其它字符保持原来的位置。
如，输入： By?e 输出： Be?y

注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）

输入描述:
    输入字符串
输出描述:
    输出字符串
示例1
输入
A Famous Saying: Much Ado About Nothing (2012/8).

输出
A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class HJ26 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            //1.使用list集合，将字符串中a-z，A-Z之间的字符按照排序顺序添加到list集合中。
            List<Character> list = new ArrayList<>();
            for(int i = 'A'; i <= 'Z'; i++){              //使用双层循环，外层循环负责添加从A到Z
                for(int j = 0; j < str.length(); j++){    //内层循环遍历字符串。
                    //当字符串中字符是小写a-z或者大写A-Z等价。小写-大写=32
                    if(str.charAt(j) == i || str.charAt(j) == i+32){
                        list.add(str.charAt(j));
                    }
                }
            }
            //2.遍历字符串，找到字符不是a-z,A-Z之间的字符。并将该字符插入到list集合对应位置。
            for(int k = 0; k < str.length(); k++){
                char c = str.charAt(k);
                if(!(c>='a' && c<='z' || c>='A' && c<='Z')){
                    list.add(k,c);
                }
            }
            //3.遍历list集合，使用StringBuilder添加。输出字符串。
            StringBuilder sb = new StringBuilder(str.length());
            for(Character e : list){
                sb.append(e);
            }
            System.out.println(sb.toString());
        }
    }
}
