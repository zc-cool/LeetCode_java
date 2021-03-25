/**
 * @author zhucheng
 * @create 2021-03-25-10:07
 */
package easy.array;

public class Test {
    public static void main(String[] args) {
        String s = "      abcd";
        String[] str = s.split(" ");
        System.out.println(str.length);
        System.out.println(str[6].equals("abcd")); //true
    }
}
