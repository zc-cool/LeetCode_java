/**
 * @author zhucheng
 * @create 2021-04-14-15:30
 */
package easy.array;
//有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
//
// 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
//
// 示例 1:
//
//
//输入:
//bits = [1, 0, 0]
//输出: True
//解释:
//唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
//
//
// 示例 2:
//
//
//输入:
//bits = [1, 1, 1, 0]
//输出: False
//解释:
//唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
//
//
// 注意:
//
//
// 1 <= len(bits) <= 1000.
// bits[i] 总是0 或 1.
//
// Related Topics 数组
// 👍 174 👎 0
public class 一比特与两比特字符717 {
    /*
    思路：
        最后一位的前面一位如果是0，则满足
        最后一位的前面如果是1，并且前面连续的1是偶数，则满足。如果前面连续的1是奇数，则不满足
     */
    public boolean isOneBitCharacter(int[] bits) {
        //边界条件
        int len = bits.length;
        if(len == 1) return true;

        //如果最后一位的前面一位是0，则一定满足。因为最后一位必定是一个比特
        if(bits[len-2] == 0) return true;
        //程序执行到这，说明最后一位的前面一位是1。
        int index = len-2;
        //count记录最后一位前面连续1的个数
        int count = 0;
        while(index >= 0 && bits[index] == 1){
            count++;
            index--;
        }
        //如果count是偶数，则最后一位前面连续1都是两比特11。最后一位是一比特0，满足
        //如果count是奇数，则不满足
        return count % 2 == 0 ? true : false;
    }

    //和上面方法一样，只是看起来简便一些。。。
    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length;
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                count += 1;
            } else {
                break;
            }
        }
        return count % 2 == 0;
    }
}
