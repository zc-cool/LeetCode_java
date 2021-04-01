/**
 * @author zhucheng
 * @create 2021-03-25-10:07
 */
package easy.array;

import java.util.*;

public class Test{
    public static void main(String[] args){
        String s = "bcdea";

        int i = maxLengthBetweenEqualCharacters2(s);
        System.out.println(i);
    }

    public static int maxLengthBetweenEqualCharacters2(String s) {
        int ans = -1;  //起始值为-1
        /*
        核心思路：
            在字符串中找到a到z的indexOf，和lastIndexOf。计算两者之差。比较出最大值
            如果indexOf和lastIndexOf不存在，返回一个负数。？？？？
         */
        int[] ch = new int[26];
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, s.lastIndexOf(i + 'a') - s.indexOf(i + 'a') - 1);
        }
        return ans;
    }

}
