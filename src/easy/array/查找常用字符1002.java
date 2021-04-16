/**
 * @author zhucheng
 * @create 2021-04-15-17:11
 */
package easy.array;

import java.util.ArrayList;
import java.util.List;

//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
//
//
// 示例 2：
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] 是小写字母
//
// Related Topics 数组 哈希表
// 👍 208 👎 0
public class 查找常用字符1002 {
    public List<String> commonChars(String[] A) {
        //list集合用于将所有公共部分的元素装进来
        List<String> list = new ArrayList<>();

        //将数组第一个字符串作为对比目标
        String target = A[0];
        int[] bucket = new int[26];
        for(char c : target.toCharArray()) bucket[c-'a']++;

        //遍历字符串数组，将其中每一个字符串都映射为一个bucket
        for (int i = 1; i < A.length; i++) {
            //将每一个字符串都映射为一个bucket
            String str = A[i];
            int[] bucket1 = new int[26];
            for(char c : str.toCharArray()) bucket1[c-'a']++;

            //调用ans方法，将bucket更新
            bucket = ans(bucket,bucket1);
        }

        //遍历bucket，将bucket中值不为0的下标变成字符串添加bucket[i]次
        for (int i = 0; i < 26; i++) {
            while(bucket[i] > 0){
                list.add(String.valueOf((char)(i+'a')));
                bucket[i]--;
            }
        }
        return list;
    }

    //找到两个数组公共部分，并更新公共部分的最小值。其它不是公共部分的值变为0
    public int[] ans(int[] bucket,int[] bucket1){
        boolean[] flag = new boolean[26];  //标记哪个位置进行了修改（说明该位置元素是两个数组公有的）
        for (int i = 0; i < 26; i++) {
            if(bucket[i] != 0 && bucket1[i] != 0){
                bucket[i] = Math.min(bucket[i],bucket1[i]);
                flag[i] = true;   //true，表示i位置是两个数组公有的。
            }
        }
        for (int i = 0; i < 26; i++) {
            if(!flag[i]){
                bucket[i] = 0;
            }
        }
        return bucket;
    }
}
