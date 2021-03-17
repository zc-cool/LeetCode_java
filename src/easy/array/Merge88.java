/**
 * @author zhucheng
 * @create 2021-03-15-9:16
 */
package easy.array;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 800 👎 0
public class Merge88 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        merge2(nums1,1,nums2,0);

        for(int i : nums1){
            System.out.println(i);
        }
    }
    //方法1：使用API
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    //方法2：使用双指针进行merge。从nums1后向前进行merge操作.注意：要从后向前进行merge。
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int index3 = m+n-1;

        while(index1>=0 && index2>=0){
            if(nums1[index1] > nums2[index2]){
                nums1[index3--] = nums1[index1--];  //merge后都向前移动一位。
            }else{
                nums1[index3--] = nums2[index2--];
            }
        }
        //如果index1>=0，说明，nums2数组元素全部merge到nums1.则nums1已经排好序
        //如果index2>=0，说明，nums2数组剩下的元素都是最小的，应该merge到nums1数组最前面
        if(index2 >= 0){
            nums1[index3--] = nums2[index2--];
        }
    }
}
