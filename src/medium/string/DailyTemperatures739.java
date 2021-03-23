/**
 * @author zhucheng
 * @create 2021-03-23-10:52
 */
package medium.string;
/*
请根据每日 气温 列表，重新生成一个列表。
对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 
temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。
每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] T) {
        /*
        1.边界判断，如果只有一个元素，直接返回T,其中T[0] = 0
        2.双指针i和j，使用双循环。 i负责遍历数组，j负责遍历i指针后面的数组，
        和i下标下的元素比较大小。count计数记录比较过程。时间复杂度O(n2),空间复杂度O(1)
        */
        //1.边界判断，如果只有一个元素，直接返回T,其中T[0] = 0
        if(T.length == 1){
            T[0] = 0;
            return T;
        }
        //2.双指针，i和j。 i负责遍历数组，j负责遍历i指针后面的数组，和i下标下的元素比较大小
        //count计数记录比较过程
        for(int i=0; i<T.length; i++){
            int count = 0;
            for(int j=i; j<T.length; j++){
                if(T[i] < T[j]){
                    T[i] = count;
                    break;
                }else if(j == T.length-1){
                    T[i] = 0;
                    break;
                }else{
                    count++;
                }
            }
        }
        return T;
    }
}
