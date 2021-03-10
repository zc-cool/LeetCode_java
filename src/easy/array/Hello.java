/**
 * @author zhucheng
 * @create 2021-03-04-16:58
 */
package easy.array;

public class Hello {
    public static void main(String[] args) {
        System.out.println("===");
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int prep = 0;
        int last = nums.length - 1;
        while(prep<last){
            if(nums[prep] != val){
                prep++;
                continue;
            }else {
                if(nums[last] == val){
                    last--;
                    continue;
                }else{
                    int tem = nums[prep];
                    nums[prep] = nums[last];
                    nums[last] = tem;
                    prep++;
                    last--;
                }
            }
        }
        return last+1;
    }
}
