/**
 * @author zhucheng
 * @create 2021-03-30-21:31
 */
package easy.string;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串
// 👍 336 👎 0
public class NValidPalindrome680 {
    public boolean validPalindrome(String s) {
        int pre = 0;   //指向字符串起始位置
        int last = s.length()-1; //指向字符串末尾位置
        while(pre < last){
            //1.如果出现字符不相等的情况
            if(s.charAt(pre) != s.charAt(last)){
                //1.1字符出现不相等的位置正好是中间两个元素，说明去掉任何一个元素，都能满足题意，达成回文串
                //例如：abcdecba   d和e不相等，但是去掉任何一个，剩下的字符串都满足能构成回文串
                if(last - pre == 1){
                    return true;
                    //1.2如果刚好在起始点位置出现不相等，即开头和末尾元素不相同。此时
                    //去掉末尾元素得到s1，去掉开头元素得到s2.判断s1和s2这两个字符串，有一个是回文串即可
                }else if(last == s.length()-1){
                    String s1 = s.substring(pre,last);
                    String s2 = s.substring(pre+1);
                    return palindrome(s1) || palindrome(s2);
                    //1.3如果出现位置不是起始点，则直接去掉结尾元素得到s1，去掉开头元素得到s2.和上一步判断一样
                    //1.2中主要是防止去掉开头元素得到s2的时候出现越界
                }else{
                    String s1 = s.substring(pre,last);
                    String s2 = s.substring(pre+1,last+1);  //在1.2中判断last不是字符串末尾，防止出现越界
                    return palindrome(s1) || palindrome(s2);
                }
            }
            //否则，说明两个元素相等，pre指针前移一位，last指针后移一位
            pre++;
            last--;
        }
        //程序执行到这，说明字符串s本身就是回文串。
        return true;
    }

    //函数：判断一个字符串是不是回文串
    public boolean palindrome(String ss){
        int pre = 0;
        int last = ss.length()-1;
        while(pre < last){
            if(ss.charAt(pre) != ss.charAt(last)) return false;
            pre++;
            last--;
        }
        return true;
    }


    //方法二，不用截取字符串，直接在原字符串上进行判断。（起始思路和方法一一样，只是看起来比方法一简单）
    //如果s[i]==s[j]继续i++,j--,判断是否回文
    //如果s[i]!=s[j]
    //1.判断s[i+1]到s[j]范围内字符串是否回文，如果是，去掉s[i]即可
    //2.或者判断s[i]到s[j-1]范围内是否回文，如果是，删除s[j]即可，
    public boolean validPalindrome2(String s) {
        char[] ch=s.toCharArray();
        for(int i=0,j=ch.length-1; i<j; i++,j--){
            if(ch[i]!=ch[j]){
                return isPalindrome(ch,i+1,j)||isPalindrome(ch,i,j-1);
            }
        }
        return true;
    }
    //判断回文
    public boolean isPalindrome(char[] s,int i,int j){
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
