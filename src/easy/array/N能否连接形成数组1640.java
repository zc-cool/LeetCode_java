/**
 * @author zhucheng
 * @create 2021-04-16-14:09
 */
package easy.array;
//给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pi
//eces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：arr = [85], pieces = [[85]]
//输出：true
//
//
// 示例 2：
//
//
//输入：arr = [15,88], pieces = [[88],[15]]
//输出：true
//解释：依次连接 [15] 和 [88]
//
//
// 示例 3：
//
//
//输入：arr = [49,18,16], pieces = [[16,18,49]]
//输出：false
//解释：即便数字相符，也不能重新排列 pieces[0]
//
//
// 示例 4：
//
//
//输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//输出：true
//解释：依次连接 [91]、[4,64] 和 [78]
//
// 示例 5：
//
//
//输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= pieces.length <= arr.length <= 100
// sum(pieces[i].length) == arr.length
// 1 <= pieces[i].length <= arr.length
// 1 <= arr[i], pieces[i][j] <= 100
// arr 中的整数 互不相同
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
//
// Related Topics 排序 数组 哈希表
// 👍 23 👎 0
public class N能否连接形成数组1640 {
    /*
    思路：题目说了所有整数都不重复，所以可以这样做
    遍历一位数组arr，定位到第一个元素，然后遍历二维数组pieces，
    设置一个遍历flag用于标记。如果二维数组中有元素的首元素等于arr中定位的元素
    即pieces[j][0]==arr[i]，将标记改变。如果遍历整个二维数组都没有，即标记没有改变
    则说明肯定不能满足题意，返回false。
    如果存在pieces[j][0]==arr[i]。记int[] p = pieces[j]则继续遍历二维数组中该元素(一维数组)p[]
    如果一维数组的元素和arr数组元素对应相等，将i指针移到i+p.length处。
    如果一维数组的元素和arr数组元素没有全部对应相等，则返回false。
    遍历arr结束，则说明满足，返回true。
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len1 = arr.length;  //一位数组长度
        int len2 = pieces.length; //二维数组长度
        for (int i = 0; i < len1; ) {  //遍历一位数组
            boolean flag = true;  //标记二维数组中，是否存在元素一维数组的首元素等于el
            int el = arr[i];
            for (int j = 0; j < len2; j++) {  //遍历二维数组
                int[] p = pieces[j];
                if(p[0] == el){   //如果二维数组的元素(一维数组)的首元素==el
                    flag = false;
                    int pIndex = 0;
                    while(pIndex < p.length && p[pIndex] == arr[i]){  //遍历该一维数组
                        pIndex++;
                        i++;
                    }
                    //遍历结束，如果pIndex != p.length，说明不满足
                    if(pIndex != p.length){
                        return false;
                    }else{   //否则，说明该二维数组的元素的arr的一部分，二维数组此次查找结束，break。
                        break;  //i指针已经移动到指定位置了，进入arr遍历循环
                    }
                }
            }

            if(flag){
                return false;
            }
        }
        return true;
    }

    //和方法1思想一样，实现代码略有不同
    public boolean canFormArray2(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length; ) {
            int element = arr[i];
            int index = i; //下标记录i指针是否发生移动

            for (int j = 0; j < pieces.length; j++) {
                //一维数组首元素
                int tem = pieces[j][0];
                //当一维数组首元素和arr当前下标元素相同，进入判断
                if(element == tem){
                    //判断pieces[j]一维数组的元素和arr[i]元素是否一样
                    for (int k = 0; k < pieces[j].length; k++) {
                        if(arr[i] != pieces[j][k]){
                            return false;
                        }
                        i++;
                    }
                    //代码执行到这，说明目前出现符合的pieces的一维数组
                    break; //跳出二维数组的循环 for (int j = 0; j < pieces.length; j++) { }
                }
            }
            //代码执行到这，说明二维数组循环结束，如果i没有发生移动
            //说明遍历完pieces二维数组，也没有找到符合一维数组首字母=arr[i]
            if(i == index){
                return false;
            }
        }
        return true;
    }
}
