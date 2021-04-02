/**
 * @author zhucheng
 * @create 2021-03-25-10:07
 */
package easy.array;

import java.util.*;

public class Test{
    public static void main(String[] args){
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));

    }

    public static String sortString(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            array[index]++;
        }
        int max = 0;
        for(int j : array){
            max = Math.max(max,j);
        }

        StringBuilder sb = new StringBuilder();
        while(max > 0){
            for(int k=0; k<array.length; k++){
                if(array[k] != 0){
                    char c = (char)(k + 'a');
                    sb.append(c);
                    array[k]--;
                }
            }
            max--;
            if(max != 0){
                for(int n=array.length-1; n>=0; n--){
                    if(array[n] != 0){
                        char ch = (char)(n + 'a');
                        sb.append(ch);
                        array[n]--;
                    }
                }
                max--;
            }
        }
        return sb.toString();
    }

}
