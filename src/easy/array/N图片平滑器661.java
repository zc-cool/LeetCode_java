/**
 * @author zhucheng
 * @create 2021-04-14-10:58
 */
package easy.array;
//包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值
//求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
//
// 示例 1:
//
//
//输入:
//[[1,1,1],
// [1,0,1],
// [1,1,1]]
//输出:
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
//
//
// 注意:
//
//
// 给定矩阵中的整数范围为 [0, 255]。
// 矩阵的长和宽的范围均为 [1, 150]。
//
// Related Topics 数组
// 👍 72 👎 0
public class N图片平滑器661 {
    /*
    想法和算法
    对于矩阵中的每一个单元格，找所有 9 个包括它自身在内的紧邻的格子。
    然后，我们要将所有邻居的和保存在 ans[r][c] 中，同时记录邻居的数目 count。
    最终的答案就是和除以邻居数目。
     */
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] ans = new int[row][col];

        for (int r = 0; r < row; r++) {   //遍历行
            for (int c = 0; c < col; c++) {  //遍历列
                int sum = 0;     //记录该点和邻居的和
                int count = 0;   //记录邻居的数量
                for (int nr = r-1; nr <= r+1; nr++) {   //遍历邻居（行）
                    for (int nc = c-1; nc <= c+1; nc++) {  //遍历邻居（列）
                        if(0 <= nr && nr < row && 0 <= nc && nc < col){  //符合该条件的才是邻居。
                            sum = sum + M[nr][nc];
                            count++;
                        }
                    }
                }
                ans[r][c] = sum / count;   //计算该点的平均值
            }
        }
        return ans;
    }

    //使用方向数组。
    public int[][] imageSmoother2(int[][] img) {
        //需要和元素周边的进行相加，使用方向数组
        //下面二维数组代表上下左右，左斜上下，右斜上下8个方向。
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1},{-1,1},{-1,-1},{1,-1},{1,1}};

        int row = img.length;
        int column = img[0].length;
        int[][] ans = new int[row][column];

        //遍历img二维数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++){
                int sum = img[i][j];  //sum记录满足条件元素的和，包括自身(起始和为自身值)
                int count = 1;  //count记录共有多少个元素满足条件，包括自身(起始计数1)
                //遍历方向数组
                for (int k = 0; k < 8; k++){
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    //边界条件判断，排除不满足条件的情况
                    if(x < 0 || y < 0 || x == row || y== column) continue;
                    //代码执行到这，说明是满足条件的x和y坐标
                    sum = sum + img[x][y];
                    count++;
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
}
