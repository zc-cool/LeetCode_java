/**
 * @author zhucheng
 * @create 2021-03-19-14:48
 */
package easy.string;
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 👍 333 👎 0
public class NAddString415 {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += num1.charAt(i) - '0';  //'0' 对应整数是96.需要减去才行
                i--;
            }
            if(j>=0){
                sum += num2.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
