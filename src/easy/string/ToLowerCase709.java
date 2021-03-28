/**
 * @author zhucheng
 * @create 2021-03-26-13:10
 */
package easy.string;
//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//
//
// 示例 1：
//
//
//输入: "Hello"
//输出: "hello"
//
// 示例 2：
//
//
//输入: "here"
//输出: "here"
//
// 示例 3：
//
//
//输入: "LOVELY"
//输出: "lovely"
//
// Related Topics 字符串
// 👍 145 👎 0
public class ToLowerCase709 {
    public String toLowerCase(String str) {
        if(str == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                char c = (char)(str.charAt(i) + 32);
                sb.append(c);
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
