/**
 * @author zhucheng
 * @create 2021-04-09-13:59
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 224 👎 0
public class NSpiralOrder_Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        //边界条件
        if(matrix==null||matrix.length==0) return new int[]{};

        int m = matrix.length;  //行
        int n = matrix[0].length; //列
        int[] ans = new int[m * n];

        List<Integer> list = new ArrayList<>();
        //起始外圈的四个边界顶点
        int c1 = 0;
        int c2 = n-1;
        int r1 = 0;
        int r2 = m-1;
        //顺时针打印几圈   由行和列中最小的一个值来决定。Math.min(m,n)/2不是整数的时候，应该向上取。表示一圈
        int time = Math.min(m,n) % 2 == 0 ? Math.min(m,n)/2 : Math.min(m,n)/2+1;
        //循环打印圈数
        for (int i = 0; i < time; i++) {
            for(int c = c1; c <= c2; c++) list.add(matrix[r1][c]);  //打印一圈的第一行
            for(int r = r1+1; r <= r2; r++) list.add(matrix[r][c2]); //打印一圈的第一行末尾竖列
            if(r1 < r2 && c1 < c2){
                for(int c = c2 - 1; c > c1; c--) list.add(matrix[r2][c]); //打印一圈最下面一行
                for(int r = r2; r > r1; r--) list.add(matrix[r][c1]);  //打印一圈左便竖列
            }
            //下一圈的四个边界顶点
            r1++;
            r2--;
            c1++;
            c2--;
        }
        //将集合中的元素装到数组中
        for (int k = 0; k < ans.length; k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}
