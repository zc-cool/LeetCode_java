/**
 * @author zhucheng
 * @create 2021-04-29-13:32
 */
package easy.link;
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//
//
// 示例：
//
//
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
// Related Topics 链表 双指针
// 👍 185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 剑指Offer22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node1 = head, node2 = head;
        //1.遍历链表，得到链表长度
        int len = 0;
        while(node1 != null){
            len++;
            node1 = node1.next;
        }
        //2.找到倒数第k个节点在链表中的位置
        if(len < k) return null;
        int index = len - k;
        while(index > 0){
            index--;
            node2 = node2.next;
        }
        return node2;
    }
}
