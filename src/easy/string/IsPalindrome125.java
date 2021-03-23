/**
 * @author zhucheng
 * @create 2021-03-17-14:13
 */
package easy.string;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 348 👎 0
public class IsPalindrome125 {
    /*
    解题：
        题意：判断字符串是否是回文串，包括数字和字母，不包括其它符号。而且字母不区分大小写。
        思路：首先将字符串全转成小写或者大写。
              利用双指针，pre指向字符串首字符，last指向字符串末字符。
              while(pre<last)
              判断pre和last指针所指向的字符是否符合题目要求（数组和字母），如果不符合，pre指针前移，last指针后移。
              判断pre和last指针所指向的是否相等，如果不相等，说明不是回文串，直接返回false。
              如果相等，pre前移，last后移，并再次判断所指是否符合题意要求。
              循环结束，说明是回文串，返回true。
     */
    public static boolean isPalindrome(String s) {
        if(s == null) return false;

        String ss = s.toLowerCase();  //字符串转为小写
        int pre = 0;                  //前指针
        int last = ss.length()-1;     //后指针
        while(pre < last){
            char c1 = ss.charAt(pre);
            char c2 = ss.charAt(last);
            if(!(c1 >= 'a' && c1 <= 'z' || c1 >= '0' && c1 <= '9')){  //判断pre所指是否符合要求
                pre++;
                continue;
            }
            if(!(c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9')){  //判断last所指是否符合要求
                last--;
                continue;
            }
            if(c1 != c2){          //如果pre和last所指不相等，说明不是回文串，返回false
                return false;
            }
            pre++;
            last--;
        }
        return true;    //程序执行到这，说明循环结束，说明是回文串
    }
}
