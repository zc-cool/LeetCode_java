/**
 * @author zhucheng
 * @create 2021-03-13-20:08
 */
package easy.dfs;

/*
描述：给定一个全大写的字符串，输出所有组合，并存储在字符数组中
例如：输入：ABC
     输出:A B C
          A C B
          B A C
          B C A
          C A B
          C B A
 */
public class RangeChar {
    public static void main(String[] args) {
        String s = "ABC";
        boolean[] b = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();

        dfs(s,b,1,sb);
    }

    public static void dfs(String s,boolean[] b,int level,StringBuilder sb){
        //1.结束条件。当深度level达到字符串的长度时，结束。
        if(level == s.length()+1){
            System.out.println(sb.toString());
            return;
        }
        //2.遍历候选节点
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i); //获取当前路径下的字符
            if(!b[i]){
                sb.append(c);
                b[i] = true;
                dfs(s,b,level+1,sb);
                sb.deleteCharAt(sb.length()-1);
                b[i] = false;
            }
        }
    }
}
