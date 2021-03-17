/**
 * @author zhucheng
 * @create 2021-03-16-16:59
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//
// 示例1:
//
//
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
//
//
// 示例2:
//
//
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//
//
// 提示：
//
//
// 字符串长度在[0, 50000]范围内。
//
// Related Topics 字符串
// 👍 75 👎 0
public class CompressString0106 {
    //面试题[01-06]
    public static void main(String[] args) {
        String s = "aabcccccaa";
        String ss = compressString(s);
        System.out.println(ss);
    }
    /*
    思路：申请一个list集合。双指针遍历字符串，i,j刚开始指向字符串首字符。list.add(S.charAt(i));
          count计数遍历过程中重复字符的个数。
          j指针向后移动，count+1.当出现比较不相等的字符时，将i指针移到j。list.add(count)将重复
          的次数添加到集合。
          重复上述过程，直到遍历结束。比较list和字符串的长度。list的长度大，返回原字符串；否则
          返回list组成的字符串。
     */

    //看了别人写的，突然想到。应该申请一个StringBuilder，而不是list集合。淦！！！
    public static String compressString(String S) {
        List<Object> list = new ArrayList<>();  //定义一个list集合

        int j;
        for (int i = 0; i < S.length(); i++) {
            int count = 0;
            list.add(S.charAt(i));

            for(j = i; j< S.length(); j++){
                if(S.charAt(i) == S.charAt(j)){
                    count++;
                    continue;
                }
                break;
            }
            i = j -1;
            list.add(count);
        }

        if(list.size() >= S.length()){
            return S;
        }else{
            StringBuilder s = new StringBuilder();
            for(Object o : list){
                s.append(o);
            }
            return s.toString();
        }
    }
}
