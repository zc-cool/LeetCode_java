/**
 * @author zhucheng
 * @create 2021-04-02-14:05
 */
package easy.string;
//给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//
// 字符（'a' - 'i'）分别用（'1' - '9'）表示。
// 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//
//
// 返回映射之后形成的新字符串。
//
// 题目数据保证映射始终唯一。
//
//
//
// 示例 1：
//
// 输入：s = "10#11#12"
//输出："jkab"
//解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// 示例 2：
//
// 输入：s = "1326#"
//输出："acz"
//
//
// 示例 3：
//
// 输入：s = "25#"
//输出："y"
//
//
// 示例 4：
//
// 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
//输出："abcdefghijklmnopqrstuvwxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 只包含数字（'0'-'9'）和 '#' 字符。
// s 是映射始终存在的有效字符串。
//
// Related Topics 字符串
// 👍 39 👎 0
public class NFreqAlphabets1309 {
    /*
    思路：
        遍历字符串，观察题目，可以发现只有遍历到字符是1或者2才有可能映射到j-z。
        1.遍历字符串，记录遍历到的字符c
        2.如果c=='1'或者c=='2'，令j=i+2.判断j的位置。
            2.1如果j < s.length() && s.charAt(j) == '#'，说明i所指的位置应该映射j-z。
               则将i-j之间的字符串获得，映射到j-z。然后i指针移到j位置，下一次循环在i++开始
            2.2如果j < s.length() && s.charAt() != '#'，说明j没有超过s长度，但是肯定也是1-9之间映射a-i
            2.3如果j >= s.length()，说明j超过s长度，肯定是a-i之间映射。同2.2意义。所以条件可以合在一起
        3.如果c不在'1'和'2'之中，则肯定映射在a-i
     */
    public String freqAlphabets(String s) {
        //使用StringBuilder拼接
        StringBuilder sb = new StringBuilder();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //记录当前的字符
            char c = s.charAt(i);
            //如果c=='1'或者c=='2'，进入判断
            if(c == '1' || c == '2'){
                int j = i + 2;
                if(j < s.length() && s.charAt(j) == '#'){  //说明i所指的位置应该映射j-z。
                    String str = s.substring(i,j);
                    int value = Integer.parseInt(str);
                    char tem = (char)(value + 'a' - 1);
                    sb.append(tem);
                    i = j;
                }else{           //j < s.length() && s.charAt() != '#' //j没有超过s长度，但是肯定也是1-9之间映射
                    char tem = (char)(c + 'a' - '1'); //j超出s长度，肯定是1-9之间映射。两个条件合并
                    sb.append(tem);
                }
            } else{  //如果c不在'1'和'2'之中，则肯定映射在a-i
                char tem = (char)(c + 'a' - '1');
                sb.append(tem);
            }
        }
        return sb.toString();
    }
}
