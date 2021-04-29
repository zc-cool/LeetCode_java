/**
 * @author zhucheng
 * @create 2021-04-28-15:15
 */
package easy.link;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= k <= 50
//
// Related Topics 链表
// 👍 584 👎 0

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class 移除链表元素203 {
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null) return null;

        ListNode ans = new ListNode(0);
        ListNode current = ans;
        while(head != null){
            if(head.val == val){
                current.next = head.next;  //核心代码，覆盖head当前节点
            }else{
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        return ans.next;
    }
}
