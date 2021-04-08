/**
 * @author zhucheng
 * @create 2021-04-02-13:07
 */
package easy.string;
//给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文子字符串
//
// 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
//
// 「子字符串」定义：如果一个字符串在原字符串中是连续的，那么这个字符串就是原字符串的一个子字符串。
//
// 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
//
//
//
// 示例 1：
//
// 输入：s = "ababa"
//输出：1
//解释：字符串本身就是回文序列，只需要删除一次。
//
//
// 示例 2：
//
// 输入：s = "abb"
//输出：2
//解释："abb" -> "bb" -> "".
//先删除回文子序列 "a"，然后再删除 "bb"。
//
//
// 示例 3：
//
// 输入：s = "baabb"
//输出：2
//解释："baabb" -> "b" -> "".
//先删除回文子序列 "baab"，然后再删除 "b"。
//
//
// 示例 4：
//
// 输入：s = ""
//输出：0
//
// 提示：
// 0 <= s.length <= 1000
// s 仅包含字母 'a' 和 'b'
//
// Related Topics 字符串
// 👍 58 👎 0
public class NRemovePalindromeSub_1332 {
    public int removePalindromeSub(String s) {
        //1.如果s是空串，返回0
        if(s == "") return 0;
        //2.count记录删除的次数
        int count = 0;
        //3.遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //last每次都指向字符串末尾，
            int last = s.length()-1;
            while (last >= i){     //在i-last之间找回文子字符串，last指针向前移动，i不动
                if(!isPalindrome(s,i,last)){  //如果s在i-last之间的字符串不是回文串，则last指针前移一位
                    last--;
                }else{       //如果找到i-last之间的子字符串是回文串，则count+1，并结束此次while循环。
                    count++; //i指针后移，
                    break;
                }
            }
            if(last == s.length()-1){   //判断i指针需要后移到什么位置
                break;          //如果last在s字符串末尾，说明i-last是回文串，已经结束了。此时for循环也应该结束，break
            }else if(i != last){ //如果last不是在s字符串末尾，并且i ！= last。说明i-last之间有1到多个字符，
                i = last;    //此时i指针移到last位置，进入下一次循环，下次循环从last+1位置开始，last指针又从s字符串末尾开始找回文子串
            }
            //否则i == last 说明回文串是i指针所指的一个字符。此时i指针后移一位，进入下一次循环
            //下次循环从i+1位置开始，last指针又从s字符串末尾开始找回文子串
        }
        return count;
    }

    //isPalindrome方法判断字符串在pre和last之间是不是回文串
    public boolean isPalindrome(String s, int pre, int last){
        while(pre < last){
            if(s.charAt(pre) == s.charAt(last)){
                pre++;
                last--;
            }else {
                return false;
            }
        }
        return true;
    }
}
