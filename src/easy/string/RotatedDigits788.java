/**
 * @author zhucheng
 * @create 2021-03-26-13:39
 */
package easy.string;
//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
//
//
//
// 示例：
//
// 输入: 10
//输出: 4
//解释:
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
//
//
//
//
// 提示：
//
//
// N 的取值范围是 [1, 10000]。
//
// Related Topics 字符串
// 👍 89 👎 0
public class RotatedDigits788 {
    /*
    思路：
    将每一个整数变成字符串，遍历每一个字符串，如果字符串中不含有2或者5.或者6.或者9.则这个数肯本不是好数
    如果在含有上述4个中的一个或多个情况下，必须保证不能再含有（3，4，7）
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N ; i++) {
            String str = String.valueOf(i);
            if(!str.contains("2") && !str.contains("5") && !str.contains("6") && !str.contains("9")){
                continue;
            }else if(!str.contains("3") && !str.contains("4") && !str.contains("7")){
                count++;
            }
        }
        return count;
    }
}
