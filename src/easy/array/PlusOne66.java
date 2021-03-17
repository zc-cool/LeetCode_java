/**
 * @author zhucheng
 * @create 2021-03-14-22:26
 */
package easy.array;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 644 👎 0
public class PlusOne66 {
    //第一版：自己写的
    public int[] plusOne(int[] digits) {
        //思路:关键是加1，观察题目，数组长度在1-100之间。所以不可以将数组转为整数进行加1.因为转成的
        //整数超出了整数表示范围。只能使用遍历数组的方式进行处理。
        //考虑两种情况：
        // 1.当数组中元素全为9的时候，数组长度加1，数组中元素第一位为1，其余为0
        // 2.否则，数组长度不变，从后向前遍历数组，如果元素是9，则置为0，向前一位。否则元素加1，结束return。

        //第一步，遍历整个数组。判断数组中元素是否全为9
        boolean flag = false;
        for(int i : digits){
            if(i == 9){
                continue;
            }else{
                flag = true;
                break;
            }
        }
        //第二步，如果数组中元素不是全为9，则从后向前遍历数组，进行加1
        if(flag){
            for (int i = digits.length-1; i >= 0 ; i--) {
                if(digits[i] == 9){
                    digits[i] = 0;
                }else{
                    digits[i] = digits[i] + 1;
                    break;
                }
            }
            return digits;
        }else{   //否则，数组中元素全为9，则数组长度加1，数组第一个元素置为1，其余为0
            int[] target = new int[digits.length + 1];
            target[0] = 1;
            return target;
        }
    }

    //第二版：看别人写的,自己改进版
    public int[] plusOne2(int[] digits){
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i] = digits[i] + 1;  //从数组末尾开始+1
            if(digits[i] != 10){     //判断，如果+1后值不为10，说明元素不是9，没有进位。
                return digits;       //数组长度不变。直接返回
            }
            digits[i] = 0;   //如果+1后值为10，说明元素是9，产生进位，将该位置置为0，指针向前移动一位。
        }
        //程序能够执行到这，说明上面结果数组中元素全为0
        //即数组digit中原先元素全为9.
        //此时返回的结果数组长度应该+1.数组第一位是1，其余是0.
        int[] target = new int[digits.length+1];
        target[0] = 1;
        return target;
    }
}
