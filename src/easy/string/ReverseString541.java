/**
 * @author zhucheng
 * @create 2021-03-19-11:03
 */
package easy.string;
//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例:
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
//
//
// 提示：
//
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串
// 👍 117 👎 0
public class ReverseString541 {
    public String reverseStr(String s, int k) {
        if(s == null) return null;
        if(s.length() == 0) return s;

        int l = k + k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i=i+l) {
            if(s.substring(i).length() <= k){
                StringBuilder sbb = new StringBuilder();
                sb.append(sbb.append(s.substring(i)).reverse());
                break;
            }else if(s.substring(i).length() > k && s.substring(i).length() < l){
                String s1 = s.substring(i,k+i);
                String s2 = s.substring(k+i);
                StringBuilder sbb = new StringBuilder();
                sb.append(sbb.append(s1).reverse()).append(s2);
                break;
            }
            String ss = s.substring(i,i+l);
            String s1 = ss.substring(0,k);
            String s2 = ss.substring(k);
            StringBuilder sbb = new StringBuilder();
            sb.append(sbb.append(s1).reverse()).append(s2);
        }
        return sb.toString();
    }
}
