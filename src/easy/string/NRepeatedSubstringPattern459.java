/**
 * @author zhucheng
 * @create 2021-03-25-10:54
 */
package easy.string;
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
// 示例 1:
//
//
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
//输入: "aba"
//
//输出: False
//
//
// 示例 3:
//
//
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
//
// Related Topics 字符串
// 👍 473 👎 0
public class NRepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1) return false;

        int end = s.length()/2;  //最多达到一半的时候，超过一半，不可能组成
        for(int i=0; i<end; i++){
            //字符串的长度必须能整除截取的子串长度，才有可能由该子串重复多次构成
            if(s.length() % (i+1) == 0){
                //截取的目标子串
                String sub = s.substring(0,i+1);
                //剩余的子串
                String subLast = s.substring(i+1);
                //如果两个串长度相等，
                if(subLast.length() == sub.length()){
                    if(subLast.equals(sub)){
                        return true;
                    }else{
                        return false;
                    }
                }
                //否则，剩下的子串长度肯定比目标子串大，
                //这样subLast = subLast.substring(0,i+1)才不会出现越界错误
                //淦！因为substring(0,i+1)不包含i+1。所以当sub长度=subLast长度，调用该方法越界
                while(sub.equals(subLast.substring(0,i+1))){
                    //将subLast重复的sub子串跳过，截取剩下的子串
                    subLast = subLast.substring(i+1);
                    //此时又需要判断两个串长度是否相等，只有不相等的时候，才能进入while循环
                    //其实就是为了避免substring(0,i+1)出现越界。
                    if(subLast.length() == sub.length()){
                        if(subLast.equals(sub)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            //截取的长度都不能被总长度整除，肯定不能重复组成
        }
        return false;
    }
}
