/**
 * @author zhucheng
 * @create 2021-03-13-13:31
 */
package medium.dp;

import java.util.Arrays;

/*给定一个数组，满足一下规则
  1.选出的数字不能是相邻的两个
  2.使得选中的数字加起来最大
  例如：[4,1,1,9,1]   选择4，9结果最大为13
 */
public class DpRob {
    public static void main(String[] args) {
        int[] array = {1,2,4,1,7,8,-8};
        int i = array.length - 1;
        //int value = rec_opt(array,i);
        int value = dp_opt(array);
        System.out.println(value);
    }

    //第一种方法：使用递归
    /*
   分析：假设给定数组array = [1,2,4,1,7,8,3]
        从数组最后开始思考。假定数组最后一个元素，有两种结果：选或者不选
        (1).选中最后一个元素，其最优解opt(6) = opt(4) + array[6]。因为相邻的不能选择，所以最接近的只能选择下标为4的元素
        (2).不选最后一个元素，其最优解opt(6) = opt(5)。
        然后，针对选或者不选这两种最优解，选择其中最大的为最优解。opt(6) = max[opt(4)+array[6], opt(5)]
        ....针对上面结果的opt(4)和opt(5)依次按照上述选或者不选的思路进行展开。。。
        得到下面递归式：
          opt(i) = max[opt(i-2) + array[i], opt(i-1)];
          其中：opt(i-2) + array[i]为选择i下标的元素最优解，opt(i-1)为不选i下标的元素最优解

          递归出口：
          当i==0,说明数组中只有一个元素，opt(0) = array[0];
          当i==1,说明数组中只有两个元素，opt(1) = max(array[0],array[1]);
     */
    public static int rec_opt(int[] array,int i){
        if(i == 0){
            return array[0];
        }else if(i == 1){
            return Math.max(array[0],array[1]);
        }else{
            return Math.max(rec_opt(array,i-2) + array[i],rec_opt(array,i-1));
        }
    }

    //第二种方法：使用动态规划
    /*
    分析：上述使用递归，时间复杂度将达到2的n次方。
        使用动态规划，利用dp数组存放每一步计算出的最大值。所以最后的结果就是dp数组最后的值
        申请一个和原数组同等大小的dp数组。借助上面递归算法的思想。
        第一步：dp[0] = array[0]; 如果数组只有一个元素，最大值只能是array[0]
        第二步：dp[1] = max(array[0],array[1]); 如果数组中只有两个元素，最优解只能是两者中大的那个，因为题目要求不能相邻。
        第三步：如果数组长度大于2，则dp[i] = max(dp[i-2]+array[i], dp[i-1]); i从2开始。
               其中dp[i-2]+array[i]为选择下标i的最优解，dp[i-1]为不选i下标的最优解。
        第四步：由于每一步dp数组都是存储最优解，所以遍历整个数组结束，dp数组的末尾就是所要求得的最优解。
     */
    public static int dp_opt(int[] array){
        //申请一个dp数组，大小和原来数组arr一样大
        int[] dp = new int[array.length];
        dp[0] = array[0];  //如果数组只有一个元素，最大值只能是array[0]
        dp[1] = Math.max(array[0],array[1]); //如果数组中只有两个元素，最优解只能是两者中大的那个，因为题目要求不能相邻。

        //如果数组长度大于2，则dp[i] = max(dp[i-2]+array[i], dp[i-1]); i从2开始。
        for (int j = 2; j <array.length; j++) {
            dp[j] = Math.max(dp[j-2] + array[j], dp[j-1]);
        }
        //由于每一步dp数组都是存储最优解，所以遍历整个数组结束，dp数组的末尾就是所要求得的最优解。
        return dp[array.length -1];
    }
}
