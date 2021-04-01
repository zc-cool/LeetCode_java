/**
 * @author zhucheng
 * @create 2021-03-31-13:18
 */
package easy.string;
//给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
//
// 请你按下述方式重新格式化电话号码。
//
//
// 首先，删除 所有的空格和破折号。
// 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
//
// 2 个数字：单个含 2 个数字的块。
// 3 个数字：单个含 3 个数字的块。
// 4 个数字：两个分别含 2 个数字的块。
//
//
//
//
// 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
//
// 返回格式化后的电话号码。
//
//
//
// 示例 1：
//
//
//输入：number = "1-23-45 6"
//输出："123-456"
//解释：数字是 "123456"
//步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
//步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
//连接这些块后得到 "123-456" 。
//
// 示例 2：
//
//
//输入：number = "123 4-567"
//输出："123-45-67"
//解释：数字是 "1234567".
//步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
//步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
//连接这些块后得到 "123-45-67" 。
//
//
// 示例 3：
//
//
//输入：number = "123 4-5678"
//输出："123-456-78"
//解释：数字是 "12345678" 。
//步骤 1：第 1 个块 "123" 。
//步骤 2：第 2 个块 "456" 。
//步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
//连接这些块后得到 "123-456-78" 。
//
// 示例 4：
//
//
//输入：number = "12"
//输出："12"
//
//
// 示例 5：
//
//
//输入：number = "--17-5 229 35-39475 "
//输出："175-229-353-94-75"
//
//
//
//
// 提示：
//
//
// 2 <= number.length <= 100
// number 由数字和字符 '-' 及 ' ' 组成。
// number 中至少含 2 个数字。
//
// Related Topics 字符串
// 👍 6 👎 0
public class ReformatNumber1694 {
    public String reformatNumber(String number) {
        //1.统计number字符串中数字的个数
        int digitCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
                digitCount++;   //优化，可在这个地方 digitCount % 3 == 0;  sb.append('-');
            }
        }
        //2.数量在4以内，直接输出
        if(digitCount < 4) return sb.toString();
        //3.计算除3的余数
        //只要出现余数为1，就应该末尾保留四个
        int count = digitCount % 3;
        int len = sb.length();
        //4.如果余数是0，直接按三个一组进行分割
        if(count == 0){
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb1.append(sb.charAt(i));
                sb1.append(sb.charAt(++i));
                sb1.append(sb.charAt(++i));
                sb1.append('-');
            }
            return sb1.deleteCharAt(sb1.length()-1).toString();
            //5.如果余数是2，则末尾保留两位，前面按照三个一组
        }else if(count == 2){
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < len-2; i++) {
                sb1.append(sb.charAt(i));
                sb1.append(sb.charAt(++i));
                sb1.append(sb.charAt(++i));
                sb1.append('-');
            }
            sb1.append(sb.charAt(len-2));
            sb1.append(sb.charAt(len-1));
            return sb1.toString();
            //6.如果余数是1，则末尾保留4为，前面按照三个一组
        }else{
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < len-4; i++) {
                sb1.append(sb.charAt(i));
                sb1.append(sb.charAt(++i));
                sb1.append(sb.charAt(++i));
                sb1.append('-');
            }
            sb1.append(sb.charAt(len-4));
            sb1.append(sb.charAt(len-3));
            sb1.append('-');
            sb1.append(sb.charAt(len-2));
            sb1.append(sb.charAt(len-1));
            return sb1.toString();
        }
    }
}
