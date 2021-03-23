/**
 * @author zhucheng
 * @create 2021-03-22-13:08
 */
package niukehuawei;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
题目描述
实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
注意每个输入文件有多组输入，即多个字符串用回车隔开
输入描述:
字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

输出描述:
删除字符串中出现次数最少的字符后的字符串。

示例1
输入
abcdd
aabcddd

输出
dd
aaddd
 */
public class HJ23 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            //1.统计字符串中每个字符出现的次数
            Map<Character,Integer> map = new LinkedHashMap<>();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(map.containsKey(c)){
                    int value = map.get(c) + 1;
                    map.put(c,value);
                }else{
                    map.put(c,1);
                }
            }
            //2.遍历字符串，找到出现次数最小的次数
            Collection<Integer> values = map.values();
            Integer min = 2;
            for(Integer i : values){
                min = i > min ? min : i;
            }
            /*
            上述遍历字符串，找到出现次数最小的次数。可以使用Collections集合方法
            Integer min = Collections.min(values);
            */
            //3.使用StringBuilder添加字符，跳过出现次数最少的字符
            StringBuilder sb = new StringBuilder();
            for(Character e : str.toCharArray()){//注意，此处不能将map转为set集合，因为set集合去重。
                if(map.get(e) != min){
                    sb.append(e);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
