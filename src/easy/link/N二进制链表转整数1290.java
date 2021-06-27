/**
 * @author zhucheng
 * @create 2021-04-30-10:33
 */
package easy.link;
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
//
//
// 示例 2：
//
// 输入：head = [0]
//输出：0
//
//
// 示例 3：
//
// 输入：head = [1]
//输出：1
//
//
// 示例 4：
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
//
//
// 示例 5：
//
// 输入：head = [0,0]
//输出：0
//
//
//
//
// 提示：
//
//
// 链表不为空。
// 链表的结点总数不超过 30。
// 每个结点的值不是 0 就是 1。
//
// Related Topics 位运算 链表
// 👍 80 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class N二进制链表转整数1290 {
    //方法1：使用StringBuilder将链表元素值都添加进来，
    //从末尾向前遍历，将每一位乘以2得n次方（使用1左移实现）
    public int getDecimalValue1(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        String str = sb.toString();

        int ans = 0;
        for (int i = str.length()-1,j = 0; i >= 0; i--,j++) {
            ans = ans + (str.charAt(i)-'0') * (1 << j);
        }
        return ans;
    }

    //方法2：优化
    /*
    由于链表中从高位到低位存放了数字的二进制表示，因此我们可以使用二进制转十进制的方法，
    在遍历一遍链表的同时得到数字的十进制值。
    我们是不是有必要一定要先知道链表的长度，才可以确定指数 22 呢？答案是不必要的。
    每读取链表的一个节点值，可以认为读到的节点值是当前二进制数的最低位；
    当读到下一个节点值的时候，需要将已经读到的结果乘以 22，再将新读到的节点值当作当前二进制数的最低位；
    如此进行下去，直到读到了链表的末尾。
     */
    public int getDecimalValue2(ListNode head) {
        int ans = 0;
        while (head != null){
            ans = 2 * ans + head.val;
            head = head.next;
        }
        return ans;
    }
}
