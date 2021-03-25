/**
 * @author zhucheng
 * @create 2021-03-23-19:47
 */
package niukehuawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
题目描述
定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
注意：字典中可能有重复单词。本题含有多组输入数据。

输入描述:
先输入单词的个数n，再输入n个单词。
再输入一个单词，为待查找的单词x
最后输入数字k

输出描述:
输出查找到x的兄弟单词的个数m
然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。

示例1
输入

3 abc bca cab abc 1
输出

2
bca
 */
public class HJ27 {
    /*
    如何判断两个字符串是不是一样（指的是元素种类和个数一样，但是不能相等）？
    答：使用集合，将一个字符串分成字符装起来，遍历另一个字符串，
    如果集合中存在该字符，则删除下标最先出现的那个字符。
    遍历结束，如果集合为空，说明两个字符串一样（因为所有元素都被删除完了）。
    否则，则不一样。
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();  //list集合用于存储输入的n个单词
        int num = scanner.nextInt();
        while(scanner.hasNext()){
            for(int i=0; i<num; i++){
                String str = scanner.next();
                //1.添加n个单词
                list.add(str);
            }
            //scanner.close(); 代表关闭scanner扫描器  慎用
            String s = scanner.next();      //s是需要寻找的兄弟单词
            int index = scanner.nextInt();  //index是字典序列第index大的那个单词

            List<String> list1 = new ArrayList<>();  //list1集合用于存储n个单词中的兄弟单词
            //2.下面代码用来添加n个单词中，是s兄弟单词的操作
            for(int i=0; i<list.size(); i++){
                String tem = list.get(i);
                //如果n中单词和s一样或者n中单词长度和s不一样，则不是兄弟单词，跳过
                if(s.equals(tem) || s.length() != tem.length()) continue;
                //2.1.temList用于存储n中剩下单词字符串的每一个字符
                List<Character> temList = new ArrayList<>();
                for(int j=0; j<tem.length(); j++){
                    temList.add((Character)tem.charAt(j));
                }
                //2.2.遍历s单词每一个字符，如果temList集合中有，则删除最先出现的下标。否则，不是兄弟单词，跳过。
                for(int k=0; k<s.length(); k++){
                    if(!temList.contains((Character)s.charAt(k))){
                        break;
                    }else{
                        temList.remove(temList.indexOf((Character)s.charAt(k)));
                    }
                }
                //2.3.temList集合如果空了，说明该单词和s拥有相同的字符，只是顺序不一致，是兄弟单词。添加
                if(temList.isEmpty()){
                    list1.add(tem);
                }
            }
            //3.将存有兄弟单词的list1集合排序，按照字典顺序
            Collections.sort(list1);
            System.out.println(list1.size());
            //4.如果list1集合元素个数大于等于所要输出的个数，则输出。否则，不输出。
            if(list1.size() >= index){
                System.out.println(list1.get(index-1));
            }
        }
    }
}
