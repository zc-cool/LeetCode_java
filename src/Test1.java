/**
 * @author zhucheng
 * @create 2021-04-11-14:24
 */

public class Test1 {
    public static void main(String[] args) {
        int[] a = {3,6,9,3,2,5,7,4};
        findMin(a);
    }

    public static void findMin(int[] a){
        int i = 0;
        int k = i;
        for (int j = i+1; j < a.length; j++) {
            if(a[k] > a[j]){
                k = j;
            }
        }
        System.out.println(a[k]);
    }
}
