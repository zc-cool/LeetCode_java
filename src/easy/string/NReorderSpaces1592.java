/**
 * @author zhucheng
 * @create 2021-03-30-13:24
 */
package easy.string;
//给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证
//text 至少包含一个单词 。
//
// 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也
//意味着返回的字符串应当与原 text 字符串的长度相等。
//
// 返回 重新排列空格后的字符串 。
//
//
//
// 示例 1：
//
// 输入：text = "  this   is  a sentence "
//输出："this   is   a   sentence"
//解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
//
//
// 示例 2：
//
// 输入：text = " practice   makes   perfect"
//输出："practice   makes   perfect "
//解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
//
//
// 示例 3：
//
// 输入：text = "hello   world"
//输出："hello   world"
//
//
// 示例 4：
//
// 输入：text = "  walks  udp package   into  bar a"
//输出："walks  udp  package  into  bar  a "
//
//
// 示例 5：
//
// 输入：text = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 100
// text 由小写英文字母和 ' ' 组成
// text 中至少包含一个单词
//
// Related Topics 字符串
// 👍 9 👎 0
public class NReorderSpaces1592 {
    public String reorderSpaces(String text) {
        //String text = "  this   is  a sentence ";
        /*
        注意，不能轻易使用split(" ")进行切割。
         */
        //1.统计字符串中空格的数量   (只能使用这种方式获取空格，不能使用split(" ")方法)
        int blankCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' '){
                blankCount++;
            }
        }
        //2.统计字符串中单词的数量   (可以使用split(" ")方法，只要str[i]元素不为空，就说明该元素是单词)
        int wordCount = 0;
        String[] str = text.split(" ");
        for(int j = 0; j < str.length; j++){
            if(!str[j].equals("")){
                wordCount++;
            }
        }
        //3.如果单词数量为1，直接返回单词+空格
        if(wordCount == 1){
            StringBuilder sb = new StringBuilder();
            for(int k=0; k < str.length; k++){
                if(!str[k].equals("")){
                    sb.append(str[k]);
                    for(int o=0; o<blankCount; o++){
                        sb.append(' ');
                    }
                }
            }
            return sb.toString();
        }else{
            //4.否则，计算单词之间平均的空格数
            int aveBlank = blankCount / (wordCount-1);
            //5.计算剩余的空格数
            int lastBlank = blankCount % (wordCount-1);
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<str.length; k++){
                if(!str[k].equals("") && wordCount != 1){  //如果该元素是单词，并且还没到最后一个单词时
                    sb.append(str[k]);                     //添加该单词，并且添加平均数个空格
                    wordCount--;
                    for(int o=0; o<aveBlank; o++){
                        sb.append(' ');
                    }
                }else if(!str[k].equals("") && wordCount == 1){  //如果该元素是单词，并且已经达到最后一个单词
                    sb.append(str[k]);                           //添加该单词，并且添加剩余数量的空格
                    for(int l=0; l<lastBlank; l++){
                        sb.append(' ');
                    }
                }
            }
            return sb.toString();
        }
    }
}
