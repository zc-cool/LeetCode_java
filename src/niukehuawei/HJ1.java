/**
 * @author zhucheng
 * @create 2021-03-17-16:24
 */
package niukehuawei;
//字符串最后一个单词长度
/*
题目描述
        计算字符串最后一个单词的长度，单词以空格隔开。

        输入描述:
        输入一行，代表要计算的字符串，非空，长度小于5000。

        输出描述:
        输出一个整数，表示输入字符串最后一个单词的长度。

        示例1
        输入
        hello nowcoder

        输出
        8
难度：较难
 */
public class HJ1 {


    //方法一：直接从后向前遍历，遇到空格返回。
    public static int len(String s){
        for(int i = s.length()-1; i>0; i--){
            if(s.charAt(i) == ' '){
                return s.length() - i - 1;
            }
        }
        return s.length();
    }

    //方法二：将字符串用空格分割，返回数组最后一个元素的长度。
    public static int len2(String s){
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
}
