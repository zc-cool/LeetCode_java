/**
 * @author zhucheng
 * @create 2021-04-02-15:08
 */
package easy.array;
//给定一个正整数 n ，输出外观数列的第 n 项。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
//
// 你可以将其视作是由递归公式定义的数字字符串序列：
//
//
// countAndSay(1) = "1"
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
//
//
// 前五项如下：
//
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
//
//
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
//
// 例如，数字字符串 "3322251" 的描述如下图：
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
//
//
// 示例 2：
//
//
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
//
//
//
//
// 提示：
//
//
// 1 <= n <= 30
//
// Related Topics 字符串
// 👍 669 👎 0
public class NCountAndSay38 {
    public String countAndSay(int n) {
        String start = "1";  //起始字符串是"1"
        for (int i = 2; i <= n; i++) {   //从2开始，如果n=1，则不满足，直接返回start="1"
            String tem = start;          //满足的话，每一次都进入detail函数进行遍历输出，保存更新到start中
            start = detail(tem);         //下次循环，获得start是更新后的字符串
        }
        return start;   //遍历结束，最终start就是所求
    }

    //detail方法用于遍历字符串s，找到有多少个相同的字符，并以题目要求输出字符串
    public String detail(String s){
        StringBuilder sb = new StringBuilder();  //使用StringBuilder记录
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int count = 0; //记录连续相同字符的个数
            while(i < s.length() && s.charAt(i) == c){  //如果两个字符相同，至少相同一次，因为从当前位置开始比较
                i++;                    //则i指针后移一位
                count++;                //count计数+1
            }
            sb.append(count);           //先添加次数
            sb.append(c);               //再添加相同的字符
        }
        return sb.toString();
    }
}
