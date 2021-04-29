/**
 * @author zhucheng
 * @create 2021-04-29-14:07
 */
package easy.link;
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针
// 👍 67 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 面试题0202_返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        //双指针，指向头节点
        ListNode node1 = head, node2 = head;
        //1.遍历链表，获得链表长度
        int len = 0;
        while(node1 != null){
            len++;
            node1 = node1.next;
        }
        //2.计算k节点在链表中的index
        //再次遍历链表
        int index = len - k;
        while(index > 0){
            index--;
            node2 = node2.next;
        }
        return node2.val;
    }
}
