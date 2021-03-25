/**
 * @author zhucheng
 * @create 2021-03-25-10:26
 */
package easy.string;
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。
//
// 示例:
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
//
// Related Topics 字符串
// 👍 81 👎 0
public class CountSegments434 {
    public int countSegments(String s) {
        //1.如果字符串为空，返回0
        if(s.equals("")) return 0;
        //2.用空格来分割字符串
        String[] str = s.split(" ");
        //3.如果数组中是空，则不记录。判断
        int count = str.length;
        for(int i=0; i<str.length; i++){
            if(str[i].equals("")){  //注意：不能是str[i].equals(" ")
                count--;
            }
        }
        return count;
    }
}
