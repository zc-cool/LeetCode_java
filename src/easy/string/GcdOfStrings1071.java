/**
 * @author zhucheng
 * @create 2021-04-01-17:16
 */
package easy.string;
//对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
//
//
//
// 示例 1：
//
//
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
//
//
// 示例 2：
//
//
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
//
//
// 示例 3：
//
//
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
//
//
//
//
// 提示：
//
//
// 1 <= str1.length <= 1000
// 1 <= str2.length <= 1000
// str1[i] 和 str2[i] 为大写英文字母
//
// Related Topics 字符串
// 👍 191 👎 0
public class GcdOfStrings1071 {
    /*
    思路：
        1.找到两个字符串的最小的长度len
        2.长度从len开始递减，进行判断
        3.根据题意，两个字符串的长度除以len必须能整除，才能保证经过有限次合成两个字符串
        4.在满足3的条件下，然后分别计算两个字符串长度是len多少倍，即经过几次合成
        5.在4中经过该倍数次合成，和两个字符串分别比较，都满足即是最长。否则都不满足，len-1
        6.len长度小于0时，说明没有找到，返回""
     */
    public String gcdOfStrings(String str1, String str2) {
        int len = Math.min(str1.length(),str2.length());
        for (int i = len-1; i >=0 ; i--) {
            int num1 = str1.length() % (i+1);  //计算余数
            int num2 = str1.length() % (i+1);
            if(num1 == 0 && num2 == 0){
                int count1 = str1.length() / (i+1);  //计算除数
                int count2 = str2.length() / (i+1);
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                String sub = "";

                if(i == len-1){
                    sub = str1.length() > str2.length() ? str2 : str1;
                }else{
                    sub = str1.substring(0,i+1);
                }

                for(int j=0; j<count1; j++) sb1.append(sub);
                for(int k=0; k<count2; k++) sb2.append(sub);
                if(sb1.toString().equals(str1) && sb2.toString().equals(str2)) return sub;
            }
        }
        return "";
    }
}
