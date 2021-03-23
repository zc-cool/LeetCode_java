/**
 * @author zhucheng
 * @create 2021-03-17-16:14
 */
package easy.string;

public class Test {
    public static void main(String[] args) {

    }

    public static String addStrings(String num1, String num2) {
        num1 = new StringBuilder(num1.length()).append(num1).reverse().toString();
        num2 = new StringBuilder(num2.length()).append(num2).reverse().toString();

        char[] chars;
        char[] chars1;
        int len;
        if(num1.length() >= num2.length()){
            chars = num1.toCharArray();
            chars1 = num2.toCharArray();
            len = num2.length();
        }else{
            chars = num2.toCharArray();
            chars1 = num1.toCharArray();
            len = num1.length();
        }

        int flag = 0;
        for(int i=0; i<len; i++){
            int tem = chars[i] + chars1[i] + flag;
            if(tem >= 10){
                chars[i] = (char)(tem-10);
                flag = 1;
            }else{
                flag = 0;
            }
        }

        String s = new String(chars);
        return new StringBuilder(s.length()).append(s).reverse().toString();
    }
}
