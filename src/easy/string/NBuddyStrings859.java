/**
 * @author zhucheng
 * @create 2021-03-30-15:39
 */
package easy.string;

import java.util.HashSet;
import java.util.Set;

//给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
//
// 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标
// 0 和下标 2 的元素可以生成 "cbad" 。
//
//
//
// 示例 1：
//
//
//输入： A = "ab", B = "ba"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
//
// 示例 2：
//
//
//输入： A = "ab", B = "ab"
//输出： false
//解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
//
//
// 示例 3:
//
//
//输入： A = "aa", B = "aa"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。
//
// 示例 4：
//
//
//输入： A = "aaaaaaabc", B = "aaaaaaacb"
//输出： true
//
//
// 示例 5：
//
//
//输入： A = "", B = "aa"
//输出： false
//
//
//
//
// 提示：
//
//
// 0 <= A.length <= 20000
// 0 <= B.length <= 20000
// A 和 B 仅由小写字母构成。
//
// Related Topics 字符串
// 👍 140 👎 0
public class NBuddyStrings859 {
    public boolean buddyStrings(String a, String b) {
        //边界条件，如果ab长度不相等，或者a，b的长度小于2，不能满足两个位置交换，返回false
        if(a.length() != b.length() || a.length() < 2 || b.length() < 2) return false;
        //细节判断
        //如果a和b相等，但是a中不存在重复元素，则无论怎么交换两个元素，也不可能满足题意。可利用set去重判断先后长度
        if(a.equals(b)){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<a.length(); j++) set.add(a.charAt(j));
            if(set.size() != a.length()){  //去重后，长度不等，说明有重复元素，满足题意
                return true;
            }else{              //否则，说明a和b中不存在重复元素，返回false
                return false;
            }
        }

        //一般条件。a和b相等，但是a和b不相等。遍历a元素，找出a和b不相等的字符下标。并计数
        //如果不相等数大于2，不满足题意，false
        //遍历结束，如果计数个数不等于2，不满足题意，false
        //计数等于2，并且交换该位置a和b相等，true。否则false
        int diff = 0;
        char[] c1 = new char[2];   //有优化方案。可以不用数组
        char[] c2 = new char[2];
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff <= 2) {
                    c1[diff-1] = a.charAt(i);
                    c2[diff-1] = b.charAt(i);
                } else {
                    return false;
                }
            }
        }
        if(diff != 2){
            return false;
        }else if(c1[0] == c2[1] && c1[1] == c2[0]){
            return true;
        }else{
            return false;
        }
    }

    public boolean buddyStrings2(String a, String b) {
        if(a.length() != b.length() || a.length() < 2 || b.length() < 2) return false;
        if(a.equals(b)){
            Set<Character> set = new HashSet<>();
            for(int j=0; j<a.length(); j++) set.add(a.charAt(j));
            if(set.size() != a.length()){
                return true;
            }else{
                return false;
            }
        }

        int diff = 0;
        int diffIndex1 = -1;
        int diffIndex2 = -1;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff == 1) {
                    diffIndex1 = i;
                }else if(diff == 2){
                    diffIndex2 = i;
                } else if(diff > 2) {
                    return false;
                }
            }
        }
        return diff == 2 && a.charAt(diffIndex1) == b.charAt(diffIndex2) && a.charAt(diffIndex2) == b.charAt(diffIndex1);
    }
}
