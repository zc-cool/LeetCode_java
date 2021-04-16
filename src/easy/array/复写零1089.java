/**
 * @author zhucheng
 * @create 2021-04-15-10:29
 */
package easy.array;
//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
// 注意：请不要在超过该数组长度的位置写入元素。
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
//
//
//
// 示例 1：
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//
//
// 示例 2：
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10000
// 0 <= arr[i] <= 9
//
// Related Topics 数组
// 👍 81 👎 0
public class 复写零1089 {
    public void duplicateZeros(int[] arr) {
        //1.先计算出数组下标什么位置到达末尾
        int arrLen = arr.length;  //数组的长度
        int index = 0;  //记录结束下标
        int len = 0;    //记录复写0后的长度
        boolean flag = false;  //定义一个哨兵，用于标记末尾0是复写一次还是两次。
        for (int i = 0; i < arrLen; i++) {
            if(arr[i] != 0){            //如果下标位置不是0，则len+1。
                len += 1;
            }else if(len+1 == arrLen){  //如果下标位置是0，并且len+1==arrLen，说明是末尾0且复写1次。
                len += 1;
                flag = true;
            }else {                     //否则，说明0需要复写两次，len长度==len+2
                len += 2;
            }
            //当len==arrLen时，记录下index，跳出循环
            if(len == arrLen){
                index = i;
                break;
            }
        }
        //2.从index开始向前遍历，将数组中的元素进行覆盖
        for (int i = index; i >= 0; i--) {
            if(arr[i] != 0){           //下标不是0.直接覆盖
                arr[--arrLen] = arr[i];
            }else if(i == index && flag){  //下标是0，并且flag是true，说明是末尾复写1次的0
                arr[--arrLen] = 0;
            }else{                 //否则，说明该位置是0，且需要被复写两次
                arr[--arrLen] = 0;
                arr[--arrLen] = 0;
            }
        }
    }
}
